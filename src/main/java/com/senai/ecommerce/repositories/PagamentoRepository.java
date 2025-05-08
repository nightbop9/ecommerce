package com.senai.ecommerce.repositories;

import com.senai.ecommerce.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
