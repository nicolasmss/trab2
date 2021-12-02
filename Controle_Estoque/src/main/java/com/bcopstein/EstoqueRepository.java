package com.bcopstein;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository 
	extends JpaRepository<ItemEstoque, Long> {
		ItemEstoque findByNroItem(Long nroItem);
}
