package com.hbt.semillero.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import com.hbt.semillero.util.JsonUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b>Descripción:<b> Clase que permite transportar el nombre y precio
 * de un Comic
 * 
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaNombrePrecioComicDTO extends ResultadoDTO implements Serializable {

	/*
	 * Atributo que determina el serial version UID
	 */
	private static final long serialVersionUID = 5090815548125489135L;

	/**
	 * Atributo que determina el nombre de un comic
	 */
	private String nombre;

	/*
	 * Atributo que determina el precio de un comic
	 */
	private BigDecimal precio;

	/**
	 * Método encargado de convertir los datos recibidos en JSON al tipo ComicDTO.
	 * <b>Caso de Uso:</b> Semillero2022
	 * 
	 * @param arg Cadena que representa el objeto complejo JSON.
	 * @return Instancia con los datos recibidos.
	 */
	public static ComicDTO valueOf(String arg) {
		return JsonUtils.valueOf(arg, ComicDTO.class);
	}

	/**
	 * Método encargado de convertir los datos recibidos en ComicDTO al JSON
	 * esperado
	 * 
	 * @param dto DTO
	 * 
	 * @return Json
	 */
	@Override
	public String toString() {
		return JsonUtils.toStringJson(this);
	}
}
