package com.hbt.semillero.bean;

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

import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.poo.interfaces.IGestionarComicLocal;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarComicBean implements IGestionarComicLocal {

	/*
	 * Atributo que determina el logger, la cual muestra en consola los mensajes
	 */
	private final static Logger LOGGER = Logger.getLogger(GestionarComicBean.class);

	/*
	 * Atributo que maneja la interacción de la base de datos y los metadatos
	 */
	@PersistenceContext
	private EntityManager em;

	@Override
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic) {
		LOGGER.info("Inicia ejecucion del metodo consultarNombrePrecioComic");
		ConsultaNombrePrecioComicDTO dto = new ConsultaNombrePrecioComicDTO();
		String consultaNombrePrecioComic = "SELECT new com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO(nombre, precio) "
				+ "FROM Comic " + "WHERE id = :idComic ";
		try {
			Query queryconsultaNombrePrecioComic = em.createQuery(consultaNombrePrecioComic);
			queryconsultaNombrePrecioComic.setParameter("idComic", idComic);
			dto = (ConsultaNombrePrecioComicDTO) queryconsultaNombrePrecioComic.getSingleResult();
			dto.setExitoso(true);
			dto.setMensajeEjecucion("Se ha ejecutado exitosamente");
		} catch (NonUniqueResultException nure) {
			LOGGER.error("Se ha presentado NonUniqueResultException: " + nure.getMessage());
			dto.setExitoso(false);
			dto.setMensajeEjecucion("Existen registros duplicados para el id: " + idComic);
		} catch (NoResultException nre) {
			LOGGER.error("Se ha presentado NoResultException: " + nre.getMessage());
			dto.setExitoso(false);
			dto.setMensajeEjecucion("No existen registros para el comic con el id: " + idComic);
		} catch (Exception e) {
			LOGGER.error("Se ha presentado un error tecnico" + e.getMessage());
			dto.setExitoso(false);
			dto.setMensajeEjecucion("Se ha presentado un error tecnico: " + e.getMessage());
		}

		/*
		 * try { Query queryconsultaNombrePrecioComic =
		 * em.createQuery(consultaNombrePrecioComic);
		 * queryconsultaNombrePrecioComic.setParameter("idComic", idComic);
		 * List<ConsultaNombrePrecioComicDTO> dtoList =
		 * queryconsultaNombrePrecioComic.getResultList();
		 * 
		 * if(dtoList.isEmpty()) { dto.setExitoso(false);
		 * dto.setMensajeEjecucion("No existen registros para el comic con el id: " +
		 * idComic); return dto; } dto.setNombre(dtoList.get(0).getNombre());
		 * dto.setPrecio(dtoList.get(0).getPrecio()); dto.setExitoso(true);
		 * dto.setMensajeEjecucion("Se ha ejecutado exitosamente"); } catch (Exception
		 * e) { LOGGER.error("Se ha presentado un error tecnico" + e.getMessage());
		 * dto.setExitoso(false);
		 * dto.setMensajeEjecucion("Se ha presentado un error tecnico: " +
		 * e.getMessage()); }
		 */
		LOGGER.info("Finaliza ejecucion del metodo consultarNombrePrecioComic");
		return dto;
	}
}
