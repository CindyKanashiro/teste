package com.example.wswork.dto;

import java.math.BigDecimal;

//DTOs são estruturas simples e frequentemente imutáveis que facilitam a transferência eficiente de dados entre diferentes
// partes de uma aplicação ou entre sistemas distribuídos. Eles contribuem para um design mais flexível,
// desacoplado e adaptável em cenários onde a transferência de dados é uma parte essencial da arquitetura.
public class ModeloDTO {
    private Long marcaID;
    private String nome;
    private BigDecimal valorFipe;

    public ModeloDTO() {

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
