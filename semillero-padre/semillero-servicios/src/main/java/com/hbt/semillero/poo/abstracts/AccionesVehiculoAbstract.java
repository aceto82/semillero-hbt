package com.hbt.semillero.poo.abstracts;

public abstract class AccionesVehiculoAbstract {

	public abstract int obtenerVelocidadMaxima();

	public abstract Long obtenerPesoMaximoCarga();

	public void acelerar() {
		System.out.println("El vehiculo ha iniciado acelerar");
	}

}
