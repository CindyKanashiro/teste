package com.example.wswork.model;



import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "modelo")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    private String nome;
    private BigDecimal valorFipe;

    // Construtor padrão sem argumentos (necessário para JPA)
    public Modelo() {
    }

    public Modelo(Marca marca, String nome, BigDecimal valorFipe) {
        this.marca = marca;
        this.nome = nome;
        this.valorFipe = valorFipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValorFipe() {
        return valorFipe;
    }

    public void setValorFipe(BigDecimal valorFipe) {
        this.valorFipe = valorFipe;
    }
}
