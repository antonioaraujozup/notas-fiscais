package br.com.zup.edu.commerce.notasfiscais.service;

import java.math.BigDecimal;

public class ItemVendaDto {

    private Long id;
    private String nome;
    private Integer quantidade;
    private BigDecimal valor;

    public ItemVendaDto() {
    }

    public ItemVendaDto(Long id, String nome, Integer quantidade, BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

}
