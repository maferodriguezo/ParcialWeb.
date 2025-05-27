package com.example.entidadcontrato.service;

import com.example.entidadcontrato.dto.EntidadDTO;
import com.example.entidadcontrato.model.Entidad;
import com.example.entidadcontrato.repository.EntidadRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntidadService {
    @Autowired
    private EntidadRepository entidadRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    public List<EntidadDTO> getAllEntidades() {
        return entidadRepository.findAll().stream()
                .map(entidad -> modelMapper.map(entidad, EntidadDTO.class))
                .collect(Collectors.toList());
    }
    
    public EntidadDTO getEntidadById(Long id) {
        Entidad entidad = entidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entidad no encontrada"));
        return modelMapper.map(entidad, EntidadDTO.class);
    }
    
    public EntidadDTO createEntidad(EntidadDTO entidadDTO) {
        Entidad entidad = modelMapper.map(entidadDTO, Entidad.class);
        Entidad savedEntidad = entidadRepository.save(entidad);
        return modelMapper.map(savedEntidad, EntidadDTO.class);
    }
    
    public EntidadDTO updateEntidad(Long id, EntidadDTO entidadDTO) {
        Entidad entidad = entidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entidad no encontrada"));
        
        entidad.setNit(entidadDTO.getNit());
        entidad.setNombre(entidadDTO.getNombre());
        
        Entidad updatedEntidad = entidadRepository.save(entidad);
        return modelMapper.map(updatedEntidad, EntidadDTO.class);
    }
    
    public void deleteEntidad(Long id) {
        entidadRepository.deleteById(id);
    }
}