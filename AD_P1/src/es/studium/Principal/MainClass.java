package es.studium.Principal;

import es.studium.Modelo.ArticuloAComprar;
import es.studium.Modelo.ListaDeLaCompra;

public class MainClass {

	public static void main(String[] args) {

		//Se crean los artículos:
		ArticuloAComprar art1 = new ArticuloAComprar("Articulo 1", "kg", 1);
		ArticuloAComprar art2 = new ArticuloAComprar("Articulo 2", "m", 2);
		ArticuloAComprar art3 = new ArticuloAComprar("Articulo 3", "unidades", 3);
		
		//Se crea la lista de la compra y se agregan los artículos:
		ListaDeLaCompra lst = new ListaDeLaCompra("ListaPrueba");
		lst.agregarProductoAComprar(art1);
		lst.agregarProductoAComprar(art2);
		lst.agregarProductoAComprar(art3);
		
		//Exportamos la lista.
		lst.exportaListaDeLaCompra();		
		
		
		//A continuación creamos una lista en base al elemento exportado:
		ListaDeLaCompra lstExportada = ListaDeLaCompra.importaListaDeLaCompra("ListaPrueba.data");
		
		//Y aquí mostramos que efectivamente se crearon los artículos:
		for (ArticuloAComprar art : lstExportada.getArticulos()) {
			
			System.out.println(art.getDescripcion() + " Cantidad: " + art.getCantidad() + " Unidad: " + art.getUnidad());
		}
		
	}

}
