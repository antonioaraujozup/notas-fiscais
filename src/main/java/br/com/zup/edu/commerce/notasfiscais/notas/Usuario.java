package br.com.zup.edu.commerce.notasfiscais.notas;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Usuario {

    @Column(nullable = false, name = "nome_comprador")
    private String nome;

    @Column(nullable = false, name = "cpf")
    private String cpf;

    @Column(nullable = false, name = "endereco")
    private String endereco;

    @Column(nullable = false, name = "email")
    private String email;

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public Usuario() {
    }

    public Usuario(String nome, String cpf, String endereco, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

}
