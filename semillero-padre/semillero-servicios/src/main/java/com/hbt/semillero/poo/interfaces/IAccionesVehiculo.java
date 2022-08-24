package com.hbt.semillero.poo.interfaces;

import com.hbt.semillero.enums.TipoVehiculoEnum;

public interface IAccionesVehiculo {

	public int obtenerVelocidadMaxima();

	public Long obtenerPesoMaximoCarga();

	public boolean determinarTipoVehiculo(TipoVehiculoEnum tipoVehiculoEnum) throws Exception;

	public default void acelerar() {
		System.out.println("El vehiculo ha iniciado acelerar");
	}

}
