package com.hbt.semillero.poo;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.hbt.semillero.enums.TipoVehiculoEnum;

public class CreacionVehiculoApp {

	private final static Logger LOGGER = Logger.getLogger(CreacionVehiculoApp.class);

	public static void main(String[] args) {
		LOGGER.info("Inicia ejecución del main()");
		Vehiculo mazda = new Vehiculo();
		// BigDecimal precio = new BigDecimal(105);
		// mazda.setPrecio(precio);
		// System.out.println("Valor del vehiculo mazda: "+precio);

		mazda.setPrecio(new BigDecimal(104));
		System.out.println("Valor del vehiculo mazda: " + mazda.getPrecio());

		Vehiculo kia = new Vehiculo((short) 2022, TipoVehiculoEnum.TERRESTRE, 1000, "Azul", 6, new BigDecimal(1122));
		System.out.println("Valores del kia: " + kia.toString());

		if (kia.getTipo().equals(TipoVehiculoEnum.TERRESTRE)) {
			System.out.println("El vehiculo es terrestre");
		} else {
			System.out.println("El vehiculo es: " + kia.getTipo());
		}

		Barco barco = new Barco();
		barco.setPuertoLlegada("Cartagena");
		barco.setColor("Amarillo");
		System.out.println("Datos del barco: " + barco.toString());

		Barco otroBarco = new Barco("Semillero", "San Andres", new BigDecimal(1102));
		System.out.println("Datos del otroBarco: " + otroBarco.toString());

		// Polimorfismo
		Vehiculo vehiculo1 = new Vehiculo();
		vehiculo1.arrancarEnMedio();

		Avion avion = new Avion();
		avion.arrancarEnMedio();

		Vehiculo avion2 = new Avion();
		avion2.arrancarEnMedio();

		// clases abstractas
		Bicicleta bicicleta = new Bicicleta();
		bicicleta.acelerar();
		System.out.println("Peso maximo es de: " + bicicleta.obtenerPesoMaximoCarga());
		System.out.println("Velocidad maxima es de: " + bicicleta.obtenerVelocidadMaxima());

		Automovil automovil = new Automovil(new BigDecimal(98645));
		automovil.setTipo(TipoVehiculoEnum.ACUATICO);
		automovil.acelerar();
		System.out.println(automovil.toString());
		System.out.println("Peso maximo es de: " + automovil.obtenerPesoMaximoCarga());
		System.out.println("Velocidad maxima es de: " + automovil.obtenerVelocidadMaxima());

		try {
			automovil.determinarTipoVehiculo(automovil.getTipo());
		} catch (Exception e) {
			LOGGER.error("Se ha presentado un error de " + e.getMessage());
			System.out.println("SE HA PRESENTADO UN ERROR: " + e.getMessage());
		}
		LOGGER.info("Finaliza ejecución del main()");
	}

}
