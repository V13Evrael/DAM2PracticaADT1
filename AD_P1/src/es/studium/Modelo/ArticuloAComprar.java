package es.studium.Modelo;

import java.io.Serializable;

/**
 * 
 * <p>Esta clase representa un art�culo que se puede adquirir en un comercio. Su utilidad principal consiste en ser almacenados en listas de la compra. 
 * </p>
 * <p>Implementa la interfaz {@link java.io.Serializable Serializable} ya que ser� necesario guardarlo en un archivo .dat mediante m�todos de la clase {@link ListaDeLaCompra}, que guardar�n la misma y todo su contenido.
 * </p>
 * @author Jos� Manuel Platero
 *
 */
public class ArticuloAComprar implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * La descripci�n del art�culo. Marca un breve comentario que identifica el art�culo mediante su descripci�n.
	 */
	private String descripcion;
	
	/**
	 * La unidad de medida usada para el art�culo. Es un String que puede marcar muchos factores: <i>p.e. metros (m), kilogramos (kg), unidades, etc...</i> 
	 */
	private String unidad;
	
	/**
	 * La cantidad del objeto que suele ser comprada habitualmente. Es un entero.
	 */
	private Integer cantidad;
	
	
	/**
	 * Constructor de la clase ArticuloAComprar.
	 * Los atributos del objeto ser�n cadena vac�a en el caso de los String y la cantidad se inicia en 0.
	 */
	public ArticuloAComprar() {
		
		descripcion = "";
		unidad = "";
		cantidad = 0;
	}
	
	/**
	 * Otro constructor de la clase ArticuloAComprar.
	 * Los par�metros recibidos se corresponden con los atributos del objeto.
	 * @param desc guardar� un String con la <b>descripci�n</b> del art�culo.
	 * @param uni guardar� un String con la <b>unidad de medida</b> del art�culo (kg, m, unidades, etc).
	 * @param cant guardar� un entero que marca la <b>cantidad habitual</b> que se suele comprar de dicho art�culo.
	 */
	public ArticuloAComprar(String desc, String uni, Integer cant) {
		
		descripcion = desc;
		unidad = uni;
		cantidad = cant;
	}

	/**
	 * Este m�todo devuelve un String que ser� la <b>descripci�n</b> del objeto.
	 * @return String {@link #descripcion}
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece una nueva <b>descripci�n</b> para el objeto.
	 * @param descripcion {@link #descripcion}
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * Este m�todo devuelve un String que ser� la <b>unidad</b> del objeto.
	 * @return String {@link #unidad}
	 */
	public String getUnidad() {
		return unidad;
	}
	
	/**
	 * Establece una nueva <b>unidad</b> para el objeto.
	 * @param unidad {@link #unidad}
	 */
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	/**
	 * Este m�todo devuelve un Integer que ser� la <b>cantidad</b> del objeto.
	 * @return Integer {@link #cantidad}
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * Establece una nueva <b>cantidad</b> para el objeto.
	 * @param cantidad {@link #descripcion}
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}