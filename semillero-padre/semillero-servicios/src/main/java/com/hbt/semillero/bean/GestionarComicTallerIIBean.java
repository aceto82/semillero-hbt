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
 * datos <b>Caso de Uso:<b> Semillero2022
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
	 * Atributo que determina  
	 */
	private final static Short MAXLENGTH = 50;

	/*
	 * Atributo que determina  
	 */
	private final static Short MINLENGTH = 1;

	/*
	 * Atributo que maneja la interacción de la base de datos y los metadatos
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * @throws Exception
	 * @see com.hbt.semillero.poo.interfaces.IGestionarComicLocal#consultarNombrePrecioComic(java.lang.Long)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ConsultarComicTamanioNombreDTO consultarComicTamanioNombre(Short lengthComic) throws Exception {
		LOGGER.info("Inicia ejecucion consultarComicTamanioNombre() ");

		if (lengthComic == null || lengthComic < GestionarComicTallerIIBean.MINLENGTH) {
			throw new Exception("La longitud minima permitida es de " + GestionarComicTallerIIBean.MINLENGTH + " caracteres");
		}
		if (lengthComic > GestionarComicTallerIIBean.MAXLENGTH) {
			throw new Exception("La longitud maxima permitida es de " + GestionarComicTallerIIBean.MAXLENGTH + " caracteres");
		}
		
		List<String> comicsSuperanTamanio = new ArrayList<>();
		List<String> comicsNoSuperanTamanio = new ArrayList<>();

		ConsultarComicTamanioNombreDTO dto = new ConsultarComicTamanioNombreDTO();
		String consultaNombreTamanio = "SELECT new com.hbt.semillero.dtos.ConsultarComicTamanioNombreDTO(nombre)  FROM Comic ";
		try {
			Query queryConsultaNombrePrecioComic = em.createQuery(consultaNombreTamanio);			
			List<ConsultarComicTamanioNombreDTO> dtoList = queryConsultaNombrePrecioComic.getResultList();
			dtoList.forEach((dtoobj) -> {
				if (dtoobj.getNombre().length()>=lengthComic) {
					comicsSuperanTamanio.add(dtoobj.getNombre());
				} else {
					comicsNoSuperanTamanio.add(dtoobj.getNombre());
				}				
			} );
			dto.setComicsNoSuperanTamanio(comicsNoSuperanTamanio);
			dto.setComicsSuperanTamanio(comicsSuperanTamanio);
			dto.setExitoso(true);
			dto.setMensajeEjecucion("Comics procesados exitosamente");
		} catch (Exception e) {
			dto.setExitoso(false);
			dto.setMensajeEjecucion("Se ha presentado un error tecnico " + e.getMessage());
			LOGGER.info("Se ha presentado un error tecnico " + e.getMessage());
		}

		LOGGER.info("Finaliza ejecucion consultarComicTamanioNombre() ");

		return dto;
	}

}