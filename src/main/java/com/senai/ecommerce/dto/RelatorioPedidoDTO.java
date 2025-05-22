package com.senai.ecommerce.dto;

import com.senai.ecommerce.entities.Pedido;

import java.time.format.DateTimeFormatter;

public class RelatorioPedidoDTO {
    private Long pedido;
    private String cliente;
    private String status;
    private String momento;

    public RelatorioPedidoDTO(Pedido pedido) {
        this.pedido = pedido.getId();
        this.cliente = pedido.getCliente().getNome();
        this.status = pedido.getStatus().toString();
        this.momento = pedido.getMomento().atZone(java.time.ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public Long getPedido() {
        return pedido;
    }

    public String getCliente() {
        return cliente;
    }

    public String getStatus() {
        return status;
    }

    public String getMomento() {
        return momento;
    }
}
