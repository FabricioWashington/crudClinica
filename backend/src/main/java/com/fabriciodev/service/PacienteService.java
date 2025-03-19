package com.fabriciodev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fabriciodev.ClinicaApplication;
import com.fabriciodev.model.Paciente;
import com.fabriciodev.repository.PacienteRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final ClinicaApplication clinicaApplication;

    @Autowired
    private PacienteRepository pacienteRepository;

    PacienteService(ClinicaApplication clinicaApplication) {
        this.clinicaApplication = clinicaApplication;
    }

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> buscarPorId(int id) {
        return pacienteRepository.findById(id);
    }

    public Paciente cadastrar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente editar(Paciente paciente) {
        return pacienteRepository.findById(paciente.getId())
                .map(p -> {
                    p.setNome(paciente.getNome());
                    p.setCpf(paciente.getCpf());
                    p.setEmail(paciente.getEmail());
                    return pacienteRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com ID: " + paciente.getId()));
    }

    public void deletar(int id) {
        pacienteRepository.deleteById(id);
    }

    public long contarTodas() {
        return pacienteRepository.count();
    }
}
