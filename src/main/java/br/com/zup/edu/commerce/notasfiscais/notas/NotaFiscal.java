package br.com.zup.edu.commerce.notasfiscais.notas;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime criadaEm;

    @Enumerated(EnumType.STRING)
    private StatusNotaFiscal status;

    @Column(nullable = false)
    private UUID codigoPedido;

    @Embedded
    private Usuario comprador;

    @OneToMany(mappedBy = "notaFiscal", cascade = CascadeType.PERSIST)
    private List<ItemNota> itens = new ArrayList<>();

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public NotaFiscal() {
    }

    public NotaFiscal(UUID codigoPedido, Usuario comprador) {
        this.codigoPedido = codigoPedido;
        this.comprador = comprador;
        this.status = StatusNotaFiscal.GERADA;
    }

    public BigDecimal calculaValorTotal() {
        BigDecimal valorTotal = itens.stream()
                .map(i -> {
                    return i.getValor().multiply(new BigDecimal(i.getQuantidade()));
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return valorTotal;
    }

    public void adicionaItemNota(ItemNota item) {
        this.itens.add(item);
        item.setNotaFiscal(this);
    }

    public void alteraStatusEnviadaComprador() {
        this.status = StatusNotaFiscal.GERADA_E_ENVIADA;
    }

    public String retornaNomeComprador() {
        return this.comprador.getNome();
    }

    public String retornaCpfComprador() {
        return this.comprador.getCpf();
    }

    public String retornaEnderecoComprador() {
        return this.comprador.getEndereco();
    }

    public String retornaEmailComprador() {
        return this.comprador.getEmail();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCriadaEm() {
        return criadaEm;
    }

    public StatusNotaFiscal getStatus() {
        return status;
    }

    public UUID getCodigoPedido() {
        return codigoPedido;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public List<ItemNota> getItens() {
        return itens;
    }

}
