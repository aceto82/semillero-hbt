/**
 * EstadoEnum.java
 */
package com.hbt.semillero.enums;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version
 */
public enum EstadoEnum {
	ACTIVO("enum.estado.activo"), 
	INACTIVO("enum.estado.inactivo"),
	;

	private String etiqueta;

	/**
	 * 
	 * Constructor de la clase.
	 * @param etiqueta
	 */
	EstadoEnum(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo etiqueta
	 * @return El etiqueta asociado a la clase
	 */
	public String getEtiqueta() {
		return etiqueta;
	}
	
	
}
