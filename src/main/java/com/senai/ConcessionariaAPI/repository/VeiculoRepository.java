package com.senai.ConcessionariaAPI.repository;

import com.senai.ConcessionariaAPI.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;


// Todo o CRUD e criado por padrão quando usamos o extends JpaRepository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
}
