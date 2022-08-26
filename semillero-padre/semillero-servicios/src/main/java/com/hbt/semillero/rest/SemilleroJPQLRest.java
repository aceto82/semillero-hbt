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
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.hbt.semillero.entity.Comic;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version
 */
@Path("/SemilleroJPQLRest")
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SemilleroJPQLRest {

	/*
	 * Atributo que determina el logger, la cual muestra en consola los mensajes
	 */
	private final static Logger LOG = Logger.getLogger(SemilleroJPQLRest.class);

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

		} catch (Exception e) {
			LOG.error("SE HA PRESENTADO UN ERROR TECNICO " + e.getMessage());
		}
		LOG.info("finaliza generarOperacionComic()");
		return "";
	}

}
