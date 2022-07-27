package br.com.zup.edu.commerce.notasfiscais.service;

import br.com.zup.edu.commerce.notasfiscais.notas.NotaFiscal;
import br.com.zup.edu.commerce.notasfiscais.notas.NotaFiscalRepository;
import br.com.zup.edu.commerce.notasfiscais.notas.StatusNotaFiscal;
import br.com.zup.edu.commerce.notasfiscais.util.XMLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.File;
import java.util.List;

@Service
@EnableScheduling
public class NotificaCompradorJob {

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    @Autowired
    private EnviadorEmailService enviadorEmailService;

    @Autowired
    private XMLUtil xmlUtil;

    @Value("${mail.remetente.commerce}")
    private String remetente;

    @Value("${mail.assunto}")
    private String assunto;

    @Value("${mail.corpo}")
    private String corpo;

    @Value("${mail.anexo.nome}")
    private String nomeArquivo;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Scheduled(
            fixedDelayString = "${job.notificador-comprador.fixed-delay}",
            initialDelayString = "${job.notificador-comprador.initial-delay}"
    )
    public void notificaComprador() {

        Boolean pendente = true;

        while(pendente) {

            pendente = transactionTemplate.execute((status) -> {

                List<NotaFiscal> notasGeradas = this.notaFiscalRepository.findTop5ByStatusOrderByCriadaEm(StatusNotaFiscal.GERADA);

                if (notasGeradas.isEmpty()) {
                    return false;
                }

                notasGeradas.forEach(nota -> {

                    try {

                        File notaFiscalXML = xmlUtil.converteObjetoParaArquivoXML(new NotaFiscalDto(nota), nomeArquivo);

                        enviadorEmailService.envia(
                                remetente,
                                nota.retornaEmailComprador(),
                                assunto,
                                corpo.formatted(nota.getCodigoPedido()),
                                notaFiscalXML,
                                nomeArquivo
                        );

                        nota.alteraStatusEnviadaComprador();

                        this.notaFiscalRepository.save(nota);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

                return true;

            }); // Aqui é realizado o commit da transação.

        }

    }

}
