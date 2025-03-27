package com.fabriciodev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

import com.fabriciodev.model.Consulta;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@AllArgsConstructor
public class ConsultaDTO {
    private Integer id;
    private PacienteDTO paciente;
    private MedicoDTO medico;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataConsulta;
    private String status;

    public static ConsultaDTO fromEntity(Consulta consulta) {
        return new ConsultaDTO(
                consulta.getId(),
                new PacienteDTO(consulta.getPaciente().getId(), consulta.getPaciente().getNome(),
                        consulta.getPaciente().getCpf(), consulta.getPaciente().getEmail()),
                new MedicoDTO(consulta.getMedico().getId(), consulta.getMedico().getNome(),
                        consulta.getMedico().getEspecialidade()),
                consulta.getDataConsulta(),
                consulta.getStatus());
    }
}
