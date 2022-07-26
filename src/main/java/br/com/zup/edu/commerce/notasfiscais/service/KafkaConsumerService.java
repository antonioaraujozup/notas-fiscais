package br.com.zup.edu.commerce.notasfiscais.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumerService {

    @Autowired
    private ProcessaNotaFiscalService processaNotaFiscalService;

    Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(
            topics = "${spring.kafka.topics.venda.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consome(VendaDto venda) {
        logger.info("Evento da {} recebido com sucesso", venda.toString());

        processaNotaFiscalService.processa(venda);
    }

}
