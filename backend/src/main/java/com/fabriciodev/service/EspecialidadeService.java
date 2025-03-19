package com.fabriciodev.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fabriciodev.model.Especialidade;
import com.fabriciodev.repository.EspecialidadeRepository;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public List<Especialidade> listarTodas() {
        return especialidadeRepository.findAll();
    }

    public Optional<Especialidade> buscarPorId(int id) {
        return especialidadeRepository.findById(id);
    }

    public Especialidade cadastrar(Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }

    public Especialidade editar(Especialidade especialidade) {
        return especialidadeRepository.findById(especialidade.getId())
                .map(e -> {
                    e.setNome(especialidade.getNome());
                    return especialidadeRepository.save(e);
                })
                .orElseThrow(
                        () -> new RuntimeException("Especialidade não encontrada com ID: " + especialidade.getId()));
    }

    public void deletar(int id) {
        especialidadeRepository.deleteById(id);
    }

    public long contarTodas() {
        return especialidadeRepository.count();
    }
}
