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

//A anotação @Service é do Spring Framework e indica que esta classe é um componente de serviço, ou seja, ela contém
// lógica de negócios
@Service
public class ModeloService {
    //As anotações @Autowired indicam injeção de dependências.
    //O Spring irá injetar automaticamente essas instâncias quando uma instância de ModeloService for criada.
    // Isso facilita a utilização desses repositórios no serviço sem a necessidade de instanciá-los manualmente
    @Autowired
    private ModeloRepository modeloRepository;
    @Autowired
    private MarcaRepository marcaRepository;

    //Este método retorna uma lista de todos os modelos armazenados no banco de dados.
    // Ele utiliza o método findAll fornecido pelo ModeloRepository, que é uma interface
    // estendida de JpaRepository do Spring Data JPA.
    public List<Modelo> listarTodosModelos() {
        return modeloRepository.findAll();
    }

    public Modelo criarModelo(ModeloDTO modeloDTO){
        // Cria uma nova instância de Modelo e preenche com dados do DTO
        Modelo modelo = new Modelo();
        modelo.setNome(modeloDTO.getNome());
        modelo.setValorFipe(modeloDTO.getValorFipe());

        // Obtém a marca associada ao modelo a partir do ID fornecido no DTO
        Marca marca = marcaRepository.findById(modeloDTO.getMarcaID())
                .orElseThrow(() -> new EntityNotFoundException("Marca não encontrada"));

        // Associa a marca ao modelo
        modelo.setMarca(marca);

        // Salva o modelo no banco de dados
        return modeloRepository.save(modelo);

    }


    public Modelo atualizarModelo(Long id, ModeloDTO modeloDTO) {
        // Obtém o modelo existente a partir do ID fornecido
        Modelo modeloExistente = modeloRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Modelo não encontrado"));

        // Atualiza os dados do modelo existente com os dados do DTO
        modeloExistente.setNome(modeloDTO.getNome());
        modeloExistente.setValorFipe(modeloDTO.getValorFipe());

        // Se o ID da marca for fornecido no DTO, obtém a marca correspondente
        Long marcaId = modeloDTO.getMarcaID();
        if (marcaId != null) {
            Marca marca = marcaRepository.findById(marcaId)
                    .orElseThrow(() -> new EntityNotFoundException("Marca não encontrada"));

            // Associa a marca ao modelo
            modeloExistente.setMarca(marca);
        }

        // Salva o modelo atualizado no banco de dados
        return modeloRepository.save(modeloExistente);
    }

    //Este método exclui um modelo com base no ID fornecido.
    public void excluirModelo(Long id) {
        modeloRepository.deleteById(id);
    }


}
