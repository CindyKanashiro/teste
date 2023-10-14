package com.example.wswork.dto;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
public class CarroDTO {
        private String marcaNome;
        private String modeloNome;
        private BigDecimal valorFipe;
        private Timestamp timestampCadastro;
        private int ano;
        private String combustivel;
        private int numPortas;
        private String cor;

        // getters e setters

        public String getMarcaNome() {
            return marcaNome;
        }

        public void setMarcaNome(String marcaNome) {
            this.marcaNome = marcaNome;
        }

        public String getModeloNome() {
            return modeloNome;
        }

        public void setModeloNome(String modeloNome) {
            this.modeloNome = modeloNome;
        }

        public BigDecimal getValorFipe() {
            return valorFipe;
        }

        public void setValorFipe(BigDecimal valorFipe) {
            this.valorFipe = valorFipe;
        }

        public Timestamp getTimestampCadastro() {
            return timestampCadastro;
        }

        public void setTimestampCadastro(Timestamp timestampCadastro) {
            this.timestampCadastro = timestampCadastro;
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
