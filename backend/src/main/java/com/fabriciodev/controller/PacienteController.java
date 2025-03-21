package com.fabriciodev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fabriciodev.model.Paciente;
import com.fabriciodev.service.PacienteService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> listarTodos() {
        return pacienteService.listarTodos();
    }

    @GetMapping("/totalPacientes")
    public long contarEspecialidades() {
        return pacienteService.contarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Paciente> buscarPorId(@PathVariable int id) {
        return pacienteService.buscarPorId(id);
    }

    @PostMapping("/create")
    public Paciente cadastrar(@RequestBody Paciente paciente) {
        return pacienteService.cadastrar(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> editar(@PathVariable int id, @RequestBody Paciente paciente) {
        paciente.setId(id);
        Paciente atualizado = pacienteService.editar(paciente);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        pacienteService.deletar(id);
    }
}
