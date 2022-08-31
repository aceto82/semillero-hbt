/**
 * Comic.java
 */
package com.hbt.semillero.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b>Descripción:<b> Clase que contiene la información de la tabla comic
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
@Entity
@Table(name = "COMIC")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comic implements Serializable {

	/*
	 * Atributo que determina el serial version UID
	 */
	private static final long serialVersionUID = 216164349106318793L;

	/*
	 * Atributo que determina Identificador unico del comic
	 */
	@Id
	@Column(name = "SCID")
	@SequenceGenerator(allocationSize = 1, name = "COMIC_SCID_GENERATOR", sequenceName = "SEQ_COMIC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMIC_SCID_GENERATOR")
	private Long id;

	/*
	 * Atributo que determina el Nombre o titulo del comic o revista grafica
	 */
	@Column(name = "SCNOMBRE", nullable = false, length = 50)
	private String nombre;

	/*
	 * Atributo que determina la Empresa editorial quien publico el comic
	 */
	@Column(name = "SCEDITORIAL")
	private String editorial;

	/*
	 * Atributo que permite identificar si el comic es de tipo AVENTURAS, BELICO,
	 * HUMORISTICO, DEPORTIVO, FANTASTICO, CIENCIA_FICCION, HISTORICO, HORROR
	 */
	@Column(name = "SCTEMATICA")
	@Enumerated(value = EnumType.STRING)
	private TematicaEnum tematicaEnum;

	/*
	 * Atributo que determina el Conjunto de publicaciones de la que el comic es
	 * parte
	 */
	@Column(name = "SCCOLECCION")
	private String coleccion;

	/*
	 * Atributo que determina la cantidad de las paginas que contiene el comic
	 */
	@Column(name = "SCNUMEROPAGINAS")
	private Short numeropaginas;

	/*
	 * Atributo que determina el Valor en pesos del comic
	 */
	@Column(name = "SCPRECIO")
	private BigDecimal precio;

	/*
	 * Atributo que determina el Autor u autores del comic
	 */
	@Column(name = "SCAUTORES")
	private String autores;

	/*
	 * Atributo que Define si el comic es a color o no, campo de tipo booleano solo
	 * acepta 1 o 0
	 */
	@Column(name = "SCCOLOR")
	private Boolean color;

	/*
	 * Atributo que determina la Fecha de inicio de la venta del comic
	 */
	@Column(name = "SCFECHA_VENTA")
	private LocalDate fechaVenta;

	/*
	 * Atributo que Define si el comic tiene existencia para la venta o no
	 */
	@Column(name = "SCESTADO")
	@Enumerated(value = EnumType.STRING)
	private EstadoEnum estadoEnum;

	/*
	 * Atributo que determina la Cantidad de comics en inventario disponibles para
	 * la venta
	 */
	@Column(name = "SCCANTIDAD")
	private Short cantidad;

	/**
	 * 
	 * Constructor de la clase.
	 */
	/*public Comic() {

	}*/

	/**
	 * Constructor de la clase.
	 * 
	 * @param id            Identificador unico del comic
	 * @param nombre        Nombre o titulo del comic o revista grafica
	 * @param editorial     Empresa editorial quien publico el comic
	 * @param tematica      Permite identificar si el comic es de tipo AVENTURAS,
	 *                      BELICO, HUMORISTICO, DEPORTIVO, FANTASTICO,
	 *                      CIENCIA_FICCION, HISTORICO, HORROR
	 * @param coleccion     Conjunto de publicaciones de la que el comic es parte
	 * @param numeropaginas Cantidad de las paginas que contiene el comic
	 * @param precio        Valor en pesos del comic
	 * @param autores       Autor u autores del comic
	 * @param color         Define si el comic es a color o no, campo de tipo
	 *                      booleano solo acepta 1 o 0
	 * @param fechaVenta    Fecha de inicio de la venta del comic
	 * @param estado        Define si el comic tiene existencia para la venta o no
	 * @param cantidad      Cantidad de comics en inventario disponibles para la
	 *                      venta
	 */
	/*public Comic(Long id, String nombre, String editorial, TematicaEnum tematica, String coleccion, Short numeropaginas,
			BigDecimal precio, String autores, Boolean color, LocalDate fechaVenta, EstadoEnum estado, Short cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.editorial = editorial;
		this.tematicaEnum = tematica;
		this.coleccion = coleccion;
		this.numeropaginas = numeropaginas;
		this.precio = precio;
		this.autores = autores;
		this.color = color;
		this.fechaVenta = fechaVenta;
		this.estadoEnum = estado;
		this.cantidad = cantidad;
	}
*/
	
	/**
	 * Metodo encargado de retornar el valor del atributo serialVersionUID
	 * 
	 * @return El serialversionuid asociado a la clase
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/** 
	 * @see java.lang.Object#toString()
	 */
	/*@Override
	public String toString() {
		return "Comic [id=" + id + ", nombre=" + nombre + ", editorial=" + editorial + ", tematicaEnum=" + tematicaEnum
				+ ", coleccion=" + coleccion + ", numeropaginas=" + numeropaginas + ", precio=" + precio + ", autores="
				+ autores + ", color=" + color + ", fechaVenta=" + fechaVenta + ", estadoEnum=" + estadoEnum
				+ ", cantidad=" + cantidad + "]";
	}*/

	

}
