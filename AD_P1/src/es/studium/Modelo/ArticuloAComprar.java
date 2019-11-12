package es.studium.Modelo;

import java.io.Serializable;

/**
 * 
 * <p>Esta clase representa un artículo que se puede adquirir en un comercio. Su utilidad principal consiste en ser almacenados en listas de la compra. 
 * </p>
 * <p>Implementa la interfaz {@link java.io.Serializable Serializable} ya que será necesario guardarlo en un archivo .dat mediante métodos de la clase {@link ListaDeLaCompra}, que guardarán la misma y todo su contenido.
 * </p>
 * @author José Manuel Platero
 *
 */
public class ArticuloAComprar implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * La descripción del artículo. Marca un breve comentario que identifica el artículo mediante su descripción.
	 */
	private String descripcion;
	
	/**
	 * La unidad de medida usada para el artículo. Es un String que puede marcar muchos factores: <i>p.e. metros (m), kilogramos (kg), unidades, etc...</i> 
	 */
	private String unidad;
	
	/**
	 * La cantidad del objeto que suele ser comprada habitualmente. Es un entero.
	 */
	private Integer cantidad;
	
	
	/**
	 * Constructor de la clase ArticuloAComprar.
	 * Los atributos del objeto serán cadena vacía en el caso de los String y la cantidad se inicia en 0.
	 */
	public ArticuloAComprar() {
		
		descripcion = "";
		unidad = "";
		cantidad = 0;
	}
	
	/**
	 * Otro constructor de la clase ArticuloAComprar.
	 * Los parámetros recibidos se corresponden con los atributos del objeto.
	 * @param desc guardará un String con la <b>descripción</b> del artículo.
	 * @param uni guardará un String con la <b>unidad de medida</b> del artículo (kg, m, unidades, etc).
	 * @param cant guardará un entero que marca la <b>cantidad habitual</b> que se suele comprar de dicho artículo.
	 */
	public ArticuloAComprar(String desc, String uni, Integer cant) {
		
		descripcion = desc;
		unidad = uni;
		cantidad = cant;
	}

	/**
	 * Este método devuelve un String que será la <b>descripción</b> del objeto.
	 * @return String {@link #descripcion}
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece una nueva <b>descripción</b> para el objeto.
	 * @param descripcion {@link #descripcion}
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * Este método devuelve un String que será la <b>unidad</b> del objeto.
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
	 * Este método devuelve un Integer que será la <b>cantidad</b> del objeto.
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