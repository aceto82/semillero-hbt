package com.hbt.semillero.poo;

import java.math.BigDecimal;

public class Barco extends Vehiculo {

	private int numeroVelas;
	private String nombreCapitan;
	private String puertoLlegada;
	private float calado;

	public Barco() {
		super();
	}

	public Barco(String nombreCapitan, String puertoLlegada, BigDecimal precio) {
		super(precio);
		this.nombreCapitan = nombreCapitan;
		this.puertoLlegada = puertoLlegada;
	}

	public int getNumeroVelas() {
		return numeroVelas;
	}

	public void setNumeroVelas(int numeroVelas) {
		this.numeroVelas = numeroVelas;
	}

	public String getNombreCapitan() {
		return nombreCapitan;
	}

	public void setNombreCapitan(String nombreCapitan) {
		this.nombreCapitan = nombreCapitan;
	}

	public String getPuertoLlegada() {
		return puertoLlegada;
	}

	public void setPuertoLlegada(String puertoLlegada) {
		this.puertoLlegada = puertoLlegada;
	}

	public float getCalado() {
		return calado;
	}

	public void setCalado(float calado) {
		this.calado = calado;
	}

	@Override
	public String toString() {
		return "Barco [numeroVelas=" + numeroVelas + ", nombreCapitan=" + nombreCapitan + ", puertoLlegada="
				+ puertoLlegada + ", calado=" + calado + "] " + super.toString();
	}

}
