package br.com.zup.edu.commerce.notasfiscais.notas;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @CreationTimestamp
    private LocalDateTime criadaEm;

    @Enumerated(EnumType.STRING)
    private StatusNotaFiscal status;

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

    public NotaFiscal(Usuario comprador) {
        this.comprador = comprador;
        this.status = StatusNotaFiscal.GERADA;
    }

    public void adicionaItemNota(ItemNota item) {
        this.itens.add(item);
        item.setNotaFiscal(this);
    }

}
