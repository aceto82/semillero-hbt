/**
 * EstadoEnum.java
 */
package com.hbt.semillero.enums;

/**
 * <b>Descripción:<b> Enumerador que determina los diferentes estados del comic
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
public enum EstadoEnum {
	ACTIVO("enum.estado.activo"), INACTIVO("enum.estado.inactivo"),;

	private String etiqueta;

	/**
	 * 
	 * Constructor de la clase.
	 * 
	 * @param etiqueta
	 */
	EstadoEnum(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo etiqueta
	 * 
	 * @return El etiqueta asociado a la clase
	 */
	public String getEtiqueta() {
		return etiqueta;
	}

}
