package br.com.diego.lab.persistencia.pocs.poc01_banco_vs_aplicacao.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "registro_evento_5kk")
public class RegistroEvento5kk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(nullable = false, length = 30)
    private String status;

    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(nullable = false)
    private Boolean ativo;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    public RegistroEvento5kk() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}