package com.senai.ConcessionariaAPI.service;

import com.senai.ConcessionariaAPI.model.Veiculo;
import com.senai.ConcessionariaAPI.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Veiculo create(Veiculo veiculo){
        // Fazer o tratamento do veículo
        int anoLimite = java.time.Year.now().getValue()+1;

        if (veiculo.getMarca() == null || veiculo.getMarca().isEmpty()){
            throw new IllegalArgumentException("O campo da marca deve ser preenchido.");
        }

        if (veiculo.getModelo() == null || veiculo.getModelo().isEmpty()){
            throw new IllegalArgumentException("O campo de modelo deve ser preenchido.");
        }

        veiculo.setMarca(veiculo.getMarca().toUpperCase().trim());
        veiculo.setModelo(veiculo.getModelo().toUpperCase().trim());

        if (veiculo.getAno() > anoLimite || veiculo.getAno() < 2000){
            throw new IllegalArgumentException("O ano digitado é inválido. Digite um ano entre 2000 e " + anoLimite);
        }

        return repository.create(veiculo);
    }

    public ArrayList<Veiculo> findAll(){
        return repository.findAll();
    }

    public Veiculo findById(int id){
        return repository.findById(id);
    }

    public Veiculo updateAndCreate(Veiculo veiculo){
        return repository.updateAndCreate(veiculo);
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }
}
