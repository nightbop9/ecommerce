package com.senai.ecommerce.services;

import com.senai.ecommerce.dto.PagamentoDTO;
import com.senai.ecommerce.dto.PedidoDTO;
import com.senai.ecommerce.entities.Pagamento;
import com.senai.ecommerce.entities.Pedido;
import com.senai.ecommerce.entities.StatusDoPedido;
import com.senai.ecommerce.repositories.PagamentoRepository;
import com.senai.ecommerce.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Instant;

@Service
public class PagamentoService {
    @Autowired
    PagamentoRepository pagamentoRepository;
    @Autowired
    PedidoRepository pedidoRepository;

    @Transactional
    public PedidoDTO pagar(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow();
        pedido.setStatus(StatusDoPedido.PAGO);
        pedidoRepository.save(pedido);
        Pagamento pagamento = new Pagamento();
        pagamento.setPedido(pedido);
        pagamento.setMomento(Instant.now());
        pagamentoRepository.save(pagamento);
        return new PedidoDTO(pedido);
    }
}
