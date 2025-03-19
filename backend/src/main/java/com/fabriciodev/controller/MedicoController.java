package com.fabriciodev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fabriciodev.model.Medico;
import com.fabriciodev.service.MedicoService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicos")
@CrossOrigin(origins = "*")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<Medico> listarTodos() {
        return medicoService.listarTodos();
    }

    @GetMapping("/totalMedicos")
    public long contarEspecialidades() {
        return medicoService.contarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Medico> buscarPorId(@PathVariable int id) {
        return medicoService.buscarPorId(id);
    }

    @PostMapping
    public Medico cadastrar(@RequestBody Medico medico) {
        return medicoService.cadastrar(medico);
    }

    @PutMapping("/{id}")
    public Medico atualizar(@PathVariable int id, @RequestBody Medico medico) {
        medico.setId(id);
        return medicoService.cadastrar(medico);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        medicoService.deletar(id);
    }
}