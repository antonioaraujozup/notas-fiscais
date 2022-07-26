package br.com.zup.edu.commerce.notasfiscais.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VendaDto {

    private UUID codigoPedido;
    private UsuarioDto comprador;
    private List<ItemVendaDto> itens = new ArrayList<>();
    private PagamentoDto pagamento;

    public VendaDto() {
    }

    public VendaDto(UUID codigoPedido, UsuarioDto comprador, List<ItemVendaDto> itens, PagamentoDto pagamento) {
        this.codigoPedido = codigoPedido;
        this.comprador = comprador;
        this.itens = itens;
        this.pagamento = pagamento;
    }

    public UUID getCodigoPedido() {
        return codigoPedido;
    }

    public UsuarioDto getComprador() {
        return comprador;
    }

    public PagamentoDto getPagamento() {
        return pagamento;
    }

    public List<ItemVendaDto> getItens() {
        return itens;
    }

}
