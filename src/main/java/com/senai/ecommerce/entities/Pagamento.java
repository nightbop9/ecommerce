package com.senai.ecommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento {

	@Id
	private Long id; // id do pedido

	@OneToOne
	@MapsId // mapeia o id do pagamento com o id do pedido
	private Pedido pedido;

	private Instant momento;

	public Pagamento() {
	}

	public Pagamento(Long id, Pedido pedido, Instant momento) {
		this.id = id;
		this.pedido = pedido;
		this.momento = momento;
	}

	public Pagamento(Pedido pedido) {
		this.id = pedido.getId();
		this.momento = Instant.now();
		this.pedido = pedido;
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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
