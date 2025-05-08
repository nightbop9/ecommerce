package com.senai.ecommerce.controllers;

import com.senai.ecommerce.dto.PedidoDTO;
import com.senai.ecommerce.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {
    @Autowired
    PagamentoService pagamentoService;

    @PostMapping("/{id}")
    public PedidoDTO pagar (@PathVariable Long id) {
        return pagamentoService.pagar(id);
    }
}
