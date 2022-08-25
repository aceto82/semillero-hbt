package com.hbt.semillero.poo;

import java.math.BigDecimal;

/**
 * <b>Descripción:<b> Clase que determina las caracteristicas de un barco,
 * hereda los atributos de la clase Vehiculo <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
public class Barco extends Vehiculo {

	/*
	 * Atributo que determina la cantidad de velas del barco
	 */
	private int numeroVelas;

	/*
	 * Atributo que determina el nombre del capitan del barco
	 */
	private String nombreCapitan;

	/*
	 * Atributo que determina el puerto al que llegara el barco
	 */
	private String puertoLlegada;

	/*
	 * Atributo que determina la profundidad a la que se sumerge parte del barco
	 */
	private float calado;

	/**
	 * Constructor de la clase.
	 */
	public Barco() {
		super();
	}

	/**
	 * Constructor de la clase.
	 * 
	 * @param nombreCapitan determina el nombre del capitan del barco
	 * @param puertoLlegada determina el puerto al que llegara el barco
	 * @param precio        determina el precio del barco
	 */
	public Barco(String nombreCapitan, String puertoLlegada, BigDecimal precio) {
		// Usa el constructor de la clase padre para almacenar el precio del barco
		super(precio);
		this.nombreCapitan = nombreCapitan;
		this.puertoLlegada = puertoLlegada;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo numeroVelas
	 * 
	 * @return El numeroVelas asociado a la clase
	 */
	public int getNumeroVelas() {
		return numeroVelas;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo numeroVelas
	 * 
	 * @param numeroVelas El nuevo numeroVelas a modificar.
	 */
	public void setNumeroVelas(int numeroVelas) {
		this.numeroVelas = numeroVelas;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombreCapitan
	 * 
	 * @return El nombreCapitan asociado a la clase
	 */
	public String getNombreCapitan() {
		return nombreCapitan;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombreCapitan
	 * 
	 * @param nombreCapitan El nuevo nombreCapitan a modificar.
	 */
	public void setNombreCapitan(String nombreCapitan) {
		this.nombreCapitan = nombreCapitan;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo puertoLlegada
	 * 
	 * @return El puertoLlegada asociado a la clase
	 */
	public String getPuertoLlegada() {
		return puertoLlegada;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo puertoLlegada
	 * 
	 * @param puertoLlegada El nuevo puertoLlegada a modificar.
	 */
	public void setPuertoLlegada(String puertoLlegada) {
		this.puertoLlegada = puertoLlegada;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo calado
	 * 
	 * @return El calado asociado a la clase
	 */
	public float getCalado() {
		return calado;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo calado
	 * 
	 * @param calado El nuevo calado a modificar.
	 */
	public void setCalado(float calado) {
		this.calado = calado;
	}

	@Override
	public String toString() {
		return "Barco [numeroVelas=" + numeroVelas + ", nombreCapitan=" + nombreCapitan + ", puertoLlegada="
				+ puertoLlegada + ", calado=" + calado + "] " + super.toString();
	}

}
