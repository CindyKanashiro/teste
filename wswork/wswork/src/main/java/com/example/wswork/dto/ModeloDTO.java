package com.example.wswork.dto;

import java.math.BigDecimal;

public class ModeloDTO {
    private Long marcaID;
    private String nome;
    private BigDecimal valorFipe;

    public ModeloDTO(Long marcaID, String nome, BigDecimal valorFipe) {
        this.marcaID = marcaID;
        this.nome = nome;
        this.valorFipe = valorFipe;
    }

    public Long getMarcaID() {
        return marcaID;
    }

    public void setMarcaID(Long marcaID) {
        this.marcaID = marcaID;
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
