package com.example.wswork.controllers;

import com.example.wswork.dto.CarroDTO;
import com.example.wswork.model.Carro;
import com.example.wswork.repository.CarroRepository;
import com.example.wswork.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private CarroService carroService;

    // Listar todos os carros
    @GetMapping
    public ResponseEntity<List<Carro>> listarCarros() {
        List<Carro> carros = carroService.listarTodosCarros();
        return ResponseEntity.ok(carros);
    }

    // Obter um carro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Carro> obterCarroPorId(@PathVariable Long id) {
        Carro carro = carroService.obterCarroPorId(id);
        return ResponseEntity.ok(carro);
    }

    // Criar um novo carro
    @PostMapping
    public ResponseEntity<Carro> criarCarro(@RequestBody CarroDTO carrodto) {
        Carro novoCarro = carroService.criarCarro(carrodto, carrodto.getModeloID());
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCarro);
    }

    // Atualizar um carro existente
    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizarCarro(@PathVariable Long id, @RequestBody Carro carro) {
        Carro carroAtualizado = carroService.atualizarCarro(id, carro);

        if (carroAtualizado != null) {
            return ResponseEntity.ok(carroAtualizado);
        } else {
            return ResponseEntity.notFound().build(); // Retorna o status HTTP 404 NOT FOUND
        }
    }


    // Excluir um carro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCarro(@PathVariable Long id) {
        carroService.excluirCarro(id);
        return ResponseEntity.noContent().build();
    }

    // Lista formatada desejada no teste
    @GetMapping("/listagem-formatada")
    public ResponseEntity<List<Object>> getCarrosFormatados() {
        List<Object> carrosFormatados = carroRepository.findAll().stream()
                .map(carro -> formatarCarro(carro))
                .collect(Collectors.toList());

        return ResponseEntity.ok(carrosFormatados);
    }

    private Object formatarCarro(Carro carro) {
        // Exemplo simples de formatação:
        return Map.of(
                "id", carro.getId(),
                "timestamp_cadastro", carro.getTimestampCadastro().toInstant().toEpochMilli(),
                "modelo_id", carro.getModelo().getId(),
                "ano", carro.getAno(),
                "combustivel", carro.getCombustivel(),
                "num_portas", carro.getNumPortas(),
                "cor", carro.getCor(),
                "nome_modelo", carro.getModelo().getNome(),
                "valor", carro.getModelo().getValorFipe()
        );
    }
}
