package br.com.zup.edu.commerce.notasfiscais.job;

import br.com.zup.edu.commerce.notasfiscais.notas.NotaFiscal;
import br.com.zup.edu.commerce.notasfiscais.notas.NotaFiscalRepository;
import br.com.zup.edu.commerce.notasfiscais.notas.StatusNotaFiscal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@EnableScheduling
public class NotificaCompradorJob {

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    @Scheduled(
            fixedDelayString = "${job.notificador-comprador.fixed-delay}",
            initialDelayString = "${job.notificador-comprador.initial-delay}"
    )
    public void notificaComprador() {

        List<NotaFiscal> notas = this.notaFiscalRepository.findTop5ByStatusOrderByCriadaEm(StatusNotaFiscal.GERADA);

        notas.forEach(nota -> System.out.println(nota.getId()));

    }

}
