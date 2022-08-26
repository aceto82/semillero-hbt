/**
 * TematicaEnum.java
 */
package com.hbt.semillero.enums;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> Semillero2022
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
public enum TematicaEnum {
	
	AVENTURAS("enum.tematica.aventuras"),
	BELICO("enum.tematica.belico"), 
	HUMORISTICO("enum.tematica.humoristico"), 
	DEPORTIVO("enum.tematica.deportivo"), 
	FANTASTICO("enum.tematica.fantastico"), 
	CIENCIA_FICCION("enum.tematica.cienciaficcion"), 
	HISTORICO("enum.tematica.historico"), 
	HORROR("enum.tematica.horror"),
	;
	
	private String etiqueta;
	
	/**
	 * 
	 * Constructor de la clase.
	 * @param etiqueta
	 */
	TematicaEnum(String etiqueta){
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
