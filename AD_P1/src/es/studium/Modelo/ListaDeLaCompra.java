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
 * <p>La clase ListaDeLaCompra representa una lista de la compra concreta que tendr� en su interior
 *  una serie de art�culos (elementos de la clase {@link ArticuloAComprar}) 
 *  especificados dentro de un {@link java.util.ArrayList ArrayList} 
 *  representado a su vez por el atributo {@link ListaDeLaCompra#lista lista}.
 * </p>
 * <p>Implementa la interfaz {@link java.io.Serializable Serializable} ya que ser� necesaria la permanencia de las listas mediante un archivo .dat que guardar� el propio objeto.
 * 
 * @author Jos� Manuel Platero
 */
public class ListaDeLaCompra implements Serializable {

	/** La constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Este atributo representa el nombre de la lista. Este atributo se usar� para dar nombre al fichero .dat creado para mantener un objeto concreto de la lista. */
	private String nombre;
	
	/** Este atributo representa la propia lista mediante un {@link java.io.ArrayList ArrayList} que contendr� todos los art�culos de la clase {@link ArticuloAComprar} que contiene la lista. */
	private ArrayList<ArticuloAComprar> lista = new ArrayList<ArticuloAComprar>();

	/**
	 * Constructor de la clase ListaDeLaCompra.<br>
	 * Instancia un objeto de la clase d�ndole un nombre que ser� la cadena vac�a.
	 * Para poder hacer uso de la persistencia mediante los correspondientes m�todos, ser� necesario indicar un {@link #nombre}.
	 */
	public ListaDeLaCompra() {

		nombre = "";
	}

	/**
	 * Instantiates a new lista de la compra.
	 *
	 * @param nom guardar� un String que ser� el atributo <b>nombre</b> del objeto instanciado. 
	 */
	public ListaDeLaCompra(String nom) {

		this.nombre = nom;
	}

	/**
	 *Este m�todo devuelve un String que ser� <b>nombre</b> del objeto.
	 * @return String {@link #nombre}
	 */
	public String getNombreLista() {

		return this.nombre;
	}

	/**
	 * <p>Establece un nuevo <b>nombre</b> para el objeto.</p>
	 * <p>Hay que tener en cuenta, que si se cambia el nombre mediante este m�todo, el archivo .dat creado correspondiente a esta lista no cambiar�.</p>
	 * @param nuevoNombre {@link #nombre}
	 */
	public void setNombreLista(String nuevoNombre) {

		this.nombre = nuevoNombre;
	}

	/**
	 * <p>Este m�todo agrega un art�culo al atributo {@link #lista} del objeto sobre el que se aplica.</p>
	 *
	 * @param articulo  Este ser� el objeto de la clase {@link ArticuloAComprar} que se agregar�.
	 */
	public void agregarProductoAComprar(ArticuloAComprar articulo) {

		this.lista.add(articulo);
	}

	/**
	 *Este m�todo devuelve un String que ser� el atributo <b>lista</b> del objeto.
	 * @return ArrayList {@link #lista}
	 */
	public ArrayList<ArticuloAComprar> getArticulos() {

		return this.lista;
	}

	/**
	 * <p>Elimina la primera concurrencia de un {@link ArticuloAComprar} cuya {@link ArticuloAComprar#descripcion descripci�n} coincida con la de un ArticuloAComprar dentro del atributo {@link #lista} del objeto sobre el que se aplica.</p>
	 * <p>Si la lista no contiene ning�n ArticuloAComprar que cumpla la condici�n, este m�todo no efect�a ning�n cambio.<br>
	 * Sin embargo, si la lista posee m�s de un ArticuloAComprar en su interior que cumpla la condici�n s�lo eliminar� el primero, dejando el resto dentro de la lista.</p>
	 * @param desc String que ser� la descripci�n que se busca en los art�culos de la lista.
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
	 * <p>Este m�todo exporta la lista de la compra y todo su contenido en un archivo <i>nombre.dat</i> donde este nombre hace referencia al atributo {@link #nombre} de la lista.<br>
	 * La ubicaci�n espec�fica del archivo ser� una carpeta llamada datosListas en el directorio padre. Si dicha carpeta no existe, la crea y a continuaci�n guarda dicho archivo.</p> 
	 * <p>Puede lanzar una excepci�n de tipo {@link java.io.FileNotFoundException FileNotFoundException} que imprimir� por consola un breve mensaje de error.<br>
	 * Tambi�n puede lanzar una excepci�n m�s g�nerica de tipo {@link java.io.IOException IOException} si se produce un error en la entrada o salida de los datos. </p> 
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
	 * <p>Este m�todo devuelve un objeto {@link ListaDeLaCompra} importado desde un archivo .dat que se encontrar� en la carpeta datosListas.<br>
	 * N�tese que si no se ha usado el m�todo {@link ListaDeLaCompra#exportaListaDeLaCompra() exportaListaDeLaCompra()} puede que la carpeta datosListas no est� creada y este m�todo lance una excepci�n y muestre un error por pantalla.
	 * </p>
	 * <p>Este m�todo puede lanzar varias excepciones que devolver�n un mensaje de error por consola. Las excepciones que pueden lanzarse son las siguientes:
	 * <ul>
	 * 	<li>Una excepci�n {@link java.io.FileNotFoundException FileNotFoundException} que ocurrir� si el archivo no se encuentra o la carpeta datosListas no ha sido creada.</li>
	 *  <li>Una excepci�n {@link java.io IOException IOExcetion} </li>
	 *  <li>Una excepci�n {@link java.lang.ClassNotFoundException ClassNotFoundException}</li>
	 * </ul>
	 * 
	 *
	 * @param nombreLista el nombre del fichero (debe a�adir la extensi�n).
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
			
			System.out.println("La clase del objeto le�do no se corresponde con una Lista De La Compra");
		} 
		
		return resultado;
	}
}
