package com.fabriciodev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fabriciodev.model.Medico;
import com.fabriciodev.repository.MedicoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }

    public Optional<Medico> buscarPorId(int id) {
        return medicoRepository.findById(id);
    }

    public Medico cadastrar(Medico medico) {
        return medicoRepository.save(medico);
    }

    public void deletar(int id) {
        medicoRepository.deleteById(id);
    }

    public long contarTodas() {
        return medicoRepository.count();
    }
}
