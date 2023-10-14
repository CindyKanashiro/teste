package com.example.wswork.controllers;

import com.example.wswork.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/modelos")
@CrossOrigin(origins = "http://localhost:4200")
public class ModeloController {

    @Autowired
    private ModeloRepository modeloRepository;
}
