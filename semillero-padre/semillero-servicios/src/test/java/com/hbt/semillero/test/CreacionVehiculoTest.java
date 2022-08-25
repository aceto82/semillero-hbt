package com.hbt.semillero.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.hbt.semillero.enums.TipoVehiculoEnum;
import com.hbt.semillero.poo.Automovil;
import com.hbt.semillero.poo.Vehiculo;

/**
 * 
 * <b>Descripción:<b> Clase que determina las pruebas unitarias para la creación de vehiculos
 * <b>Caso de Uso:<b> Semillero 2022
 * @author Diego Armando Ortiz Bastidas
 * @version
 */
public class CreacionVehiculoTest {
	
	private final static Logger LOGGER = Logger.getLogger(CreacionVehiculoTest.class);
	
	@Before
	public void inicializar() {
		BasicConfigurator.configure();
		LOGGER.info("Se inicia la configuración de Log4j antes de ejecutar las UT");
	}
	
	@Test
	public void whenCreateCarGivenSuccesThenOk() {
		LOGGER.info("Inicia ejecución del test whenCreateCarGivenSuccesThenOk()");
		Automovil mazda = new Automovil();
		mazda.setPrecio(new BigDecimal(1252));
		mazda.setColor("Blanco");
		mazda.setTipo(TipoVehiculoEnum.TERRESTRE);
		mazda.setCapacidad(4);
		
		assertNotNull(mazda);
		assertEquals(TipoVehiculoEnum.TERRESTRE, mazda.getTipo());
		assertEquals(4, mazda.getCapacidad());
		LOGGER.info("Finaliza ejecución del test whenCreateCarGivenSuccesThenOk()");
	}
	/*
	@Test
	public void whenDeterminarTipoVehiculoGiventrueThenExito() {
		LOGGER.info("Inicia ejecución del test whenDeterminarTipoVehiculoGiventrueThenExito()");
		Automovil mazda = new Automovil();
		mazda.setTipo(TipoVehiculoEnum.TERRESTRE);
		
		Exception exception = assertThrows(Exception.class, () ->{
			mazda.determinarTipoVehiculo(mazda.getTipo());
		});
		
		//boolean respuesta = mazda.determinarTipoVehiculo(mazda.getTipo());
		//assertTrue(respuesta);
		
		assertNotNull(exception);
		//assertEquals(null, null);
		LOGGER.info("Finaliza ejecución del test whenDeterminarTipoVehiculoGiventrueThenExito()");
	}*/
	
	@Test
	public void whenCreateCarGivenSuccesThenOk2() {
		LOGGER.info("Inicia ejecución del test whenCreateCarGivenSuccesThenOk2()");
		Automovil mazda = new Automovil();
		mazda.setPrecio(new BigDecimal(1252));
		mazda.setColor("Blanco");
		mazda.setTipo(TipoVehiculoEnum.TERRESTRE);
		mazda.setCapacidad(4);
		
		assertNotNull(mazda);
		assertEquals(TipoVehiculoEnum.TERRESTRE, mazda.getTipo());
		assertEquals(4, mazda.getCapacidad());
		LOGGER.info("Finaliza ejecución del test whenCreateCarGivenSuccesThenOk2()");
	}
	
	@Test
	public void ejemplomock() {
		LOGGER.info("Inicia ejecución del test ejemplomock()");
		Vehiculo mazda = new Vehiculo();
		//mazda.
		LOGGER.info("Finaliza ejecución del test ejemplomock()");
	}

}
