package com.senai.ecommerce.dto;

import com.senai.ecommerce.entities.ItemDoPedido;

public class ItemDoPedidoDTO {
    private Long idProduto;
    private String nome;
    private Double preco;
    private Integer quantidade;
    private String imgUrl;

    public ItemDoPedidoDTO() {
    }

    public ItemDoPedidoDTO(Long idProduto, String nome, Double preco, Integer quantidade, String imgUrl) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imgUrl = imgUrl;
    }

    public ItemDoPedidoDTO(ItemDoPedido itemDoPedido) {
        this.idProduto = itemDoPedido.getProduto().getId();
        this.nome = itemDoPedido.getProduto().getNome();
        this.preco = itemDoPedido.getProduto().getPreco();
        this.quantidade = itemDoPedido.getQuantidade();
        this.imgUrl = itemDoPedido.getProduto().getImgUrl();
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    private Double getSubTotal() {
        return preco * quantidade;
    }
}