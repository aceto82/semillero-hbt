package com.hbt.semillero.poo;

import com.hbt.semillero.poo.abstracts.AccionesVehiculoAbstract;

public class Bicicleta extends AccionesVehiculoAbstract {

	@Override
	public int obtenerVelocidadMaxima() {		
		return 10;
	}

	@Override
	public Long obtenerPesoMaximoCarga() {		
		return 90L;
	}

}
