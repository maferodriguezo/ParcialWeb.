package com.example.entidadcontrato.model;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String identificador;
    
    @Column(nullable = false)
    private Double valor;
    
    @Column(nullable = false)
    private String nombreContratante;
    
    @Column(nullable = false)
    private String documentoContratante;
    
    @Column(nullable = false)
    private String nombreContratista;
    
    @Column(nullable = false)
    private String documentoContratista;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicial;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entidad_id", nullable = false)
    private Entidad entidad;

    // Constructores, getters y setters
    public Contrato() {}
    
    // Getters y Setters
    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public String getIdentificador() { 
        return identificador; 
    }

    public void setIdentificador(String identificador) { 
        this.identificador = identificador; 
    }

    public Double getValor() { 
        return valor; 
    }

    public void setValor(Double valor) { 
        this.valor = valor; 
    }

    public String getNombreContratante() { 
        return nombreContratante; 
    }

    public void setNombreContratante(String nombreContratante) { 
        this.nombreContratante = nombreContratante; 
    }

    public String getDocumentoContratante() { 
        return documentoContratante; 
    }

    public void setDocumentoContratante(String documentoContratante) { 
        this.documentoContratante = documentoContratante; 
    }

    public String getNombreContratista() { 
        return nombreContratista; 
    }

    public void setNombreContratista(String nombreContratista) { 
        this.nombreContratista = nombreContratista; 
    }

    public String getDocumentoContratista() { 
        return documentoContratista; 
    }

    public void setDocumentoContratista(String documentoContratista) { 
        this.documentoContratista = documentoContratista; 
    }

    public Date getFechaInicial() { 
        return fechaInicial; 
    }

    public void setFechaInicial(Date fechaInicial) { 
        this.fechaInicial = fechaInicial; 
    }

    public Date getFechaFinal() { 
        return fechaFinal; 
    }

    public void setFechaFinal(Date fechaFinal) { 
        this.fechaFinal = fechaFinal; 
    }

    public Entidad getEntidad() { 
        return entidad; 
    }

    public void setEntidad(Entidad entidad) { 
        this.entidad = entidad; 
    }
    
}