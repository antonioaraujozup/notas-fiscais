package br.com.zup.edu.commerce.notasfiscais.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EnviadorEmailService {

    @Autowired
    private JavaMailSender enviadorEmail;

    Logger logger = LoggerFactory.getLogger(EnviadorEmailService.class);

    public void envia(String remetente, String destinatario, String assunto, String texto) {

        SimpleMailMessage email = new SimpleMailMessage();

        email.setFrom(remetente);
        email.setTo(destinatario);
        email.setSubject(assunto);
        email.setText(texto);

        enviadorEmail.send(email);

        logger.info("Email enviado para {}", destinatario);

    }

    public void envia(String remetente, String destinatario, String assunto,
                      String texto, File arquivo, String descricaoArquivo) throws MessagingException {

        MimeMessage email = enviadorEmail.createMimeMessage();

        MimeMessageHelper ajudante = new MimeMessageHelper(email, true);

        ajudante.setFrom(remetente);
        ajudante.setTo(destinatario);
        ajudante.setSubject(assunto);
        ajudante.setText(texto);

        FileSystemResource file = new FileSystemResource(arquivo);
        ajudante.addAttachment(descricaoArquivo, file);

        enviadorEmail.send(email);

        logger.info("Email enviado para {}", destinatario);

    }

}
