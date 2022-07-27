package br.com.zup.edu.commerce.notasfiscais.notas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal,Long> {
    List<NotaFiscal> findTop2ByStatusOrderByCriadaEm(StatusNotaFiscal status);
}
