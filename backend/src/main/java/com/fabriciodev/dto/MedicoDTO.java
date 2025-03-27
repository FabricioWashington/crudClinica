package com.fabriciodev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MedicoDTO {
    private Integer id;
    private String nome;
    private String especialidade;
}
