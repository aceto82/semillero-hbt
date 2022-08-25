package com.hbt.semillero.poo;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.hbt.semillero.enums.TipoVehiculoEnum;
import com.hbt.semillero.poo.interfaces.IAccionesVehiculo;

/**
 * 
 * <b>Descripción:<b> Clase que determina las caracteristicas de un automovil,
 * hereda de la clase vehiculo e implementa la interface IAccionesVehiculo
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
public class Automovil extends Vehiculo implements IAccionesVehiculo {

	/*
	 * Atributo que determina el logger, la cual muestra en consola los mensajes
	 */
	private final static Logger LOGGER = Logger.getLogger(IAccionesVehiculo.class);

	/**
	 * Constructor de la clase.
	 */
	public Automovil() {

	}

	/**
	 * Constructor de la clase.
	 * 
	 * @param precio determina el precio del automovil
	 */
	public Automovil(BigDecimal precio) {
		// Usa el constructor de la clase padre para recibir el parametro precio
		super(precio);
		// Imprime en consola los datos de la clase padre (vehiculo)
		super.toString();
	}

	/**
	 * @see com.hbt.semillero.poo.interfaces.IAccionesVehiculo#obtenerVelocidadMaxima()
	 */
	@Override
	public int obtenerVelocidadMaxima() {
		return 330;
	}

	/**
	 * @see com.hbt.semillero.poo.interfaces.IAccionesVehiculo#obtenerPesoMaximoCarga()
	 */
	@Override
	public Long obtenerPesoMaximoCarga() {
		return 1020L;
	}

	/**
	 * @see com.hbt.semillero.poo.interfaces.IAccionesVehiculo#determinarTipoVehiculo(com.hbt.semillero.enums.TipoVehiculoEnum)
	 */
	@Override
	public boolean determinarTipoVehiculo(TipoVehiculoEnum tipoVehiculoEnum) throws Exception {
		System.out.println(tipoVehiculoEnum.toString());
		if (TipoVehiculoEnum.TERRESTRE.equals(tipoVehiculoEnum)) {
			System.out.println("El vehiculo si es del tipo asignado (" + TipoVehiculoEnum.TERRESTRE + ")");
			return true;
		} else {
			LOGGER.error("Se ha presentado un error de XYZ");
			throw new Exception(
					"El tipo de vehiculo asignado es erroneo, debe ser " + TipoVehiculoEnum.TERRESTRE.getTipo());
		}

	}

}
