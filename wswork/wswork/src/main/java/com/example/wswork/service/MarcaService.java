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

    //Este método retorna uma lista de todas as marcas armazenadas no banco de dados.
    // Ele utiliza o método findAll fornecido pelo MarcaRepository, que é uma interface estendida de JpaRepository do
    // Spring Data JPA
    public List<Marca> listarTodasMarcas() {
        return marcaRepository.findAll();
    }

    //Este método cria uma nova marca no banco de dados. O nome da marca é definido através do método setNomeMarca e,
    // em seguida, a marca é salva no banco de dados usando o método save do MarcaRepository.
    public Marca criarMarca(Marca marca){
        marca.setNomeMarca(marca.getNomeMarca());

        return marcaRepository.save(marca);
    }

    //Este método atualiza uma marca existente no banco de dados. Se a marca com o ID fornecido existir, ela é
    // atualizada com os dados da marca fornecida e é salva no banco de dados.
    // Caso contrário, retorna null (poderia ser lançada uma exceção).
    public Marca atualizarMarca(Long id, Marca marcaAtualizada) {
        if (marcaRepository.existsById(id)) {
            marcaAtualizada.setId(id);
            return marcaRepository.save(marcaAtualizada);
        }
        return null; // Ou lançar uma exceção informando que o carro não foi encontrado
    }

    //Este método exclui uma marca do banco de dados com base no ID fornecido.
    public void excluirMarca(Long id) {
        marcaRepository.deleteById(id);
    }
}
