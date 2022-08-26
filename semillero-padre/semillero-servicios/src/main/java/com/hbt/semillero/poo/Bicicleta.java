package com.hbt.semillero.poo;

import com.hbt.semillero.poo.abstracts.AccionesVehiculoAbstract;

/**
 * 
 * <b>Descripción:<b> Clase que determina las caracteristicas de una bicicleta,
 * hereda los atributos de la clase abstracta AccionesVehiculoAbstract 
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
public class Bicicleta extends AccionesVehiculoAbstract {

	/**
	 * @see com.hbt.semillero.poo.abstracts.AccionesVehiculoAbstract#obtenerVelocidadMaxima()
	 */
	@Override
	public int obtenerVelocidadMaxima() {
		return 10;
	}

	/**
	 * @see com.hbt.semillero.poo.abstracts.AccionesVehiculoAbstract#obtenerPesoMaximoCarga()
	 */
	@Override
	public Long obtenerPesoMaximoCarga() {
		return 90L;
	}

}
