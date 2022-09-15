package com.hbt.semillero.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ConsultarComicDTO;
import com.hbt.semillero.dtos.ObtenerComicsDTO;
import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dtos.ResultadoDTO;
import com.hbt.semillero.entity.Comic;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;
import com.hbt.semillero.poo.interfaces.IGestionarComicLocal;
import com.hbt.semillero.poo.interfaces.IGestionarCompraComicLocal;

/**
 * <b>Descripción:<b> Clase que determina la logica de la compra de un comic
 * 
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarCompraComicBean implements IGestionarCompraComicLocal {

	/*
	 * Atributo que determina el logger, la cual muestra en consola los mensajes
	 */
	private final static Logger LOGGER = Logger.getLogger(GestionarCompraComicBean.class);

	/*
	 * Atributo que maneja la interacción de la base de datos y los metadatos
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * @see com.hbt.semillero.poo.interfaces.IGestionarComicLocal#EliminarComic(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public ResultadoDTO ComprarComic(Long idComic, Short cantidad) throws Exception {
		LOGGER.info("Inicia ejecucion ComprarComic() ");

		if (idComic == null || idComic == 0) {
			throw new Exception("El campo idComic es requerido");
		}
		if (cantidad == null || cantidad <= 0) {
			throw new Exception("La cantidad debe ser mayor a cero (0)");
		}

		ResultadoDTO resultadoDTO = new ResultadoDTO();

		try {
			Comic comic = em.find(Comic.class, idComic);

			if (comic.getEstadoEnum().equals(EstadoEnum.INACTIVO)) {
				throw new Exception("El comic seleccionado no cuenta con stock en bodega");
			}

			if (comic.getCantidad() >= cantidad) {
				comic.setCantidad((short) (comic.getCantidad() - cantidad));
				comic.setFechaVenta(LocalDate.now());
				if (comic.getCantidad() == 0) {
					comic.setEstadoEnum(EstadoEnum.INACTIVO);
				}
				em.merge(comic);
			} else {
				throw new Exception(
						"La cantidad existente del comic es: " + comic.getCantidad() + ", y supera la ingresada");
			}

			resultadoDTO.setExitoso(true);
			resultadoDTO.setMensajeEjecucion("La compra del comic " + comic.getNombre() + " fue exitosa");

		} catch (IllegalArgumentException nure) {
			LOGGER.info("Se ha presentado IllegalArgumentException: " + nure.getMessage());
			throw new Exception("No existe registro para el comic con id " + idComic);
		} catch (NullPointerException e) {
			LOGGER.info("Se ha presentado un error tecnico " + e.getMessage());
			throw new Exception("No existe registro para el comic con id " + idComic);
		}

		LOGGER.info("Finaliza ejecucion ComprarComic() ");
		return resultadoDTO;
	}

}