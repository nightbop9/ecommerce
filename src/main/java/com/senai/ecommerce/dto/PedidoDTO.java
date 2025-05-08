package com.senai.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.senai.ecommerce.entities.ItemDoPedido;
import com.senai.ecommerce.entities.Pedido;
import com.senai.ecommerce.entities.StatusDoPedido;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {
	
	
	private Long id;
	private Instant momento;
	private StatusDoPedido status;
	@JsonProperty("clienteId")
	private Long clienteId;
	private List<ItemDoPedidoDTO> items = new ArrayList<>();

	public PedidoDTO() {

	}


	public PedidoDTO(Long id, Instant momento, StatusDoPedido status, Long clienteId) {
		this.id = id;
		this.momento = momento;
		this.status = status;
		this.clienteId = clienteId;
	}

	public PedidoDTO(Pedido pedido) {
		id = pedido.getId();
		momento = pedido.getMomento();
		status = pedido.getStatus();
		clienteId = pedido.getCliente().getId();
		for(ItemDoPedido item : pedido.getItems()) {
			items.add(new ItemDoPedidoDTO(item));
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public StatusDoPedido getStatus() {
		return status;
	}

	public void setStatus(StatusDoPedido status) {
		this.status = status;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public List<ItemDoPedidoDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDoPedidoDTO> items) {
		this.items = items;
	}
}
