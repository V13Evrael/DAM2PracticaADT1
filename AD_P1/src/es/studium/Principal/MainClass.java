package es.studium.Principal;

import es.studium.Modelo.ArticuloAComprar;
import es.studium.Modelo.ListaDeLaCompra;

public class MainClass {

	public static void main(String[] args) {

		// Se crean los artículos:
		ArticuloAComprar art1 = new ArticuloAComprar("Artículo 1", "kg", 1);
		ArticuloAComprar art2 = new ArticuloAComprar("Artículo 2", "m", 2);
		ArticuloAComprar art3 = new ArticuloAComprar("Artículo 3", "unidades", 3);
		ArticuloAComprar art4 = new ArticuloAComprar("Artículo 4", "litro", 1);

		// Se prueba el constructor por defecto: ListaDeLaCompra()

		ListaDeLaCompra lst1 = new ListaDeLaCompra();
		ListaDeLaCompra lst2 = new ListaDeLaCompra();

		// Probamos el método setNombreLista(String nombreLista):
		lst1.setNombreLista("Lista1");
		lst2.setNombreLista("Lista2");

		// Probamos el método getNombreLista():
		System.out.println("La primera lista creada se llama " + lst1.getNombreLista());
		System.out.println("La segunda lista creada se llama " + lst2.getNombreLista());
		System.out.println();

		// Probamos el constructor por parámetros: ListaDeLaCompra(String nombreLista)
		lst1 = new ListaDeLaCompra("NuevaLista1");
		lst2 = new ListaDeLaCompra("NuevaLista2");

		// Probamos el método agregarProductoAComprar(ArticuloAComprar articulo): 
		//(Lo probamos más de dos veces para poder usar las listas correctamente).
		lst1.agregarProductoAComprar(art1);
		lst1.agregarProductoAComprar(art2);
		lst1.agregarProductoAComprar(art3);

		lst2.agregarProductoAComprar(art4);
		lst2.agregarProductoAComprar(art3);

			// Mostramos los elementos para probar que efectivamente fueron creados: 
			//(Aprovechamos para probar el método getArticulos())
			System.out.println("La lista " + lst1.getNombreLista() + " contiene:");
			for (ArticuloAComprar art : lst1.getArticulos()) {

				System.out.println(art.getDescripcion() + " Cantidad: " + art.getCantidad() + " Unidad: " + art.getUnidad());
			}
			
			System.out.println();
			
			System.out.println("La lista " + lst2.getNombreLista() + " contiene:");
			for (ArticuloAComprar art : lst2.getArticulos()) {

				System.out.println(art.getDescripcion() + " Cantidad: " + art.getCantidad() + " Unidad: " + art.getUnidad());
			}
			
			System.out.println();
			
		//Probamos el método eliminarArticulo(String descripcionArticulo):
		lst1.eliminarArticulo("Artículo 1");
		lst2.eliminarArticulo("Artículo 3");
		
			// Volvemos a mostrar el contenido de las listas, para comprobar que fueron eliminados.
			System.out.println("Después de la eliminación, la lista " + lst1.getNombreLista() + " contiene:");
			for (ArticuloAComprar art : lst1.getArticulos()) {
			
				System.out.println(art.getDescripcion() + " Cantidad: " + art.getCantidad() + " Unidad: " + art.getUnidad());
			}
		
			System.out.println();
		
			System.out.println("Después de la eliminación, la lista " + lst2.getNombreLista() + " contiene:");
			for (ArticuloAComprar art : lst2.getArticulos()) {

				System.out.println(art.getDescripcion() + " Cantidad: " + art.getCantidad() + " Unidad: " + art.getUnidad());
			}
			
			System.out.println();
			
		
			
		/*
		 * //Exportamos la lista. lst.exportaListaDeLaCompra();
		 * 
		 * 
		 * //A continuación creamos una lista en base al elemento exportado:
		 * ListaDeLaCompra lstExportada =
		 * ListaDeLaCompra.importaListaDeLaCompra("ListaPrueba");
		 * 
		 * lstExportada.eliminarArticulo("Articulo 1");
		 * 
		 * //Y aquí mostramos que efectivamente se crearon los artículos: for
		 * (ArticuloAComprar art : lstExportada.getArticulos()) {
		 * 
		 * System.out.println(art.getDescripcion() + " Cantidad: " + art.getCantidad() +
		 * " Unidad: " + art.getUnidad()); }
		 */
	}
}
