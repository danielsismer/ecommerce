package com.ecommerce.app.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_geracao")
    private LocalDate dataGeraco;

    @Column(name = "data_entrega")
    private LocalDate dataEntrega;

    public Pedido(LocalDate dataGeraco, LocalDate dataEntrega) {
        this.dataGeraco = dataGeraco;
        this.dataEntrega = dataEntrega;
    }
}
