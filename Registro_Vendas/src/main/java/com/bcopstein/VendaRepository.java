package com.bcopstein;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {
	List<Venda> findAll();
}
