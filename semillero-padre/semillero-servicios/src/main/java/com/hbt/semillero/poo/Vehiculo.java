package com.hbt.semillero.poo;

import java.math.BigDecimal;

import com.hbt.semillero.enums.TipoVehiculoEnum;

/**
 * 
 * <b>Descripción:<b> Clase que contiene la data de un vehiculo, actua como una
 * super clase 
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
public class Vehiculo {

	/*
	 * Atributo que determina el modelo del vehiculo
	 */
	private Short modelo;

	/*
	 * Atributo que determina el tipo del vehiculo
	 */
	private TipoVehiculoEnum tipo;

	/*
	 * Atributo que determina el peso del vehiculo
	 */
	private double peso;

	/*
	 * Atributo que determina el color del vehiculo
	 */
	private String color;

	/*
	 * Atributo que determina la capacidad del vehiculo
	 */
	private int capacidad;

	/*
	 * Atributo que determina el precio del vehiculo
	 */
	private BigDecimal precio;

	/**
	 * Constructor de la clase.
	 */
	public Vehiculo() {
	}

	/**
	 * 
	 * Constructor de la clase.
	 * 
	 * @param precio determina el precio del vehiculo
	 */
	public Vehiculo(BigDecimal precio) {
		this.precio = precio;
	}

	/**
	 * 
	 * Constructor de la clase.
	 * 
	 * @param modelo    determina el modelo del vehiculo
	 * @param tipo      determina el tipo del vehiculo
	 * @param peso      determina el peso del vehiculo
	 * @param color     determina el color del vehiculo
	 * @param capacidad determina la capacidad del vehiculo
	 * @param precio    determina el precio del vehiculo
	 */
	public Vehiculo(Short modelo, TipoVehiculoEnum tipo, double peso, String color, int capacidad, BigDecimal precio) {
		this.modelo = modelo;
		this.tipo = tipo;
		this.peso = peso;
		this.color = color;
		this.capacidad = capacidad;
		this.precio = precio;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo modelo
	 * 
	 * @return El modelo asociado a la clase
	 */
	public Short getModelo() {
		return modelo;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo modelo
	 * 
	 * @param modelo El nuevo modelo a modificar.
	 */
	public void setModelo(Short modelo) {
		this.modelo = modelo;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo tipo
	 * 
	 * @return El tipo asociado a la clase
	 */
	public TipoVehiculoEnum getTipo() {
		return tipo;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo tipo
	 * 
	 * @param tipo El nuevo tipo a modificar.
	 */
	public void setTipo(TipoVehiculoEnum tipo) {
		this.tipo = tipo;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo peso
	 * 
	 * @return El peso asociado a la clase
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo peso
	 * 
	 * @param peso El nuevo peso a modificar.
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo color
	 * 
	 * @return El color asociado a la clase
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo color
	 * 
	 * @param color El nuevo color a modificar.
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo capacidad
	 * 
	 * @return El capacidad asociado a la clase
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo capacidad
	 * 
	 * @param capacidad El nuevo capacidad a modificar.
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
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
		// Asigna precio del vehiculo
		this.precio = precio;
	}

	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehiculo [modelo=" + modelo + ", tipo=" + tipo + ", peso=" + peso + ", color=" + color + ", capacidad="
				+ capacidad + ", precio=" + precio + "]";
	}

	/**
	 * 
	 * Metodo encargado de arrancar el vehiculo <b>Caso de Uso</b> Semillero
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 *
	 */
	public void arrancarEnMedio() {
		System.out.println("El vehiculo está avanzando");
	}

}
