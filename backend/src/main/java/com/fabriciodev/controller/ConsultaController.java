package com.fabriciodev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fabriciodev.dto.ConsultaDTO;
import com.fabriciodev.model.Consulta;
import com.fabriciodev.service.ConsultaService;
import java.util.List;

@RestController
@RequestMapping("/api/consultas")
@CrossOrigin(origins = "*")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public List<ConsultaDTO> listarTodas() {
        return consultaService.listarTodas()
                .stream()
                .map(ConsultaDTO::fromEntity)
                .toList();
    }

    @GetMapping("/totalConsultas")
    public long contarEspecialidades() {
        return consultaService.contarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> buscarPorId(@PathVariable int id) {
        return consultaService.buscarPorId(id)
                .map(ConsultaDTO::fromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Consulta agendar(@RequestBody Consulta consulta) {
        return consultaService.agendarConsulta(consulta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> editar(@PathVariable int id, @RequestBody Consulta consulta) {
        consulta.setId(id);
        Consulta atualizada = consultaService.editarConsulta(consulta);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public void cancelar(@PathVariable int id) {
        consultaService.cancelarConsulta(id);
    }
}
