package com.bcopstein;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bcopstein.ItemEstoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
//@RequestMapping("/controle_estoque")
public class CurrencyConversionController {

	@Autowired
	private EstoqueRepository repository;

	@PostMapping("/cadastro")
	public boolean cadastro(@RequestBody ItemEstoque item) {
		boolean igual = false;
		for (ItemEstoque itemEstoque : repository.findAll()) {
			if(itemEstoque.getCodigoProduto()==item.getCodigoProduto()){
				return false;
			}
		}
		if(!igual){
			repository.save(new ItemEstoque(item.getCodigoProduto(),item.getQuantidade()));
			return true;
		}
		return false;
	}
	
	@PostMapping("/novo")
	public boolean novoItem(@RequestParam Long codigo, @RequestParam Integer qtd) {
		for (ItemEstoque itemEstoque : repository.findAll()) {
			if(itemEstoque.getCodigoProduto()==codigo){
				itemEstoque.entrada(qtd);
				return true;
			}
		}
		return false;
	}

	@GetMapping("/registros_disponiveis")
	public List<ItemEstoque> retornaTodosDisponiveis() {
		List<ItemEstoque> lista = new ArrayList<>();
		for (ItemEstoque itemEstoque : repository.findAll()) {
			if(itemEstoque.getQuantidade()>0){
				lista.add(itemEstoque);
			}
		}
		return lista;
	}

	@GetMapping("/checar_estoque")
	public boolean temNoEstoque(@RequestParam Long codigo,@RequestParam Integer qtd) {
		for (ItemEstoque itemEstoque : repository.findAll()) {
			if(itemEstoque.getCodigoProduto()==codigo){
				if(itemEstoque.getQuantidade()>=qtd){
					return true;
				}
			}
		}
		return false;
	}

	@PostMapping("/subtrair")
	public boolean subtrairEstoque(@RequestParam Long codigo,@RequestParam Integer qtd){
		for (ItemEstoque itemEstoque : repository.findAll()) {
			if(itemEstoque.getCodigoProduto()==codigo){
				if(itemEstoque.getQuantidade()>qtd){
					itemEstoque.saida(qtd);
					return true;
				}
			}
		}
		return false;
	}

	@GetMapping("/todos")
	public List<ItemEstoque> todos(){
		return repository.findAll();
	}

	@GetMapping("/todos_cod")
	public List<ItemEstoque> todosDoCod(@RequestParam Long codigo){
		List<ItemEstoque> lista = new ArrayList<ItemEstoque>();
		for (ItemEstoque item : repository.findAll()) {
			if(item.getCodigoProduto()==codigo){
				lista.add(item);
			}
		}
		return lista;
	}


	
}
