package com.hbt.semillero.poo.interfaces;

public interface IAccionesVehiculo {

	public int obtenerVelocidadMaxima();

	public Long obtenerPesoMaximoCarga();

	public default void acelerar() {
		System.out.println("El vehiculo ha iniciado acelerar");
	}

}
