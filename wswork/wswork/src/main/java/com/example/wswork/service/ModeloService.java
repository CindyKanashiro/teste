package com.example.wswork.service;

import com.example.wswork.dto.ModeloDTO;
import com.example.wswork.model.Marca;
import com.example.wswork.model.Modelo;
import com.example.wswork.repository.MarcaRepository;
import com.example.wswork.repository.ModeloRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {
    @Autowired
    private ModeloRepository modeloRepository;
    @Autowired
    private MarcaRepository marcaRepository;

    public List<Modelo> listarTodosModelos() {
        return modeloRepository.findAll();
    }

    public Modelo criarModelo(ModeloDTO modeloDTO){
        Modelo modelo = new Modelo();
        modelo.setNome(modeloDTO.getNome());
        modelo.setValorFipe(modeloDTO.getValorFipe());
        Marca marca = marcaRepository.findById(modeloDTO.getMarcaID())
                .orElseThrow(() -> new EntityNotFoundException("Marca não encontrada"));

        modelo.setMarca(marca);

        return modeloRepository.save(modelo);

    }

    public Modelo atualizarModelo(Long id, ModeloDTO modeloDTO) {
        Modelo modeloExistente = modeloRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Modelo não encontrado"));

        modeloExistente.setNome(modeloDTO.getNome());
        modeloExistente.setValorFipe(modeloDTO.getValorFipe());

        Long marcaId = modeloDTO.getMarcaID();
        if (marcaId != null) {
            Marca marca = marcaRepository.findById(marcaId)
                    .orElseThrow(() -> new EntityNotFoundException("Marca não encontrada"));

            modeloExistente.setMarca(marca);
        }

        return modeloRepository.save(modeloExistente);
    }

    public void excluirModelo(Long id) {
        modeloRepository.deleteById(id);
    }


}
