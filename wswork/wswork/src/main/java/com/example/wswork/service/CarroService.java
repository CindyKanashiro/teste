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

    //Este método retorna uma lista de todos os carros armazenados no banco de dados.
    // Ele utiliza o método findAll fornecido pelo CarroRepository
    public List<Carro> listarTodosCarros() {
        return carroRepository.findAll();
    }

    //Este método retorna um carro específico com base no ID fornecido. Se o carro não for encontrado, retorna null
    public Carro obterCarroPorId(Long id) {
        return carroRepository.findById(id).orElse(null);
    }

    //Este método cria um novo carro no banco de dados com base nos dados fornecidos no CarroDTO e no ID do modelo.
    // Utiliza a anotação @Transactional para garantir que a operação seja atômica.
    //No método criarCarro, uma exceção EntityNotFoundException é lançada caso o modelo associado ao carro não seja encontrado
    @Transactional
    public Carro criarCarro(CarroDTO carroDTO, Long modeloId) {
        // Obtém o modelo associado ao carro
        Modelo modeloExistente = modeloRepository.findById(modeloId)
                .orElseThrow(() -> new EntityNotFoundException("Modelo não encontrado"));

        // Cria uma instância de Carro com base nos dados fornecidos
        Carro carro = new Carro();
        carro.setModelo(modeloExistente);
        carro.setTimestampCadastro(new Timestamp(System.currentTimeMillis()));
        carro.setAno(carroDTO.getAno());
        carro.setCombustivel(carroDTO.getCombustivel());
        carro.setNumPortas(carroDTO.getNumPortas());
        carro.setCor(carroDTO.getCor());

        // Salva o carro no banco de dados
        return carroRepository.save(carro);
    }


    //Este método atualiza um carro existente no banco de dados com base no ID fornecido.
    // Se o carro com o ID fornecido não existir, retorna null
    public Carro atualizarCarro(Long id, Carro novoCarro) {
        Optional<Carro> carroExistenteOptional = carroRepository.findById(id);

        //Atualiza os dados do carro existente com os dados do novo carro
        if (carroExistenteOptional.isPresent()) {
            Carro carroExistente = carroExistenteOptional.get();

            carroExistente.setTimestampCadastro(new Timestamp(System.currentTimeMillis()));
            carroExistente.setAno(novoCarro.getAno());
            carroExistente.setCombustivel(novoCarro.getCombustivel());
            carroExistente.setNumPortas(novoCarro.getNumPortas());
            carroExistente.setCor(novoCarro.getCor());

            //Salva o carro atualizado no banco de dados
            return carroRepository.save(carroExistente);
        } else {
            return null; // Ou lançar uma exceção informando que o carro não foi encontrado
        }
    }

    //Este método exclui um carro do banco de dados com base no ID fornecido.
    public void excluirCarro(Long id) {
        carroRepository.deleteById(id);
    }

    //OBS: Alguns métodos utilizam o Timestamp para registrar o momento em que uma operação foi realizada (setTimestampCadastro).
}
