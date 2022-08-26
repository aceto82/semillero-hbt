package com.hbt.semillero.poo;

/**
 * 
 * <b>Descripción:<b> Clase que determina las caracteristicas de un avion,
 * hereda los atributos de la clase vehiculo 
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
public class Avion extends Vehiculo {

	/**
	 * @see com.hbt.semillero.poo.Vehiculo#arrancarEnMedio()
	 */
	@Override
	public void arrancarEnMedio() {
		System.out.println("El vehiculo esta avanzando via aerea");
	}

}
