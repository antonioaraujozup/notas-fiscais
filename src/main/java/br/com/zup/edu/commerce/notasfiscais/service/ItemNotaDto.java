package br.com.zup.edu.commerce.notasfiscais.service;

import br.com.zup.edu.commerce.notasfiscais.notas.ItemNota;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.math.BigDecimal;

@JsonRootName("item")
public class ItemNotaDto {

    private String nome;
    private Integer quantidade;
    private BigDecimal valor;

    public ItemNotaDto() {
    }

    public ItemNotaDto(String nome, Integer quantidade, BigDecimal valor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public ItemNotaDto(ItemNota itemNota) {
        this.nome = itemNota.getNome();
        this.quantidade = itemNota.getQuantidade();
        this.valor = itemNota.getValor();
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
