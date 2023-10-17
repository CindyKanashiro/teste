package com.example.wswork.service;

import com.example.wswork.model.Carro;
import com.example.wswork.model.Marca;
import com.example.wswork.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> listarTodasMarcas() {
        return marcaRepository.findAll();
    }

    public Marca criarMarca(Marca marca){
        marca.setNomeMarca(marca.getNomeMarca());

        return marcaRepository.save(marca);
    }

    public Marca atualizarMarca(Long id, Marca marcaAtualizada) {
        if (marcaRepository.existsById(id)) {
            marcaAtualizada.setId(id);
            return marcaRepository.save(marcaAtualizada);
        }
        return null; // Ou lançar uma exceção informando que o carro não foi encontrado
    }

    public void excluirMarca(Long id) {
        marcaRepository.deleteById(id);
    }
}
