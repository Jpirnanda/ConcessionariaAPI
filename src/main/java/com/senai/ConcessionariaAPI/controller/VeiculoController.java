package com.senai.ConcessionariaAPI.controller;

import com.senai.ConcessionariaAPI.model.Veiculo;
import com.senai.ConcessionariaAPI.repository.VeiculoRepository;
import com.senai.ConcessionariaAPI.service.VeiculoService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

// CRUD
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public Veiculo create(@RequestBody Veiculo veiculo){
        return service.create(veiculo);
    }

    // Read
    @GetMapping
    public ArrayList<Veiculo> getAll(){
        return service.findAll();
    }

    // http://localhosto:8080/veiculos/4
    @GetMapping("/{id}")
    public Veiculo getById(@PathVariable int id){
        return service.findById(id);
    }

    // Update
    @PutMapping
    public Veiculo update(@RequestBody Veiculo veiculo){
        return service.updateAndCreate(veiculo);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.deleteById(id);
    }

}
