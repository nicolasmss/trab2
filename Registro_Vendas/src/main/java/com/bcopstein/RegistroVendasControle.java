package com.bcopstein;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RegistroVendasControle {

	@Autowired
	private VendasProxy proxy;

	@Autowired
	private VendaRepository repository;
	
	@PostMapping("/registro_venda/codigo")
	public boolean registrarVenda(@RequestBody Venda from) {
		List<Venda> lista = proxy.retrieveValue();

		for (Venda venda : lista) {
			if(venda.getCodigo()==from.getCodigo()){
				repository.save(venda);
				return true;
			}
		}
		return false;
	}

	@GetMapping("/registro_venda/todos_registros")
	public List<Venda> retornaTodos() {
		return repository.findAll();
	}
	
}
