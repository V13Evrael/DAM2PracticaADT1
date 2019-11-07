package es.studium.Modelo;

import java.io.Serializable;

/**
 * 
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
	 * @return String {@link ArticuloAComprar#descripcion}
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece una nueva <b>descripción</b> para el objeto.
	 * @param descripcion {@link ArticuloAComprar#descripcion}
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * Este método devuelve un String que será la <b>unidad</b> del objeto.
	 * @return {@link ArticuloAComprar#unidad}
	 */
	public String getUnidad() {
		return unidad;
	}
	

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	/**
	 * Este método devuelve un Integer que será la <b>cantidad</b> del objeto.
	 * @return {@link ArticuloAComprar#cantidad}
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
