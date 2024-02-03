package org.pessoal.gestordecostura.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table
public class PedidoModel {
    private static final long serialVersionUUID = 1L;

    @Id
    @GeneratedValue
    private UUID id_pedido;

    private boolean finalizado;
    private Date data;
    @ManyToOne
    @JoinColumn
    private ClienteModel cliente;

}
