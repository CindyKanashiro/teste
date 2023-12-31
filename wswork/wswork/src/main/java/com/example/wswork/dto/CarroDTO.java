package com.example.wswork.dto;

import com.example.wswork.model.Modelo;
import jakarta.persistence.Entity;
import org.hibernate.sql.model.ModelMutationLogging;

import java.math.BigDecimal;
import java.sql.Timestamp;

//DTOs são estruturas simples e frequentemente imutáveis que facilitam a transferência eficiente de dados entre diferentes
// partes de uma aplicação ou entre sistemas distribuídos. Eles contribuem para um design mais flexível,
// desacoplado e adaptável em cenários onde a transferência de dados é uma parte essencial da arquitetura.
public class CarroDTO {
    private Long modeloID;
    private int ano;
    private String combustivel;
    private int numPortas;
    private String cor;

    public CarroDTO() {
    }

    public Long getModeloID() {
        return modeloID;
    }

    public void setModeloID(Long modeloID) {
        this.modeloID = modeloID;
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
