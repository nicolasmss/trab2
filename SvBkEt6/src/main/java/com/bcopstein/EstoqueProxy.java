package com.bcopstein;

import java.util.List;

import com.bcopstein.Negocio.Entidades.ItemEstoque.ItemEstoque;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="controle-estoque", url="localhost:8200", configuration = ProxyConfig.class)
//(basePackages = {"my.external.feign.client.package", "my.local.package"})
//@RequestMapping("/controle_estoque")
public interface EstoqueProxy {
	
	@PostMapping("/novo")
	public boolean novo(@RequestParam Long codigo, @RequestParam Integer qtd );

	@GetMapping("/registros_disponiveis")
	public List<ItemEstoque> retornaTodosDisponiveis();

	@GetMapping("/checar_estoque")
	public boolean temNoEstoque(@RequestParam Long codigo,@RequestParam Integer qtd);

	@PostMapping("/subtrair")
	public boolean subtrairEstoque(@RequestParam Long codigo,@RequestParam Integer qtd);

	@GetMapping("/todos")
	public List<ItemEstoque> todos();

	@PostMapping("/cadastro")
	public boolean cadastro(@RequestBody ItemEstoque item);

	@GetMapping("/todos_cod")
	public List<ItemEstoque> todosDoCod(@RequestParam Long codigo);

}
