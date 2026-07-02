package com.senai.ConcessionariaAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Veiculo {
    private String marca;
    private String modelo;
    private int ano;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
}