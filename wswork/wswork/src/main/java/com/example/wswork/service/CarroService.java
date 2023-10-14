package com.example.wswork.service;

import com.example.wswork.dto.CarroDTO;
import com.example.wswork.model.Carro;
import com.example.wswork.model.Marca;
import com.example.wswork.model.Modelo;
import com.example.wswork.repository.CarroRepository;
import com.example.wswork.repository.MarcaRepository;
import com.example.wswork.repository.ModeloRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Carro criarCarro(CarroDTO carroDTO) {
        Marca marca = new Marca();
        marca.setNomeMarca(carroDTO.getMarcaNome());
        Marca marcaSalva = marcaRepository.save(marca);

        Modelo modelo = new Modelo();
        modelo.setMarca(marcaSalva);
        modelo.setNome(carroDTO.getModeloNome());
        modelo.setValorFipe(carroDTO.getValorFipe());
        Modelo modeloSalvo = modeloRepository.save(modelo);

        Carro carro = new Carro();
        carro.setModelo(modeloSalvo);
        carro.setTimestampCadastro(carroDTO.getTimestampCadastro());
        carro.setAno(carroDTO.getAno());
        carro.setCombustivel(carroDTO.getCombustivel());
        carro.setNumPortas(carroDTO.getNumPortas());
        carro.setCor(carroDTO.getCor());

        return carroRepository.save(carro);
    }

    public Carro atualizarCarro(Long id, Carro novoCarro) {
        if (carroRepository.existsById(id)) {
            novoCarro.setId(id);
            return carroRepository.save(novoCarro);
        }
        return null; // Ou lançar uma exceção informando que o carro não foi encontrado
    }

    public void excluirCarro(Long id) {
        carroRepository.deleteById(id);
    }
}
