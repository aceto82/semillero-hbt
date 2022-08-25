package com.hbt.semillero.poo.interfaces;

import com.hbt.semillero.enums.TipoVehiculoEnum;

/**
 * <b>Descripción:<b> Interface que determina las acciones que puede realizar un vehiculo para implementar obligatoriamente
 * <b>Caso de Uso:<b> Semillero2022
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
public interface IAccionesVehiculo {

	/**
	 * Metodo encargado de obtener la velocidad maxima del vehiculo
	 * <b>Caso de Uso</b> Semillero2022
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @return
	 */
	public int obtenerVelocidadMaxima();

	/**
	 * Metodo encargado de obtener el peso maximo que puede soportar un vehiculo
	 * <b>Caso de Uso</b> Semillero2022
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @return
	 */
	public Long obtenerPesoMaximoCarga();

	/**
	 * Metodo encargado de determinar si es correcto el tipo de vehiculo
	 * <b>Caso de Uso</b> Semillero2022
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param tipoVehiculoEnum tipo de vehiculo a verificar
	 * @return
	 * @throws Exception
	 */
	public boolean determinarTipoVehiculo(TipoVehiculoEnum tipoVehiculoEnum) throws Exception;

	/**
	 * Metodo encargado de iniciar el movimiento del vehiculo
	 * <b>Caso de Uso</b> Semillero2022
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @return
	 */
	public default String acelerar() {
		System.out.println("El vehiculo ha iniciado acelerar");
		return "El vehiculo ha iniciado acelerar";
	}

}
