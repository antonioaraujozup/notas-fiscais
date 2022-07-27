package br.com.zup.edu.commerce.notasfiscais.service;

import br.com.zup.edu.commerce.notasfiscais.notas.NotaFiscal;
import br.com.zup.edu.commerce.notasfiscais.notas.NotaFiscalRepository;
import br.com.zup.edu.commerce.notasfiscais.notas.StatusNotaFiscal;
import br.com.zup.edu.commerce.notasfiscais.util.XMLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

@Configuration
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

    @Scheduled(
            fixedDelayString = "${job.notificador-comprador.fixed-delay}",
            initialDelayString = "${job.notificador-comprador.initial-delay}"
    )
    @Transactional
    public void notificaComprador() {

        List<NotaFiscal> notas = this.notaFiscalRepository.findTop2ByStatusOrderByCriadaEm(StatusNotaFiscal.GERADA);

        notas.forEach(nota -> {

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

    }

}
