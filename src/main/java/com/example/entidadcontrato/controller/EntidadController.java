package com.example.entidadcontrato.controller;

import com.example.entidadcontrato.dto.EntidadDTO;
import com.example.entidadcontrato.service.EntidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entidades")
public class EntidadController {
    @Autowired
    private EntidadService entidadService;

    @GetMapping
    public List<EntidadDTO> getAllEntidades() {
        return entidadService.getAllEntidades();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EntidadDTO> getEntidadById(@PathVariable Long id) {
        return ResponseEntity.ok(entidadService.getEntidadById(id));
    }
    
    @PostMapping
    public ResponseEntity<EntidadDTO> createEntidad(@RequestBody EntidadDTO entidadDTO) {
        return ResponseEntity.ok(entidadService.createEntidad(entidadDTO));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<EntidadDTO> updateEntidad(
            @PathVariable Long id, @RequestBody EntidadDTO entidadDTO) {
        return ResponseEntity.ok(entidadService.updateEntidad(id, entidadDTO));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntidad(@PathVariable Long id) {
        entidadService.deleteEntidad(id);
        return ResponseEntity.noContent().build();
    }
    
}