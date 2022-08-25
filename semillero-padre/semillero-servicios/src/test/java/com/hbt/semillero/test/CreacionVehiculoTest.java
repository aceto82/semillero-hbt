package com.hbt.semillero.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.hbt.semillero.enums.TipoVehiculoEnum;
import com.hbt.semillero.poo.Automovil;

/**
 * 
 * <b>Descripción:<b> Clase que determina las pruebas unitarias para la creacion
 * de vehiculos <b>Caso de Uso:<b> Semillero 2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
public class CreacionVehiculoTest {

	/*
	 * Atributo que determina el logger, la cual muestra en consola los mensajes
	 */
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

	@Test
	public void whenDeterminarTipoVehiculoGiventrueThenExito() throws Exception {
		LOGGER.info("Inicia ejecución del test whenDeterminarTipoVehiculoGiventrueThenExito()");
		Automovil mazda = new Automovil();
		mazda.setTipo(TipoVehiculoEnum.TERRESTRE);

		boolean respuesta = mazda.determinarTipoVehiculo(mazda.getTipo());
		assertTrue(respuesta);

		LOGGER.info("Finaliza ejecución del test whenDeterminarTipoVehiculoGiventrueThenExito()");
	}

	@Test
	public void whenDeterminarTipoVehiculoGiventrueThenFallido() {
		LOGGER.info("Inicia ejecución del test whenDeterminarTipoVehiculoGiventrueThenFallido()");
		Automovil mazda = new Automovil();
		mazda.setTipo(TipoVehiculoEnum.AEREO);

		Exception exception = assertThrows(Exception.class, () -> {
			mazda.determinarTipoVehiculo(mazda.getTipo());
		});

		assertNotNull(exception);
		assertEquals("El tipo de vehiculo asignado es erroneo, debe ser " + TipoVehiculoEnum.TERRESTRE.getTipo(),
				exception.getMessage());
		LOGGER.info("Finaliza ejecución del test whenDeterminarTipoVehiculoGiventrueThenFallido()");
	}
	
	@Test
	public void ejemploMock() {
		LOGGER.info("Inicia ejecución del test ejemploMock()");
		
		Automovil kiamock = mock(Automovil.class);
		
		when(kiamock.acelerar()).thenReturn("El automovil ha acelerado a QWERT");
		assertEquals(kiamock.acelerar(), "El automovil ha acelerado a QWERT");
		
		LOGGER.info("Finaliza ejecución del test ejemploMock()");
	}
	
	@Test
	@Disabled
	public void pruebaFallida() {
		LOGGER.info("Inicia ejecución del test whenDeterminarTipoVehiculoGiventrueThenFallido()");
		Automovil mazda = new Automovil();
		mazda.setTipo(TipoVehiculoEnum.AEREO);

		Exception exception = assertThrows(Exception.class, () -> {
			mazda.determinarTipoVehiculo(mazda.getTipo());
		});

		assertNull(exception);
		assertEquals("El tipo de vehiculo asignado es erroneo, debe ser " + TipoVehiculoEnum.TERRESTRE.getTipo(),
				exception.getMessage());
		LOGGER.info("Finaliza ejecución del test whenDeterminarTipoVehiculoGiventrueThenFallido()");
	}

}
