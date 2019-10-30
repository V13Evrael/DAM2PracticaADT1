package es.studium.Modelo;

import java.io.Serializable;

public class ArticuloAComprar implements Serializable {

	private String descripcion;
	private String unidad;
	private Integer cantidad;
	
	public ArticuloAComprar() {
		
		descripcion = "";
		unidad = "";
		cantidad = 0;
	}
	
	public ArticuloAComprar(String desc, String uni, Integer cant) {
		
		descripcion = desc;
		unidad = uni;
		cantidad = cant;
		
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
