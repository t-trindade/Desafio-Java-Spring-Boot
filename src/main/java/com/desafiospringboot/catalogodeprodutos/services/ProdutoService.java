package com.desafiospringboot.catalogodeprodutos.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.desafiospringboot.catalogodeprodutos.Produto;
import com.desafiospringboot.catalogodeprodutos.repository.ProdutoRepository;


@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repo;
	
	//POST Adicionar
	
	public Produto criarProduto(@RequestBody Produto produto) {
		Produto obj = repo.save(produto);
			return obj;
	}
	
	//PUT Atualizar
	public ResponseEntity<Produto> atualizarProduto(@Valid @RequestBody Produto produto, @PathVariable String id) {
		Optional<Produto> obj = repo.findById(id);
			if(obj.isPresent()){
				produto.setId(id);
				produto.setName(produto.getName());
				produto.setDescription(produto.getDescription());
				produto.setPrice(produto.getPrice());
				repo.save(produto);
			}else {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(produto);
}
	
	//GET Por ID
		public ResponseEntity<Produto> buscarID(@RequestBody Produto produto, @PathVariable String id) {
			Optional<Produto> obj = repo.findById(id);	
			if(obj.isPresent()){
				return ResponseEntity.of(obj);
			}else {
				ResponseEntity.notFound().build();	
			}
			return ResponseEntity.of(obj);
		}
			
	//GET Todos itens
	public ResponseEntity<List<Produto>> buscarProduto() {
		List<Produto> obj = repo.findAll();
		return ResponseEntity.ok(obj);
	}
	
	//GET Consulta name, description, valor min e max
		public ResponseEntity<List<Produto>> buscarNome(String name, String description, Double min_valor, Double max_valor) {	
			
			//List<Produto> obj = repo.findByNameAndDescriptionOrMin_valorOrMax_valor(name, description, min_valor,max_valor);
		
			return null; //ResponseEntity.ok().body(obj);
			}
}
