package com.example.wswork.model;


import jakarta.persistence.*;

@Entity
@Table(name = "marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeMarca;

    // Construtor padrão sem argumentos (necessário para JPA)
    public Marca() {
    }


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
