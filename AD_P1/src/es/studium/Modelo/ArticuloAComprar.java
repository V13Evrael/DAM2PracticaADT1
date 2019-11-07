package es.studium.Modelo;

import java.io.Serializable;

/**
 * 
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
	 * @return String {@link ArticuloAComprar#descripcion}
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece una nueva <b>descripci�n</b> para el objeto.
	 * @param descripcion {@link ArticuloAComprar#descripcion}
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * Este m�todo devuelve un String que ser� la <b>unidad</b> del objeto.
	 * @return {@link ArticuloAComprar#unidad}
	 */
	public String getUnidad() {
		return unidad;
	}
	

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	/**
	 * Este m�todo devuelve un Integer que ser� la <b>cantidad</b> del objeto.
	 * @return {@link ArticuloAComprar#cantidad}
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
