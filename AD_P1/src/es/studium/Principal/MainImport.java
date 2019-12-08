package es.studium.Principal;

import es.studium.Modelo.ArticuloAComprar;
import es.studium.Modelo.ListaDeLaCompra;

public class MainImport {

	public static void main(String[] args) {

		//Probamos el método importaListaDeLaCompra():
		ListaDeLaCompra lstImportada1 = ListaDeLaCompra.importaListaDeLaCompra("NuevaLista1");
		ListaDeLaCompra lstImportada2 = ListaDeLaCompra.importaListaDeLaCompra("NuevaLista2");
		
			//Mostramos el contenido de estas dos listas para probar que la importación tuvo éxito.
			System.out.println("La lista " + lstImportada1.getNombreLista() + " contiene:");
			for (ArticuloAComprar art : lstImportada1.getArticulos()) {
		
				System.out.println(art.getDescripcion() + " Cantidad: " + art.getCantidad() + " Unidad: " + art.getUnidad());
			}
	
			System.out.println();
	
			System.out.println("La lista " + lstImportada2.getNombreLista() + " contiene:");
			for (ArticuloAComprar art : lstImportada2.getArticulos()) {

				System.out.println(art.getDescripcion() + " Cantidad: " + art.getCantidad() + " Unidad: " + art.getUnidad());
			}		
	}
}
