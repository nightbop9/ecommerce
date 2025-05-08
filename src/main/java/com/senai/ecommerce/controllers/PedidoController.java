package com.senai.ecommerce.controllers;

import com.senai.ecommerce.dto.PedidoDTO;
import com.senai.ecommerce.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	
	@PostMapping("/inserir")
	public ResponseEntity<PedidoDTO> inserir(@RequestBody PedidoDTO dto){
		dto = pedidoService.inserir(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}

	@GetMapping("{id}")
	public ResponseEntity<PedidoDTO> Buscar(@PathVariable Long id){
		return ResponseEntity.ok(pedidoService.findById(id));
	}
}
