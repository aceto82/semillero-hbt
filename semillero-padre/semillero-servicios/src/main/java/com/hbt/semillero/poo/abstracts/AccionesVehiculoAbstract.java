package com.hbt.semillero.poo.abstracts;

/**
 * <b>Descripción:<b> Clase abstrata que determina diferentes acciones que puede
 * realizar un vehiculo, son opcionales  
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
public abstract class AccionesVehiculoAbstract {

	/**
	 * Metodo encargado de obtener la velocidad maxima del vehiculo 
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @return
	 */
	public abstract int obtenerVelocidadMaxima();

	/**
	 * Metodo encargado de obtener el peso maximo que puede soportar el vehiculo
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @return
	 */
	public abstract Long obtenerPesoMaximoCarga();

	public void acelerar() {
		System.out.println("El vehiculo ha iniciado acelerar");
	}

}
