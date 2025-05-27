package com.example.entidadcontrato.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "entidad")
public class Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String nit;
    
    @Column(nullable = false)
    private String nombre;
    
    @OneToMany(mappedBy = "entidad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contrato> contratos;

    // Constructores, getters y setters
    public Entidad() {}
    
    public Entidad(String nit, String nombre) {
        this.nit = nit;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public String getNit() { 
        return nit; 
    }

    public void setNit(String nit) { 
        this.nit = nit; 
    }
    public String getNombre() { 
        return nombre; 
    }

    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public List<Contrato> getContratos() { 
        return contratos; 
    }

    public void setContratos(List<Contrato> contratos) { 
        this.contratos = contratos; 
    }
    
}