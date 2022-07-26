package br.com.zup.edu.commerce.notasfiscais.service;

import br.com.zup.edu.commerce.notasfiscais.notas.ItemNota;
import br.com.zup.edu.commerce.notasfiscais.notas.NotaFiscal;
import br.com.zup.edu.commerce.notasfiscais.notas.Usuario;

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

    @Override
    public String toString() {
        return "Venda {" +
                "codigoPedido=" + codigoPedido +
                '}';
    }

    public NotaFiscal toNotaFiscal() {
        Usuario compradorNota = comprador.toUsuario();

        NotaFiscal notaFiscal = new NotaFiscal(compradorNota);

        this.itens.forEach(item -> {
            ItemNota itemNota = item.toItemNota();
            notaFiscal.adicionaItemNota(itemNota);
        });

        return notaFiscal;
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
