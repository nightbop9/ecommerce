package com.senai.ecommerce.repositories;

import com.senai.ecommerce.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
