package br.com.zup.edu.commerce.notasfiscais.service;

public class PagamentoDto {

    private String id;
    private FormaPagamento forma;
    private StatusPagamento status;

    public PagamentoDto() {
    }

    public PagamentoDto(String id, FormaPagamento forma, StatusPagamento status) {
        this.id = id;
        this.forma = forma;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public FormaPagamento getForma() {
        return forma;
    }

    public StatusPagamento getStatus() {
        return status;
    }

}
