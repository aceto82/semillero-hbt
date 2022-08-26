package com.hbt.semillero.enums;

/**
 * 
 * <b>Descripción:<b> Enumerador que determina una relación de tipos de vehiculos
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
public enum TipoVehiculoEnum {

	TERRESTRE("TERRESTRE", 1), ACUATICO("ACUATICO", 2), AEREO("AEREO", 3), ESPACIAL("ESPACIAL", 4),;

	/*
	 * Atributo que determina el tipo de vehiculo en String
	 */
	private String tipo;

	/*
	 * Atributo que determina el identificador del tipo de vehiculo
	 */
	private int identificador;

	/**
	 * 
	 * Constructor del enumerador
	 * 
	 * @param tipo
	 * @param identificador
	 */
	TipoVehiculoEnum(String tipo, int identificador) {
		this.tipo = tipo;
	}

	/**
	 * Metodo encargado de devolver el tipo de vehiculo en String <b>Caso de Uso</b>
	 * Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Metodo encargado de devolver el identificador asociado al tipo de vehiculo
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @return identificador
	 */
	public int getIdentificador() {
		return identificador;
	}
}
