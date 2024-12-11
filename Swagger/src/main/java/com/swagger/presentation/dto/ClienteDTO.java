package com.swagger.presentation.dto;

import com.swagger.persistence.entity.Producto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
public class ClienteDTO {
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String numeroDocumento;


    private Set<Producto> prod  = new HashSet<>();
    public Set<Producto> getProd() {
        return prod;
    }

    public void setProd(Set<Producto> productos) {
        this.prod = prod;
    }
}
