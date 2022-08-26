/**
 * CreacionComicTest.java
 */
package com.hbt.semillero.test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hbt.semillero.entity.Comic;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;

/**
 * <b>Descripción:<b> Clase que determina las pruebas unitarias en la creación
 * de comics 
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
public class CreacionComicTest {

	/*
	 * Atributo que determina el logger, la cual muestra en consola los mensajes
	 */
	private final static Logger LOG = Logger.getLogger(CreacionComicTest.class);

	/*
	 * Atributo que determina el listado de los comics a realizar las pruebas
	 */
	private List<Comic> listaComics = new ArrayList<>();

	/**
	 * Metodo encargado de inicializar el listado de los comics para la prueba unitaria
	 * <b>Caso de Uso</b> Semillero2022
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 */
	@BeforeEach
	public void inicializar() {
		LOG.info("Se inicia creando los 10 comic para las pruebas unitarias");

		Comic yugioh = new Comic(1L, "Yu-Gi-Oh!", "Shueisha", TematicaEnum.AVENTURAS, "Manga Shonen", (short) 38,
				new BigDecimal(0), "Kazuki Takahashi", false, null, EstadoEnum.INACTIVO, (short) 0);

		Comic crest = new Comic(2L, "Crest of the Royal Family", "Akita Shoten", TematicaEnum.BELICO, "Manga Shojo",
				(short) 66, new BigDecimal(0), "Chieko Hosokawa", false, null, EstadoEnum.INACTIVO, (short) 0);

		Comic futari = new Comic(3L, "Futari Ecchi", "Hakusensha", TematicaEnum.HUMORISTICO, "Manga Seinen", (short) 84,
				new BigDecimal(0), "Katsu Aki", false, null, EstadoEnum.INACTIVO, (short) 0);

		Comic onepiece = new Comic(4L, "One Piece", "Shueisha", TematicaEnum.AVENTURAS, "Manga Shonen", (short) 103,
				new BigDecimal(25), "Eiichiro Oda", false, LocalDate.of(2022, 8, 31), EstadoEnum.ACTIVO, (short) 180);

		Comic naruto = new Comic(5L, "Naruto", "Shueisha", TematicaEnum.AVENTURAS, "Manga Shonen", (short) 72,
				new BigDecimal(0), "Masashi Kishimoto", false, null, EstadoEnum.INACTIVO, (short) 0);

		Comic hajime = new Comic(6L, "Hajime no Ippo", "Kodansha", TematicaEnum.DEPORTIVO, "Manga Shonen", (short) 132,
				new BigDecimal(20), "George Morikawa", false, LocalDate.of(2022, 9, 15), EstadoEnum.ACTIVO, (short) 54);

		Comic supercampeones = new Comic(7L, "Captain Tsubasa", "Shueisha", TematicaEnum.DEPORTIVO,
				"Manga Shonen/Seinen", (short) 96, new BigDecimal(15), "Yoichi Takahashi", false,
				LocalDate.of(2022, 9, 25), EstadoEnum.ACTIVO, (short) 27);

		Comic grayman = new Comic(8L, "D.Gray-man", "Shueisha", TematicaEnum.FANTASTICO, "Manga Shonen", (short) 27,
				new BigDecimal(18), "Katsura Hoshino", false, LocalDate.now(), EstadoEnum.ACTIVO, (short) 47);

		Comic gantz = new Comic(9L, "Gantz", "Shueisha", TematicaEnum.CIENCIA_FICCION, "Manga Seinen", (short) 37,
				new BigDecimal(22), "Hiroya Oku", false, LocalDate.of(2022, 9, 5), EstadoEnum.ACTIVO, (short) 27);

		Comic sukeban = new Comic(10L, "Sukeban Deka", "Hakusensha", TematicaEnum.AVENTURAS, "Manga Shonen", (short) 27,
				new BigDecimal(25), "Katsura Hoshino", false, LocalDate.now(), EstadoEnum.ACTIVO, (short) 180);

		listaComics.add(yugioh);
		listaComics.add(crest);
		listaComics.add(futari);
		listaComics.add(onepiece);
		listaComics.add(naruto);
		listaComics.add(hajime);
		listaComics.add(supercampeones);
		listaComics.add(grayman);
		listaComics.add(gantz);
		listaComics.add(sukeban);
	}

	private List<Comic> verificaComicActivos() {
		List<Comic> activos = new ArrayList<>();
		for (Comic comic : this.listaComics) {
			if (comic.getEstado().equals(EstadoEnum.ACTIVO)) {
				activos.add(comic);
			}
		}
		return activos;
	}

	private List<Comic> verificaComicInactivos() {
		List<Comic> inactivos = new ArrayList<>();
		for (Comic comic : this.listaComics) {
			if (comic.getEstado().equals(EstadoEnum.INACTIVO)) {
				inactivos.add(comic);
			}
		}
		return inactivos;
	}

	@Test
	public void whenVerifyComicStateThenActive() {
		LOG.info("Inicia ejecución del test whenVerifyComicStateThenActive()");

		List<Comic> activos = this.verificaComicActivos();

		for (Comic comic : activos) {
			System.out.println(comic.toString());
			assertEquals(EstadoEnum.ACTIVO, comic.getEstado());
		}

		LOG.info("finaliza ejecución del test whenVerifyComicStateThenActive()");
	}

	private String resumenComics() throws Exception {
		List<Comic> activos = this.verificaComicActivos();
		List<Comic> inactivos = this.verificaComicInactivos();
		String mensajeError = "Se ha detectado que de " + this.listaComics.size() + " comics se encontraron que "
				+ activos.size() + " se encuentran activos y " + inactivos.size()
				+ " inactivos. Los comics inactivos son: ";
		for (Comic comic : inactivos) {
			mensajeError += comic.getNombre() + ", ";
		}
		System.out.println(mensajeError);
		throw new Exception(mensajeError);
	}

	@Test
	public void whenGetSumaryThenException() {
		LOG.info("Inicia ejecución del test whenGetSumaryThenException()");
		Exception exception = assertThrows(Exception.class, () -> {
			this.resumenComics();
		});
		
		assertTrue(exception.getMessage(), exception.getMessage().contains("Se ha detectado que de"));

//		assertTrue(exception.getMessage().equals(
//				"Se ha detectado que de 10 comics se encontraron que 6 se encuentran activos y 4 inactivos. Los comics inactivos son: Yu-Gi-Oh!, Crest of the Royal Family, Futari Ecchi, Naruto, "));

		LOG.info("Finaliza ejecución del test whenGetSumaryThenException()");
	}

}
