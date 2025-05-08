package com.senai.ecommerce.services;

import com.senai.ecommerce.dto.ItemDoPedidoDTO;
import com.senai.ecommerce.dto.PedidoDTO;
import com.senai.ecommerce.entities.*;
import com.senai.ecommerce.repositories.PedidoRepository;
import com.senai.ecommerce.repositories.ProdutoRepository;
import com.senai.ecommerce.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ProdutoRepository produtoRepository;
    @Autowired
    private ItemDoPedidoRepository itemDoPedidoRepository;


	@Transactional
	public PedidoDTO inserir(PedidoDTO pedidoDTO) {
		Pedido pedido = new Pedido();
		pedido.setMomento(Instant.now());
		pedido.setStatus(StatusDoPedido.AGUARDANDO_PAGAMENTO);
		pedido.setCliente(usuarioRepository.getReferenceById(pedidoDTO.getClienteId()));

		for(ItemDoPedidoDTO itemDoPedidoDTO : pedidoDTO.getItems()) {
			Produto produto = produtoRepository.getReferenceById(itemDoPedidoDTO.getIdProduto());
			ItemDoPedido item = new ItemDoPedido(pedido, produto,
					itemDoPedidoDTO.getQuantidade(), itemDoPedidoDTO.getPreco());
			pedido.getItems().add(item);
		}

		pedidoRepository.save(pedido);
		itemDoPedidoRepository.saveAll(pedido.getItems());
		return new PedidoDTO(pedido);
	}

	@Transactional
	public PedidoDTO findById(Long id) {
		Pedido pedido = pedidoRepository.getById(id);
		return new PedidoDTO(pedido);
	}

}
