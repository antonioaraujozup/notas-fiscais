package br.com.zup.edu.commerce.notasfiscais.service;

import br.com.zup.edu.commerce.notasfiscais.notas.ItemNotaRepository;
import br.com.zup.edu.commerce.notasfiscais.notas.NotaFiscalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc(printOnlyOnFailure = false)
public class NotificaCompradorJobTest {

    @Autowired
    private NotificaCompradorJob job;

    @Autowired
    private ItemNotaRepository itemNotaRepository;

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    @Value("${mail.remetente.commerce}")
    private String remetente;

    @Value("${mail.assunto}")
    private String assunto;

    @Value("${mail.corpo}")
    private String corpo;

    @Value("${mail.anexo.nome}")
    private String nomeArquivo;

    @BeforeEach
    void setUp() {
        this.itemNotaRepository.deleteAll();
        this.notaFiscalRepository.deleteAll();
    }

    @Test
    @DisplayName("")
    void test0() {
    }
}
