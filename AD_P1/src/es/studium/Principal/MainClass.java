package es.studium.Principal;

import es.studium.Modelo.ArticuloAComprar;
import es.studium.Modelo.ListaDeLaCompra;

public class MainClass {

	public static void main(String[] args) {

		ArticuloAComprar art1 = new ArticuloAComprar("Articulo 1", "kg", 1);
		ArticuloAComprar art2 = new ArticuloAComprar("Articulo 2", "m", 2);
		ArticuloAComprar art3 = new ArticuloAComprar("Articulo 3", "unidades", 3);
		
		ListaDeLaCompra lst = new ListaDeLaCompra("ListaPrueba");
		lst.agregarProductoAComprar(art1);
		lst.agregarProductoAComprar(art2);
		lst.agregarProductoAComprar(art3);
		
		lst.exportaListaDeLaCompra();
	}

}
