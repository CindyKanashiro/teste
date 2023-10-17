package com.example.wswork.model;

import com.example.wswork.dto.CarroDTO;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

@Entity
@Table(name = "carro")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "modelo_id", nullable = false)
    private Modelo modelo;

    private Timestamp timestampCadastro;
    private int ano;
    private String combustivel;
    private int numPortas;
    private String cor;

    // Construtor padrão sem argumentos (necessário para JPA)
    public Carro() {
    }

    public Carro(Timestamp timestampCadastro, Modelo modelo, int ano, String combustivel, int numPortas, String cor) {
        this.modelo = modelo;
        this.timestampCadastro = timestampCadastro;
        this.ano = ano;
        this.combustivel = combustivel;
        this.numPortas = numPortas;
        this.cor = cor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTimestampCadastro() {
        return timestampCadastro;
    }

    public void setTimestampCadastro(Timestamp timestampCadastro) {
        this.timestampCadastro = timestampCadastro;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getNumPortas() {
        return numPortas;
    }

    public void setNumPortas(int numPortas) {
        this.numPortas = numPortas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }


}
