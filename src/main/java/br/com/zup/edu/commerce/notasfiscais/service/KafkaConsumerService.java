package br.com.zup.edu.commerce.notasfiscais.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerService {

    @KafkaListener(
            topics = "${spring.kafka.topics.venda.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consome(VendaDto venda) {
        System.out.println("Mensagem recebida: " + venda.toString());
    }

}
