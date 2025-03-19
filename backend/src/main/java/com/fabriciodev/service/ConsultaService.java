package com.fabriciodev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fabriciodev.model.Consulta;
import com.fabriciodev.repository.ConsultaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> listarTodas() {
        return consultaRepository.findAll();
    }

    public Optional<Consulta> buscarPorId(int id) {
        return consultaRepository.findById(id);
    }

    public Consulta agendarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public Consulta editarConsulta(Consulta consulta) {
        return consultaRepository.findById(consulta.getId())
                .map(c -> {
                    c.setPaciente(consulta.getPaciente());
                    c.setMedico(consulta.getMedico());
                    c.setDataConsulta(consulta.getDataConsulta());
                    c.setStatus(consulta.getStatus());
                    return consultaRepository.save(c);
                })
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada com ID: " + consulta.getId()));
    }

    public void cancelarConsulta(int id) {
        consultaRepository.deleteById(id);
    }

    public long contarTodas() {
        return consultaRepository.count();
    }
}