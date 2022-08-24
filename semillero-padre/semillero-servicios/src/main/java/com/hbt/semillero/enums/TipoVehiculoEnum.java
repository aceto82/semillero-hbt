package com.hbt.semillero.enums;

public enum TipoVehiculoEnum {

	TERRESTRE("TERRESTRE", 1), ACUATICO("ACUATICO", 2), AEREO("AEREO", 3), ESPACIAL("ESPACIAL", 4),
	;

	private String tipo;

	private int identificador;

	TipoVehiculoEnum(String tipo, int identificador) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}	

	public int getIdentificador() {
		return identificador;
	}	
}
