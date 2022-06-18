package com.desafiospringboot.catalogodeprodutos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafiospringboot.catalogodeprodutos.Produto;
import com.desafiospringboot.catalogodeprodutos.services.ProdutoService;

@RestController
public class ProdutoController {
	
	//Injetando depedências do Service
	
	@Autowired
	private ProdutoService Service;
	
	//Criando Endpoint POST
	
	@PostMapping("/products")
	public ResponseEntity<Produto>  criarProduto(@Valid @RequestBody Produto produto) {
		Produto obj = Service.criarProduto(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}
	
	//Criando Endpoint PUT
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto produto, @PathVariable String id){
		ResponseEntity<Produto> obj = Service.atualizarProduto(produto, id);
		return obj;
	}
	
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Produto> buscarID(@PathVariable String id, Produto produto){
		return Service.buscarID(produto, id);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Produto>> buscarProduto(){
		return Service.buscarProduto();
	}
	
	@GetMapping("/products/search")
	public ResponseEntity<List<Produto>>
	bucarNomeOuDescriçao(@RequestParam(value="q", required = false) String name,
						@RequestParam(value="q", required = false) String description,
						@RequestParam(value="min_price", required = false) Double min_valor,
						@RequestParam(value="max_price", required = false, defaultValue = "999999999999") Double max_valor)
																{
		ResponseEntity<List<Produto>> obj = Service.buscarNome(name,description, min_valor, max_valor);
		
		return obj;
	}
	
	
	
	
}
