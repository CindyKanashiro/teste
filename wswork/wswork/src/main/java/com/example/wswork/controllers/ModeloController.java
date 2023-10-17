package com.example.wswork.controllers;

import com.example.wswork.dto.ModeloDTO;
import com.example.wswork.model.Marca;
import com.example.wswork.model.Modelo;
import com.example.wswork.repository.ModeloRepository;
import com.example.wswork.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//A anotação @RestController indica que esta classe é um controlador Spring MVC que lida com requisições REST.
// Ele combina as anotações @Controller e @ResponseBody.
//A anotação @RequestMapping("/modelos") especifica que as rotas (endpoints) relacionadas a este controlador começarão
// com "/modelos".
@RestController
@RequestMapping("/modelos")
public class ModeloController {

    //As anotações @Autowired indicam injeção de dependências. O Spring irá injetar automaticamente instâncias
    // de ModeloRepository e ModeloService quando uma instância de ModeloController for criada.
    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private ModeloService modeloService;

    //Pegar todos os modelos existentes
    @GetMapping
    public ResponseEntity<List<Modelo>> listarModelo(){
        List<Modelo> modelos = modeloService.listarTodosModelos();
        return ResponseEntity.ok(modelos);
    }

    //Cria um novo modelo
    @PostMapping
    public ResponseEntity<Modelo> criarModelo(@RequestBody ModeloDTO modelodto) {
        Modelo novaModelo = modeloService.criarModelo(modelodto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaModelo);
    }

    //Atualiza os modelos existentes
    @PutMapping("/{id}")
    public ResponseEntity<Modelo> atualizarModelo(@PathVariable Long id, @RequestBody ModeloDTO modeloDTO) {
        Modelo modeloAtualizado = modeloService.atualizarModelo(id, modeloDTO);
        return ResponseEntity.ok(modeloAtualizado);
    }


    //Deleta o modelo pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirModelo(@PathVariable Long id) {
        modeloService.excluirModelo(id);
        return ResponseEntity.noContent().build();
    }
}
