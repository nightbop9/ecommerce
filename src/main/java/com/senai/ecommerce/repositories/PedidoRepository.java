package com.senai.ecommerce.repositories;

import com.senai.ecommerce.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
