package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import models.Lote;
import models.Produto;
import repositories.LoteRepository;
import repositories.ProdutoRepository;

public class ProdutoService {
	
	ProdutoRepository prodRep;

	public ProdutoService() {
		this.prodRep = new ProdutoRepository();
	}

	public ProdutoService(ProdutoRepository prodRep) {
		this.prodRep = prodRep;
	}
	
	public List<Produto> listarProdByName(String nome) {
		return getProdsByName(nome, this.prodRep.getAll());
	}

	private List<Produto> getProdsByName(String nome, Collection<Produto> prods) {
		List<Produto> prodsResult = new ArrayList<Produto>();
		for (Produto produto : prods) {
			if(produto.getNome().toLowerCase().contains(nome.toLowerCase())) {
				prodsResult.add(produto);
			}
		}	
		return(prodsResult);
	}
	public void addProduto(Produto p) {
		this.prodRep.addProduto(p);
	}

	public ProdutoRepository getProdRep() {
		return this.prodRep;
	}
}
