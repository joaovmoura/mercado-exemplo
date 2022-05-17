package controllers;

import models.Lote;
import models.Produto;
import services.LoteService;
import services.ProdutoService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CatalogoController {
    private ProdutoService produtoService;
    private LoteService loteService;

    public CatalogoController() {
        this.produtoService =  new ProdutoService();
        this.loteService = new LoteService();
    }

    public void addProduto(Produto produto){
        this.produtoService.addProduto(produto);
    }

    public void addLote(Lote lote){
        this.loteService.addLote(lote);
    }

    public List<Produto> getProdsByName (String nome) {
        return produtoService.listarProdByName(nome);
    }

    public List<Produto> getProdsDisponiveis (String nome) {
        return loteService.getProdsDisponiveis(nome);
    }
}
