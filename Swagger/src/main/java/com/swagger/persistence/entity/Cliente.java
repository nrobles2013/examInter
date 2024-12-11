package com.swagger.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    private String codigoUnico;

    @Column(nullable = false, length = 60)
    private String nombres;

    @Column(nullable = false, length = 60)
    private String apellidos;

    @Column(nullable = false, length = 60)
    private String tipoDocumento;

    @Column(nullable = false, length = 60)
    private String numeroDocumento;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cliente_producto",
            joinColumns = @JoinColumn(name = "codigoUnico", referencedColumnName = "codigoUnico"),
            inverseJoinColumns = @JoinColumn(name = "tipoProductos", referencedColumnName = "tipoProductos")
    )





    private Set<Producto> prod  = new HashSet<>();
    public Set<Producto> getProd() {
        return prod;
    }

    public void setProd(Set<Producto> productos) {
        this.prod = prod;
    }

}
