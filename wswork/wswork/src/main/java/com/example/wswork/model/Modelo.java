package com.example.wswork.model;



import jakarta.persistence.*;

import java.math.BigDecimal;

//A anotação @Entity indica que esta classe é uma entidade JPA, ou seja, ela está associada a uma tabela no banco de dados.
// A anotação @Table especifica o nome da tabela associada a esta entidade, que é "modelo" neste caso.
@Entity
@Table(name = "modelo")
public class Modelo {
  //A anotação @Id indica que o campo id é a chave primária da entidade.
    @Id
    //A anotação @GeneratedValue especifica a estratégia de geração de valor para o identificador.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //A anotação @ManyToOne indica um relacionamento muitos-para-um com outra entidade, neste caso, a entidade Marca.
    @ManyToOne
    //A anotação @JoinColumn especifica a coluna na tabela "modelo" que é usada para armazenar a chave estrangeira para
    // a entidade Marca. A coluna é chamada "marca_id" e é definida como não nula (nullable = false).
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

    //Os métodos getters e setters fornecem acesso aos atributos privados da classe, seguindo o princípio de encapsulamento.
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
