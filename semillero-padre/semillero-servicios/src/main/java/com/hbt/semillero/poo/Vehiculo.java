package com.hbt.semillero.poo;

import java.math.BigDecimal;

public class Vehiculo {

	private Short modelo;
	private String tipo;
	private double peso;
	private String color;
	private int capacidad;
	private BigDecimal precio;

	public Vehiculo() {
	}

	public Vehiculo(BigDecimal precio) {
		this.precio = precio;
	}

	public Vehiculo(Short modelo, String tipo, double peso, String color, int capacidad, BigDecimal precio) {
		this.modelo = modelo;
		this.tipo = tipo;
		this.peso = peso;
		this.color = color;
		this.capacidad = capacidad;
		this.precio = precio;
	}

	public Short getModelo() {
		return modelo;
	}

	public void setModelo(Short modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Vehiculo [modelo=" + modelo + ", tipo=" + tipo + ", peso=" + peso + ", color=" + color + ", capacidad="
				+ capacidad + ", precio=" + precio + "]";
	}

}
