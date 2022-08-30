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

/**
 * <b>Descripción:<b> Clase que contiene la información de la tabla comic
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
@Entity
@Table(name = "COMIC")
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
	public Comic() {

	}

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
	public Comic(Long id, String nombre, String editorial, TematicaEnum tematica, String coleccion, Short numeropaginas,
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

	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * 
	 * @return El id asociado a la clase
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * 
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * 
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * 
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo editorial
	 * 
	 * @return El editorial asociado a la clase
	 */
	public String getEditorial() {
		return editorial;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo editorial
	 * 
	 * @param editorial El nuevo editorial a modificar.
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo tematica
	 * 
	 * @return El tematica asociado a la clase
	 */
	public TematicaEnum getTematica() {
		return tematicaEnum;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo tematica
	 * 
	 * @param tematica El nuevo tematica a modificar.
	 */
	public void setTematica(TematicaEnum tematica) {
		this.tematicaEnum = tematica;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo coleccion
	 * 
	 * @return El coleccion asociado a la clase
	 */
	public String getColeccion() {
		return coleccion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo coleccion
	 * 
	 * @param coleccion El nuevo coleccion a modificar.
	 */
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo numeropaginas
	 * 
	 * @return El numeropaginas asociado a la clase
	 */
	public Short getNumeropaginas() {
		return numeropaginas;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo numeropaginas
	 * 
	 * @param numeropaginas El nuevo numeropaginas a modificar.
	 */
	public void setNumeropaginas(Short numeropaginas) {
		this.numeropaginas = numeropaginas;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo precio
	 * 
	 * @return El precio asociado a la clase
	 */
	public BigDecimal getPrecio() {
		return precio;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo precio
	 * 
	 * @param precio El nuevo precio a modificar.
	 */
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo autores
	 * 
	 * @return El autores asociado a la clase
	 */
	public String getAutores() {
		return autores;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo autores
	 * 
	 * @param autores El nuevo autores a modificar.
	 */
	public void setAutores(String autores) {
		this.autores = autores;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo color
	 * 
	 * @return El color asociado a la clase
	 */
	public Boolean getColor() {
		return color;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo color
	 * 
	 * @param color El nuevo color a modificar.
	 */
	public void setColor(Boolean color) {
		this.color = color;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo fechaVenta
	 * 
	 * @return El fechaVenta asociado a la clase
	 */
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo fechaVenta
	 * 
	 * @param fechaVenta El nuevo fechaVenta a modificar.
	 */
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * 
	 * @return El estado asociado a la clase
	 */
	public EstadoEnum getEstado() {
		return estadoEnum;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * 
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstado(EstadoEnum estado) {
		this.estadoEnum = estado;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo cantidad
	 * 
	 * @return El cantidad asociado a la clase
	 */
	public Short getCantidad() {
		return cantidad;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo cantidad
	 * 
	 * @param cantidad El nuevo cantidad a modificar.
	 */
	public void setCantidad(Short cantidad) {
		this.cantidad = cantidad;
	}

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
	@Override
	public String toString() {
		return "Comic [id=" + id + ", nombre=" + nombre + ", editorial=" + editorial + ", tematica=" + tematicaEnum
				+ ", coleccion=" + coleccion + ", numeropaginas=" + numeropaginas + ", precio=" + precio + ", autores="
				+ autores + ", color=" + color + ", fechaVenta=" + fechaVenta + ", estado=" + estadoEnum + ", cantidad="
				+ cantidad + "]";
	}

}
