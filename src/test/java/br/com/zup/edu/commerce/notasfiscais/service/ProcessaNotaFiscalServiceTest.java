package br.com.zup.edu.commerce.notasfiscais.service;

import br.com.zup.edu.commerce.notasfiscais.notas.ItemNotaRepository;
import br.com.zup.edu.commerce.notasfiscais.notas.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc(printOnlyOnFailure = false)
public class ProcessaNotaFiscalServiceTest {

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    @Autowired
    private ItemNotaRepository itemNotaRepository;



}
