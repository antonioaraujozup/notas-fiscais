package br.com.zup.edu.commerce.notasfiscais.service;

import br.com.zup.edu.commerce.notasfiscais.notas.NotaFiscal;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@JsonRootName("notaFiscal")
public class NotaFiscalDto {

    private Long numeroDaNota;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime criadoEm;

    private String nomeComprador;
    private String cpf;
    private String endereco;
    private List<ItemNotaDto> itens;
    private BigDecimal valorTotal;

    public NotaFiscalDto() {
    }

    public NotaFiscalDto(Long numeroDaNota, LocalDateTime criadoEm, String nomeComprador, String cpf, String endereco, List<ItemNotaDto> itens, BigDecimal valorTotal) {
        this.numeroDaNota = numeroDaNota;
        this.criadoEm = criadoEm;
        this.nomeComprador = nomeComprador;
        this.cpf = cpf;
        this.endereco = endereco;
        this.itens = itens;
        this.valorTotal = valorTotal;
    }

    public NotaFiscalDto(NotaFiscal notaFiscal) {
        this.numeroDaNota = notaFiscal.getId();
        this.criadoEm = notaFiscal.getCriadaEm();
        this.nomeComprador = notaFiscal.retornaNomeComprador();
        this.cpf = notaFiscal.retornaCpfComprador();
        this.endereco = notaFiscal.retornaEnderecoComprador();
        this.itens = notaFiscal.getItens().stream().map(ItemNotaDto::new).collect(Collectors.toList());
        this.valorTotal = notaFiscal.calculaValorTotal();
    }

    public Long getNumeroDaNota() {
        return numeroDaNota;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public String getNomeComprador() {
        return nomeComprador;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<ItemNotaDto> getItens() {
        return itens;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

}
