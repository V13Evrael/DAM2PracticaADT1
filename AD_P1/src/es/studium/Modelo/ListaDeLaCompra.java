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

public class ListaDeLaCompra implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private ArrayList<ArticuloAComprar> lista = new ArrayList<ArticuloAComprar>();

	public ListaDeLaCompra() {

		nombre = "";
	}

	public ListaDeLaCompra(String nombre) {

		this.nombre = nombre;
	}

	public String getNombreLista() {

		return this.nombre;
	}

	public void setNombreLista(String nuevoNombre) {

		this.nombre = nuevoNombre;
	}

	public void agregarProductoAComprar(ArticuloAComprar articulo) {

		this.lista.add(articulo);
	}

	public ArrayList<ArticuloAComprar> getArticulos() {

		return this.lista;
	}

	public void eliminarArticulo(String desc) {

		for (ArticuloAComprar art : this.getArticulos()) {
			if (art.getDescripcion().equals(desc)) {
				this.getArticulos().remove(art);
				break;
			}
		}
	}

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
