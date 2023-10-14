package com.example.wswork;

import com.example.wswork.model.Carro;
import com.example.wswork.model.Marca;
import com.example.wswork.model.Modelo;
import com.example.wswork.repository.CarroRepository;
import com.example.wswork.repository.MarcaRepository;
import com.example.wswork.repository.ModeloRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {
    private final CarroRepository carroRepository;
    private final ModeloRepository modeloRepository;
    private final MarcaRepository marcaRepository;

    public DataInitializer(CarroRepository carroRepository, ModeloRepository modeloRepository, MarcaRepository marcaRepository) {
        this.carroRepository = carroRepository;
        this.modeloRepository = modeloRepository;
        this.marcaRepository = marcaRepository;
    }

    @Override
    public void run(String... args) {
        // Popule o banco de dados com dados de exemplo aqui

        Marca marca1 = new Marca("Chevrolet");
        marcaRepository.save(marca1);
        Marca marca2 = new Marca("Volkswagen");
        marcaRepository.save(marca2);

        Modelo modelo1 = new Modelo(marca1, "Onix", BigDecimal.valueOf(50000.0));
        modeloRepository.save(modelo1);
        Modelo modelo2 = new Modelo(marca2, "Golf", BigDecimal.valueOf(60000.0));
        modeloRepository.save(modelo2);

        Carro carro1 = new Carro(Timestamp.valueOf(LocalDateTime.now()), modelo1, 2015, "FLEX", 4, "BEGE");
        carroRepository.save(carro1);
        Carro carro2 = new Carro(Timestamp.valueOf(LocalDateTime.now()), modelo2, 2020, "Gasolina", 5, "Preto");
        carroRepository.save(carro2);

        // Adicione mais dados conforme necessário
    }
}
