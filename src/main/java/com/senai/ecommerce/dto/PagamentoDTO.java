package com.senai.ecommerce.dto;

import com.senai.ecommerce.entities.Pedido;

import java.time.Instant;

public class PagamentoDTO {
    private Long id;
    private Long pedidoId;
    private Instant momento;

    public PagamentoDTO() {
    }

    public PagamentoDTO(Long id, Long pedidoId, Instant momento) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.momento = momento;
    }

    public PagamentoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.momento = Instant.now();
        this.pedidoId = pedido.getId();
    }

    public Long getId() {
        return id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }
}
