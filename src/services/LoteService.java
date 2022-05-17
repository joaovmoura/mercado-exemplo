package services;

import models.Lote;
import models.Produto;
import repositories.LoteRepository;

import java.util.ArrayList;
import java.util.List;

public class LoteService {

	private LoteRepository loteRep;

	public LoteService() {
		this.loteRep = new LoteRepository();
	}

	public LoteService(LoteRepository rep) {
		this.loteRep = rep;
	}
	
	public void addLote(Lote lote) {
		this.loteRep.addLote(lote);
	}

	public LoteRepository getLoteRep() {
		return this.loteRep;
	}

	public List<Produto> getProdsDisponiveis(String nome) {
		List<Produto> produtos = new ArrayList<>();
		for(Lote l: this.loteRep.getAll()) {
			Produto p = l.getProduto();
			if((p.getNome().toLowerCase()).contains(nome.toLowerCase()))
				produtos.add(p);
		}
		return produtos;
	}
}
