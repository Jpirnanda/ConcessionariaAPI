package com.senai.ConcessionariaAPI.repository;

import com.senai.ConcessionariaAPI.model.Veiculo;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class VeiculoRepository {
    private final ArrayList<Veiculo> listaVeiculos = new ArrayList<>();
    private final ArrayList<Veiculo> listaVeiculosVendidos = new ArrayList<>();
    private final AtomicInteger id = new AtomicInteger(1);

    // CRUD - Create, Read, Update, Delete

    // Create
    public Veiculo create(Veiculo novoVeiculo){
        novoVeiculo.setId(id.getAndIncrement());
        listaVeiculos.add(novoVeiculo);

        return novoVeiculo;
    }

    // Read (todos)
    public ArrayList<Veiculo> findAll(){
        return listaVeiculos;
    }

    // Read (by id)
    public Veiculo findById(int id){
        for (Veiculo veiculo : listaVeiculos){
            if (veiculo.getId() == id){
                return veiculo;
            }
        }
        return null;
    }

    // Update
    public Veiculo updateAndCreate(Veiculo veiculoAtualizado){
        for (Veiculo veiculoDaLista : listaVeiculos){
            if (veiculoDaLista.getId() == veiculoAtualizado.getId()){
                veiculoDaLista.setMarca(veiculoAtualizado.getMarca());
                veiculoDaLista.setModelo(veiculoAtualizado.getModelo());
                veiculoDaLista.setAno(veiculoAtualizado.getAno());

                return veiculoDaLista;
            }
        }
        listaVeiculos.add(veiculoAtualizado);

        return veiculoAtualizado;
    }

    // Delete
    public void deleteById(int id){
        listaVeiculos.removeIf(veiculo -> veiculo.getId() == id);
    }


}
