package com.hbt.semillero.poo;

import java.math.BigDecimal;

import com.hbt.semillero.poo.interfaces.IAccionesVehiculo;

public class Automovil extends Vehiculo implements IAccionesVehiculo {

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

}
