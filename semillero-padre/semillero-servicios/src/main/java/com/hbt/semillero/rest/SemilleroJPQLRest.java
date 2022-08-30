/**
 * SemilleroJPQLRest.java
 */
package com.hbt.semillero.rest;

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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.hbt.semillero.entity.Comic;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
@Path("/SemilleroJPQLRest")
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SemilleroJPQLRest {

	/*
	 * Atributo que determina el logger, la cual muestra en consola los mensajes
	 */
	private final static Logger LOG = Logger.getLogger(SemilleroJPQLRest.class);

	/*
	 * Atributo que maneja la interacción de la base de datos y los metadatos
	 */
	@PersistenceContext
	private EntityManager em;

	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public String generarOperacionComic() {
		LOG.info("Se ejecuta generarOperacionComic()");
		Comic comic = null;

		try {
			// Obtencion del registro de la tabla
			// SELECT * FROM COMIC WHERE ID=15;
			comic = em.find(Comic.class, 1L);
			LOG.info("DATA COMIC " + comic.toString());

			String consulta = "SELECT c FROM Comic c WHERE c.id=1";
			Query queryUnComic = em.createQuery(consulta);
			comic = (Comic) queryUnComic.getSingleResult();

			String consultaDos = "SELECT cm FROM Comic cm " 
					+ "WHERE cm.id=1 "
					+ "AND cm.tematicaEnum = 'AVENTURAS' " 
					+ "AND cm.color=1 "
					+ "AND cm.estadoEnum='ACTIVO'";
			Query queryUnComicDos = em.createQuery(consultaDos);
			comic = (Comic) queryUnComicDos.getSingleResult();
			
			
			String consultaTres = "SELECT cm FROM Comic cm " 
					+ "WHERE cm.id = :idComic "
					+ "AND cm.tematicaEnum = :tematicaEnum  " 
					+ "AND cm.color = :color "
					+ "AND cm.estadoEnum = :estado ";
			Query queryUnComicTres = em.createQuery(consultaTres);
			queryUnComicTres.setParameter("idComic", comic.getId());
			queryUnComicTres.setParameter("tematicaEnum", TematicaEnum.AVENTURAS);
			queryUnComicTres.setParameter("color", Boolean.FALSE);
			queryUnComicTres.setParameter("estado", EstadoEnum.ACTIVO);
			comic = (Comic) queryUnComicTres.getSingleResult();
			

		} catch (NonUniqueResultException nure) {
			LOG.error("SE HA PRESENTADO DUPLICIDAD CON EL ID PRESENTADO " + nure.getMessage());
		} catch (NoResultException nre) {
			LOG.error("NO SE ENCONTRO REGISTRO CON EL ID PRESENTADO " + nre.getMessage());
		} catch (Exception e) {
			LOG.error("SE HA PRESENTADO UN ERROR TECNICO " + e.getMessage());
		}
		LOG.info("finaliza generarOperacionComic()");
		return "";
	}

}
