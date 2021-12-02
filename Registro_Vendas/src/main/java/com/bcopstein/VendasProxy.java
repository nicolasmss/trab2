package com.bcopstein;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="vendas", url="localhost:8080")
public interface VendasProxy {
	
	@GetMapping("/vendas/historico")
	public List<Venda> retrieveValue(
	);

}
