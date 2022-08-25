package com.hbt.semillero.poo;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.hbt.semillero.enums.TipoVehiculoEnum;
import com.hbt.semillero.poo.interfaces.IAccionesVehiculo;


public class Automovil extends Vehiculo implements IAccionesVehiculo {
	
	private final static Logger LOGGER = Logger.getLogger(IAccionesVehiculo.class);

	public Automovil() {

	}

	public Automovil(BigDecimal precio) {
		super(precio);
		super.toString();
	}

	@Override
	public int obtenerVelocidadMaxima() {
		return 330;
	}

	@Override
	public Long obtenerPesoMaximoCarga() {
		return 1020L;
	}

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
