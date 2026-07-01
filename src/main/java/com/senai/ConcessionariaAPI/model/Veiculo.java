package com.senai.ConcessionariaAPI.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private int id;
}