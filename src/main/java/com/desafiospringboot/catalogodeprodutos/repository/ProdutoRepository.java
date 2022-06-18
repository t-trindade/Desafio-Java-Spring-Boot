package com.desafiospringboot.catalogodeprodutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiospringboot.catalogodeprodutos.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, String>{
	
	//public List<Produto> findByNameAndDescriptionOrMin_valorOrMax_valor(String name, String description, Double min_valor, Double max_valor);

}
