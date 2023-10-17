package com.example.wswork.controllers;

import com.example.wswork.dto.CarroDTO;
import com.example.wswork.model.Carro;
import com.example.wswork.model.Marca;
import com.example.wswork.repository.MarcaRepository;
import com.example.wswork.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
@CrossOrigin(origins = "http://localhost:4200")
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;
    @Autowired
    private MarcaService marcaService;


    //Pegar todas as marcas existentes
    @GetMapping
    public ResponseEntity<List<Marca>> listarMarca() {
        List<Marca> marcas = marcaService.listarTodasMarcas();
        return ResponseEntity.ok(marcas);
    }

    //Criar nova marca
    @PostMapping
    public ResponseEntity<Marca> criarMarca(@RequestBody Marca marca) {
        Marca novaMarca = marcaService.criarMarca(marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMarca);
    }

    // Atualizar marca existente
    @PutMapping("/{id}")
    public ResponseEntity<Marca> atualizarMarca(@PathVariable Long id, @RequestBody Marca marca) {
        Marca marcaAtualizada = marcaService.atualizarMarca(id, marca);
        return ResponseEntity.ok(marcaAtualizada);
    }

    // Excluir marca por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMarca(@PathVariable Long id) {
        marcaService.excluirMarca(id);
        return ResponseEntity.noContent().build();
    }
}
