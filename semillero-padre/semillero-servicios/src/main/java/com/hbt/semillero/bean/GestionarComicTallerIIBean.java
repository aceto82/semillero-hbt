package com.hbt.semillero.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.hbt.semillero.dtos.ConsultarComicTamanioNombreDTO;
import com.hbt.semillero.poo.interfaces.IGestionarComicTallerIILocal;

/**
 * <b>Descripción:<b> Clase que determina la logica de verificar y procesar los
 * datos para el taller 2
 * 
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarComicTallerIIBean implements IGestionarComicTallerIILocal {

	/*
	 * Atributo que determina el logger, la cual muestra en consola los mensajes
	 */
	private final static Logger LOGGER = Logger.getLogger(GestionarComicTallerIIBean.class);

	/*
	 * Atributo que determina la longitud maxima del nombre del comic que se puede
	 * recibir como parametro
	 */
	private final static Short MAXLENGTH = 50;

	/*
	 * Atributo que determina la longitud minima del nombre del comic que se puede
	 * recibir como parametro
	 */
	private final static Short MINLENGTH = 1;

	/*
	 * Atributo que maneja la interacción de la base de datos y los metadatos
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * @see com.hbt.semillero.poo.interfaces.IGestionarComicTallerIILocal#consultarComicTamanioNombre(java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ConsultarComicTamanioNombreDTO consultarComicTamanioNombre(String lengthComic) throws Exception {
		LOGGER.info("Inicia ejecucion consultarComicTamanioNombre(String) ");
		// Este metodo verifica que el parametro sea numerico
		if (!GestionarComicTallerIIBean.isNumeric(lengthComic)) {
			throw new Exception("La longitud no es valida, debe ser un numero entre "
					+ GestionarComicTallerIIBean.MINLENGTH + " y " + GestionarComicTallerIIBean.MAXLENGTH);
		}
		LOGGER.info("Finaliza ejecucion consultarComicTamanioNombre(String) ");
		return this.consultarComicTamanioNombre(Short.parseShort(lengthComic));
	}

	/**
	 * Metodo encargado de consultar el nombre de todos los comics, separandolos en
	 * listas los que superan o no la longitud dada con el numero de caracteres de
	 * cada nombre del comic
	 * 
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param lengthComic
	 * @return ConsultarComicTamanioNombreDTO dto de la consulta
	 * @throws Exception
	 */
	private ConsultarComicTamanioNombreDTO consultarComicTamanioNombre(Short lengthComic) throws Exception {
		LOGGER.info("Inicia ejecucion consultarComicTamanioNombre(Short) ");

		verificaRangoLengthComic(lengthComic);

		List<String> comicsSuperanTamanio = new ArrayList<>();
		List<String> comicsNoSuperanTamanio = new ArrayList<>();

		ConsultarComicTamanioNombreDTO dto = new ConsultarComicTamanioNombreDTO();
		String consultaNombreTamanio = "SELECT new com.hbt.semillero.dtos.ConsultarComicTamanioNombreDTO(nombre) FROM Comic ";
		try {
			Query queryConsultaNombreTamanio = em.createQuery(consultaNombreTamanio);
			List<ConsultarComicTamanioNombreDTO> dtoList = queryConsultaNombreTamanio.getResultList();
			dtoList.forEach((dtoobj) -> {
				if (dtoobj.getNombre().length() >= lengthComic.intValue()) {
					comicsSuperanTamanio.add(dtoobj.getNombre());
				} else {
					comicsNoSuperanTamanio.add(dtoobj.getNombre());
				}
			});
			dto.setComicsNoSuperanTamanio(comicsNoSuperanTamanio);
			dto.setComicsSuperanTamanio(comicsSuperanTamanio);
			dto.setExitoso(true);
			dto.setMensajeEjecucion("Comics procesados exitosamente");
		} catch (Exception e) {
			dto.setExitoso(false);
			dto.setMensajeEjecucion("Se ha presentado un error tecnico " + e.getMessage());
			LOGGER.info("Se ha presentado un error tecnico " + e.getMessage());
		}
		LOGGER.info("Finaliza ejecucion consultarComicTamanioNombre(Short) ");
		return dto;
	}

	/**
	 * Metodo encargado de verifica los valores maximos y minimos permitidos en el
	 * parametro lengthComic
	 * 
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param lengthComic
	 * @throws Exception
	 */
	private void verificaRangoLengthComic(Short lengthComic) throws Exception {
		if (lengthComic < GestionarComicTallerIIBean.MINLENGTH) {
			String palabra = " caracteres";
			if (GestionarComicTallerIIBean.MINLENGTH == 1) {
				palabra = " caracter";
			}
			throw new Exception("La longitud minima permitida es de " + GestionarComicTallerIIBean.MINLENGTH + palabra);
		}
		if (lengthComic > GestionarComicTallerIIBean.MAXLENGTH) {
			throw new Exception(
					"La longitud maxima permitida es de " + GestionarComicTallerIIBean.MAXLENGTH + " caracteres");
		}
	}

	/**
	 * Metodo encargado de verificar si la cadena es un numero tipo short
	 * 
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param cadena
	 * @return boolean
	 */
	private static boolean isNumeric(String cadena) {
		try {
			Short.parseShort(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

}