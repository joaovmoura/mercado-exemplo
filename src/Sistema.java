import java.util.List;

import controllers.CatalogoController;
import models.Lote;
import models.Produto;
import repositories.LoteRepository;
import repositories.ProdutoRepository;
import services.LoteService;
import services.ProdutoService;

public class Sistema {

	private static CatalogoController catalogoController = new CatalogoController();
	 
	public static void main(String[] args) {
		
		Produto p1 = new Produto("Leite", "Parmalat", 10.5);
		Produto p2 = new Produto("Leite integral", "Vale", 6.5);
		Produto p3 = new Produto("Cuscuz", "Vitamilho", 1.19);
		Produto p4 = new Produto("Cuscuz", "Sao Braz", 1.25);
		Produto p5 = new Produto("Cuscuz", "Flocao", 1);

		Lote l1 = new Lote(p1, 10L);
		Lote l2 = new Lote(p3, 10L);
		Lote l3 = new Lote(p4, 20L);


		// Adicionando produtos no cat�logo		
		catalogoController.addProduto(p1);
		catalogoController.addProduto(p2);
		catalogoController.addProduto(p3);
		catalogoController.addProduto(p4);
		catalogoController.addProduto(p5);

		
		// Adicionando lotes no cat�logo
		catalogoController.addLote(l1);
		catalogoController.addLote(l2);
		catalogoController.addLote(l3);
		
		// Consulta de produto "leite" no cat�logo de produto
		List<Produto> selection = catalogoController.getProdsByName("leite");
		System.out.println(selection);
		
		// Consulta de produto "leite" no cat�logo de produto com lotes no sistema
		List<Produto> selectionWithLote = catalogoController.getProdsDisponiveis("leite");
		System.out.println(selectionWithLote);

		System.out.println("------------------------------------");

		List<Produto> selection2 = catalogoController.getProdsByName("cuscuz");
		System.out.println(selection2);
		List<Produto> selectionWithLote2 = catalogoController.getProdsDisponiveis("cuscuz");
		System.out.println(selectionWithLote2);
	}
}
