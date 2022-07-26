package br.com.zup.edu.commerce.notasfiscais.service;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class UsuarioDto {

    private String nome;
    private String cpf;
    private String endereco;
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    public UsuarioDto() {
    }

    public UsuarioDto(String nome, String cpf, String endereco, String email, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

}
