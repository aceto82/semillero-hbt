/**
 * 
 */
package com.hbt.semillero.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.hbt.semillero.entity.Comic;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;
import com.hbt.semillero.util.JsonUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * <b>Descripción:<b> Clase que permite transportar los datos de un Comic
 * <b>Caso de Uso:<b> Semillero2022
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultarComicDTO extends ResultadoDTO implements Serializable{

	/*
	 * Atributo que determina el serial version UID
	 */
	private static final long serialVersionUID = 7452579263223428368L;
	
	
	/*
	 * Atributo que contiene todos los datos de un comic  
	 */
	private Comic comic;

	
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
