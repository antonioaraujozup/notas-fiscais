package br.com.zup.edu.commerce.notasfiscais.service;

import br.com.zup.edu.commerce.notasfiscais.notas.NotaFiscal;
import br.com.zup.edu.commerce.notasfiscais.notas.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProcessaNotaFiscalService {

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    @Transactional
    public void processa(VendaDto vendaDto) {
        NotaFiscal notaFiscal = vendaDto.toNotaFiscal();

        notaFiscalRepository.save(notaFiscal);
    }

}
