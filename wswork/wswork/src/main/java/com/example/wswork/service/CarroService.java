package com.example.wswork.service;

import com.example.wswork.dto.CarroDTO;
import com.example.wswork.model.Carro;
import com.example.wswork.model.Marca;
import com.example.wswork.model.Modelo;
import com.example.wswork.repository.CarroRepository;
import com.example.wswork.repository.MarcaRepository;
import com.example.wswork.repository.ModeloRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private ModeloRepository modeloRepository;
    @Autowired
    private MarcaRepository marcaRepository;

    public List<Carro> listarTodosCarros() {
        return carroRepository.findAll();
    }

    public Carro obterCarroPorId(Long id) {
        return carroRepository.findById(id).orElse(null);
    }

    @Transactional
    public Carro criarCarro(CarroDTO carroDTO, Long modeloId) {
        Modelo modeloExistente = modeloRepository.findById(modeloId)
                .orElseThrow(() -> new EntityNotFoundException("Modelo não encontrado"));

        Carro carro = new Carro();
        carro.setModelo(modeloExistente);
        carro.setTimestampCadastro(new Timestamp(System.currentTimeMillis()));
        carro.setAno(carroDTO.getAno());
        carro.setCombustivel(carroDTO.getCombustivel());
        carro.setNumPortas(carroDTO.getNumPortas());
        carro.setCor(carroDTO.getCor());

        return carroRepository.save(carro);
    }


    public Carro atualizarCarro(Long id, Carro novoCarro) {
        Optional<Carro> carroExistenteOptional = carroRepository.findById(id);

        if (carroExistenteOptional.isPresent()) {
            Carro carroExistente = carroExistenteOptional.get();

            carroExistente.setTimestampCadastro(new Timestamp(System.currentTimeMillis()));
            carroExistente.setAno(novoCarro.getAno());
            carroExistente.setCombustivel(novoCarro.getCombustivel());
            carroExistente.setNumPortas(novoCarro.getNumPortas());
            carroExistente.setCor(novoCarro.getCor());

            return carroRepository.save(carroExistente);
        } else {
            return null; // Ou lançar uma exceção informando que o carro não foi encontrado
        }
    }


    public void excluirCarro(Long id) {
        carroRepository.deleteById(id);
    }
}
