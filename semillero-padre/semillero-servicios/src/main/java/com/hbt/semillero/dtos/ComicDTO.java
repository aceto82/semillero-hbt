/**
 * 
 */
package com.hbt.semillero.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;

public class ComicDTO {

	/*
	 * Atributo que determina Identificador unico del comic
	 */
	private Long id;

	/*
	 * Atributo que determina el Nombre o titulo del comic o revista grafica
	 */
	private String nombre;

	/*
	 * Atributo que determina la Empresa editorial quien publico el comic
	 */
	private String editorial;

	/*
	 * Atributo que permite identificar si el comic es de tipo AVENTURAS, BELICO,
	 * HUMORISTICO, DEPORTIVO, FANTASTICO, CIENCIA_FICCION, HISTORICO, HORROR
	 */
	private TematicaEnum tematica;

	/*
	 * Atributo que determina el Conjunto de publicaciones de la que el comic es
	 * parte
	 */
	private String coleccion;

	/*
	 * Atributo que determina la cantidad de las paginas que contiene el comic
	 */

	private Short numeropaginas;

	/*
	 * Atributo que determina el Valor en pesos del comic
	 */
	private BigDecimal precio;

	/*
	 * Atributo que determina el Autor u autores del comic
	 */
	private String autores;

	/*
	 * Atributo que Define si el comic es a color o no, campo de tipo booleano solo
	 * acepta 1 o 0
	 */

	private Boolean color;

	/*
	 * Atributo que determina la Fecha de inicio de la venta del comic
	 */
	private LocalDate fechaVenta;

	/*
	 * Atributo que Define si el comic tiene existencia para la venta o no
	 */
	private EstadoEnum estado;

	/*
	 * Atributo que determina la Cantidad de comics en inventario disponibles para
	 * la venta
	 */
	private Short cantidad;

}
