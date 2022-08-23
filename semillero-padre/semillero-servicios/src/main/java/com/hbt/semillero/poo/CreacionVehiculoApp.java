package com.hbt.semillero.poo;

import java.math.BigDecimal;

public class CreacionVehiculoApp {

	public static void main(String[] args) {
		Vehiculo mazda = new Vehiculo();
		// BigDecimal precio = new BigDecimal(105);
		// mazda.setPrecio(precio);
		// System.out.println("Valor del vehiculo mazda: "+precio);

		mazda.setPrecio(new BigDecimal(104));
		System.out.println("Valor del vehiculo mazda: " + mazda.getPrecio());

		Vehiculo kia = new Vehiculo((short) 2022, "Terrestre", 1000, "Azul", 6, new BigDecimal(1122));
		System.out.println("Valores del kia: " + kia.toString());

		Barco barco = new Barco();
		barco.setPuertoLlegada("Cartagena");
		barco.setColor("Amarillo");
		System.out.println("Datos del barco: " + barco.toString());

		Barco otroBarco = new Barco("Semillero", "San Andres", new BigDecimal(1102));
		System.out.println("Datos del otroBarco: " + otroBarco.toString());

	}

}
