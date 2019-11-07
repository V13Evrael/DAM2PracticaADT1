package es.studium.Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class ListaDeLaCompra.
 */
public class ListaDeLaCompra implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The nombre. */
	private String nombre;
	
	/** The lista. */
	private ArrayList<ArticuloAComprar> lista = new ArrayList<ArticuloAComprar>();

	/**
	 * Instantiates a new lista de la compra.
	 */
	public ListaDeLaCompra() {

		nombre = "";
	}

	/**
	 * Instantiates a new lista de la compra.
	 *
	 * @param nombre the nombre
	 */
	public ListaDeLaCompra(String nombre) {

		this.nombre = nombre;
	}

	/**
	 * Gets the nombre lista.
	 *
	 * @return the nombre lista
	 */
	public String getNombreLista() {

		return this.nombre;
	}

	/**
	 * Sets the nombre lista.
	 *
	 * @param nuevoNombre the new nombre lista
	 */
	public void setNombreLista(String nuevoNombre) {

		this.nombre = nuevoNombre;
	}

	/**
	 * Agregar producto A comprar.
	 *
	 * @param articulo the articulo
	 */
	public void agregarProductoAComprar(ArticuloAComprar articulo) {

		this.lista.add(articulo);
	}

	/**
	 * Gets the articulos.
	 *
	 * @return the articulos
	 */
	public ArrayList<ArticuloAComprar> getArticulos() {

		return this.lista;
	}

	/**
	 * Eliminar articulo.
	 *
	 * @param desc the desc
	 */
	public void eliminarArticulo(String desc) {

		for (ArticuloAComprar art : this.getArticulos()) {
			if (art.getDescripcion().equals(desc)) {
				this.getArticulos().remove(art);
				break;
			}
		}
	}

	/**
	 * Exporta lista de la compra.
	 */
	public void exportaListaDeLaCompra() {

		try {
			
			File listaDataExp = new File(".\\datosListas\\" + this.getNombreLista() + ".data");
			FileOutputStream fos = new FileOutputStream(listaDataExp);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		
			oos.writeObject(this);
			oos.close();
			
		} catch (FileNotFoundException e) {

			System.out.println("El archivo no se encuentra");
			
		} catch (IOException e) {
			
			System.out.println("Se ha producido un error en la entrada/salida de los datos");
		}
	}
	
	/**
	 * Importa lista de la compra.
	 *
	 * @param nombreLista the nombre lista
	 * @return the lista de la compra
	 */
	public static ListaDeLaCompra importaListaDeLaCompra(String nombreLista) {
		
		String ruta = ".\\datosListas\\";
		
		ListaDeLaCompra resultado = new ListaDeLaCompra();
		
		try {
			File listaDataImp = new File(ruta + nombreLista);
			FileInputStream fis = new FileInputStream(listaDataImp);
			ObjectInputStream ois = new ObjectInputStream(fis);
			resultado = (ListaDeLaCompra) ois.readObject();
			ois.close();
			
		} catch (FileNotFoundException e) {
		
			System.out.println("El archivo no se encuentra");

		} catch (IOException e) {
			
			System.out.println("Se ha producido un error en la entrada/salida de los datos");
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("La clase del objeto leído no se corresponde con una Lista De La Compra");
		} 
		
		return resultado;
	}
}
