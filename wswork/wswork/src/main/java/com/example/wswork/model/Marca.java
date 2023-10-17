package com.example.wswork.model;


import jakarta.persistence.*;

//A anotação @Entity indica que esta classe é uma entidade JPA, ou seja, ela está associada a uma tabela no banco de dados.
// A anotação @Table especifica o nome da tabela associada a esta entidade, que é "modelo" neste caso.
@Entity
@Table(name = "marca")
public class Marca {
    //A anotação @Id indica que o campo id é a chave primária da entidade.
    @Id
    //A anotação @GeneratedValue especifica a estratégia de geração de valor para o identificador.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeMarca;

    // Construtor padrão sem argumentos (necessário para JPA)
    public Marca() {
    }

    //Os métodos getters e setters fornecem acesso aos atributos privados da classe, seguindo o princípio de encapsulamento.
    public Marca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }
}
