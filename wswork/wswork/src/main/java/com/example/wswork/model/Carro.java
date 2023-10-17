package com.example.wswork.model;

import com.example.wswork.dto.CarroDTO;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

//A anotação @Entity indica que esta classe é uma entidade JPA, ou seja, ela está associada a uma tabela no banco de dados.
// A anotação @Table especifica o nome da tabela associada a esta entidade, que é "modelo" neste caso.
@Entity
@Table(name = "carro")
public class Carro {
    //A anotação @Id indica que o campo id é a chave primária da entidade.
    @Id
    //A anotação @GeneratedValue especifica a estratégia de geração de valor para o identificador.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //A anotação @ManyToOne indica um relacionamento muitos-para-um com outra entidade, neste caso, a entidade Modelo.
    @ManyToOne
    //A anotação @JoinColumn especifica a coluna na tabela "carro" que é usada para armazenar a chave estrangeira para
    // a entidade Modelo. A coluna é chamada "modelo_id" e é definida como não nula (nullable = false).
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

    //Os métodos getters e setters fornecem acesso aos atributos privados da classe, seguindo o princípio de encapsulamento.
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
