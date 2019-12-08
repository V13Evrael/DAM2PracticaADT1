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
 * <p>La clase ListaDeLaCompra representa una lista de la compra concreta que tendrá en su interior
 *  una serie de artículos (elementos de la clase {@link ArticuloAComprar}) 
 *  especificados dentro de un {@link java.util.ArrayList ArrayList} 
 *  representado a su vez por el atributo {@link ListaDeLaCompra#lista lista}.
 * </p>
 * <p>Implementa la interfaz {@link java.io.Serializable Serializable} ya que será necesaria la permanencia de las listas mediante un archivo .dat que guardará el propio objeto.
 * 
 * @author José Manuel Platero
 */
public class ListaDeLaCompra implements Serializable {

	/** La constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Este atributo representa el nombre de la lista. Este atributo se usará para dar nombre al fichero .dat creado para mantener un objeto concreto de la lista. */
	private String nombre;
	
	/** Este atributo representa la propia lista mediante un {@link java.io.ArrayList ArrayList} que contendrá todos los artículos de la clase {@link ArticuloAComprar} que contiene la lista. */
	private ArrayList<ArticuloAComprar> lista = new ArrayList<ArticuloAComprar>();

	/**
	 * Constructor de la clase ListaDeLaCompra.<br>
	 * Instancia un objeto de la clase dándole un nombre que será la cadena vacía.
	 * Para poder hacer uso de la persistencia mediante los correspondientes métodos, será necesario indicar un {@link #nombre}.
	 */
	public ListaDeLaCompra() {

		nombre = "";
	}

	/**
	 * Instantiates a new lista de la compra.
	 *
	 * @param nom guardará un String que será el atributo <b>nombre</b> del objeto instanciado. 
	 */
	public ListaDeLaCompra(String nom) {

		this.nombre = nom;
	}

	/**
	 *Este método devuelve un String que será <b>nombre</b> del objeto.
	 * @return String {@link #nombre}
	 */
	public String getNombreLista() {

		return this.nombre;
	}

	/**
	 * <p>Establece un nuevo <b>nombre</b> para el objeto.</p>
	 * <p>Hay que tener en cuenta, que si se cambia el nombre mediante este método, el archivo .dat creado correspondiente a esta lista no cambiará.</p>
	 * @param nuevoNombre {@link #nombre}
	 */
	public void setNombreLista(String nuevoNombre) {

		this.nombre = nuevoNombre;
	}

	/**
	 * <p>Este método agrega un artículo al atributo {@link #lista} del objeto sobre el que se aplica.</p>
	 *
	 * @param articulo  Este será el objeto de la clase {@link ArticuloAComprar} que se agregará.
	 */
	public void agregarProductoAComprar(ArticuloAComprar articulo) {

		this.lista.add(articulo);
	}

	/**
	 *Este método devuelve un String que será el atributo <b>lista</b> del objeto.
	 * @return ArrayList {@link #lista}
	 */
	public ArrayList<ArticuloAComprar> getArticulos() {

		return this.lista;
	}

	/**
	 * <p>Elimina la primera concurrencia de un {@link ArticuloAComprar} cuya {@link ArticuloAComprar#descripcion descripción} coincida con la de un ArticuloAComprar dentro del atributo {@link #lista} del objeto sobre el que se aplica.</p>
	 * <p>Si la lista no contiene ningún ArticuloAComprar que cumpla la condición, este método no efectúa ningún cambio.<br>
	 * Sin embargo, si la lista posee más de un ArticuloAComprar en su interior que cumpla la condición sólo eliminará el primero, dejando el resto dentro de la lista.</p>
	 * @param desc String que será la descripción que se busca en los artículos de la lista.
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
	 * <p>Este método exporta la lista de la compra y todo su contenido en un archivo <i>nombre.dat</i> donde este nombre hace referencia al atributo {@link #nombre} de la lista.<br>
	 * La ubicación específica del archivo será una carpeta llamada datosListas en el directorio padre. Si dicha carpeta no existe, la crea y a continuación guarda dicho archivo.</p> 
	 * <p>Puede lanzar una excepción de tipo {@link java.io.FileNotFoundException FileNotFoundException} que imprimirá por consola un breve mensaje de error.<br>
	 * También puede lanzar una excepción más génerica de tipo {@link java.io.IOException IOException} si se produce un error en la entrada o salida de los datos. </p> 
	 */
	public void exportaListaDeLaCompra() {

		try {
			
			File listaDataExp = new File(".\\datosListas\\" + this.getNombreLista() + ".dat");
			FileOutputStream fos = new FileOutputStream(listaDataExp);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		
			oos.writeObject(this);
			
			oos.close();
			fos.close();
			
		} catch (FileNotFoundException e) {

			System.out.println("El archivo no se encuentra");
			
		} catch (IOException e) {
			
			System.out.println("Se ha producido un error en la entrada/salida de los datos");
		}
	}
	
	/**
	 * <p>Este método devuelve un objeto {@link ListaDeLaCompra} importado desde un archivo .dat que se encontrará en la carpeta datosListas.<br>
	 * Nótese que si no se ha usado el método {@link ListaDeLaCompra#exportaListaDeLaCompra() exportaListaDeLaCompra()} puede que la carpeta datosListas no esté creada y este método lance una excepción y muestre un error por pantalla.
	 * </p>
	 * <p>Este método puede lanzar varias excepciones que devolverán un mensaje de error por consola. Las excepciones que pueden lanzarse son las siguientes:
	 * <ul>
	 * 	<li>Una excepción {@link java.io.FileNotFoundException FileNotFoundException} que ocurrirá si el archivo no se encuentra o la carpeta datosListas no ha sido creada.</li>
	 *  <li>Una excepción {@link java.io IOException IOExcetion} </li>
	 *  <li>Una excepción {@link java.lang.ClassNotFoundException ClassNotFoundException}</li>
	 * </ul>
	 * 
	 *
	 * @param nombreLista el nombre del fichero (debe añadir la extensión).
	 * @return {@link ListaDeLaCompra} 
	 */
	public static ListaDeLaCompra importaListaDeLaCompra(String nombreLista) {
		
		String ruta = ".\\datosListas\\";
		
		ListaDeLaCompra resultado = new ListaDeLaCompra(nombreLista);
		
		try {
			File listaDataImp = new File(ruta + nombreLista + ".dat");
			FileInputStream fis = new FileInputStream(listaDataImp);
			ObjectInputStream ois = new ObjectInputStream(fis);
			resultado = (ListaDeLaCompra) ois.readObject();
			ois.close();
			fis.close();
			
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
