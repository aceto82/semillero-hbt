/**
 * SemilleroJPQLRest.java
 */
package com.hbt.semillero.rest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.hbt.semillero.dtos.ComicDTO;
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
			// Obtencion de un registro de la tabla comic haciendo uso del metodo find de la
			// clase EntityManager
			// SELECT * FROM COMIC WHERE ID = 15;
			comic = em.find(Comic.class, 1L);
			LOG.info("DATA COMIC" + comic.toString());

			// Consults en JPQL para obtener un comic con el id 15 pero quemado o
			// hardcodeado haciendo uso del metodo getSingleResult
			String consulta = "SELECT c FROM Comic c WHERE c.id = 1 ";
			Query queryUnComic = em.createQuery(consulta);
			comic = (Comic) queryUnComic.getSingleResult();

			// Consulta en JPQL para obtener un comic con el id 6 tematicaenum y color
			// haciendo uso del metodo getSingleResult y setParameter
			String consultaDos = "SELECT cm FROM Comic cm " + " WHERE cm.id = 2 "
					+ " AND cm.tematicaEnum = 'FANTASTICO'" + " AND cm.color = 0 " + " AND cm.estadoEnum = 'ACTIVO' ";
			Query queryUnComicDos = em.createQuery(consultaDos);
			comic = (Comic) queryUnComicDos.getSingleResult();

			String consultaTres = "SELECT cm FROM Comic cm " + " WHERE cm.id = :idComic "
					+ " AND cm.tematicaEnum = :tematicaEnum " + " AND cm.color = :color "
					+ " AND cm.estadoEnum = :estado ";
			Query queryUnComicTres = em.createQuery(consultaTres);
			queryUnComicTres.setParameter("idComic", comic.getId());
			queryUnComicTres.setParameter("tematicaEnum", TematicaEnum.FANTASTICO);
			queryUnComicTres.setParameter("color", Boolean.FALSE);
			queryUnComicTres.setParameter("estado", EstadoEnum.ACTIVO);
			comic = (Comic) queryUnComicTres.getSingleResult();

			// Query que genera una exception de tipo NoResultException debido a que la
			// consulta no retorna nada
			// String consultaCuarto = "SELECT cm FROM Comic cm WHERE cm.id = :idComic "
			// + " AND cm.tematicaEnum = :tematicaEnum AND cm.color = :colorComic ";
			// Query queryUnComicCuatro = em.createQuery(consultaCuarto);
			// queryUnComicCuatro.setParameter("idComic", comic.getId());
			// queryUnComicCuatro.setParameter("tematicaEnum", TematicaEnum.HUMORISTICO);
			// queryUnComicCuatro.setParameter("colorComic", Boolean.TRUE);
			// comic = (Comic) queryUnComicCuatro.getSingleResult();

			// Traer los comics filtrando por tematica y color como lista
			String consultaListaComics = "SELECT cm FROM Comic cm WHERE cm.tematicaEnum = :tematicaEnum"
					+ " AND cm.color = :colorComic ";
			Query queryListComics = em.createQuery(consultaListaComics);
			queryListComics.setParameter("tematicaEnum", TematicaEnum.FANTASTICO);
			queryListComics.setParameter("colorComic", Boolean.FALSE);
			List<Comic> listComics = queryListComics.getResultList();

			for (Comic comicList : listComics) {
				LOG.info("DATA COMIC" + comicList.toString());
			}

			// Query que genera una exception de tipo NonUniqueResultException debido a que
			// la consulta retorna mas de 1 registro
			/*
			 * String consultaListaNonUnique =
			 * "SELECT cm FROM Comic cm WHERE cm.tematicaEnum = :tematicaEnum" +
			 * " AND cm.color = :colorComic "; Query queryNonUnique =
			 * em.createQuery(consultaListaNonUnique);
			 * queryNonUnique.setParameter("tematicaEnum", TematicaEnum.FANTASTICO);
			 * queryNonUnique.setParameter("colorComic", Boolean.FALSE); comic = (Comic)
			 * queryNonUnique.getSingleResult();
			 */
			// List<Comic> listComics = queryListComics.getSingleResult();

			// Se crea comic Thor
			Comic thor = Comic.builder().nombre("Spiderman").editorial("Marvel").coleccion("Marvel")
					.numeropaginas((short) 50).precio(new BigDecimal(1500)).estadoEnum(EstadoEnum.ACTIVO)
					.cantidad((short) 10).build();
			em.persist(thor); // operacion insert

			thor = em.find(Comic.class, 5L);// operacion select

			thor.setFechaVenta(LocalDate.now());
			thor.setColor(Boolean.TRUE);

			em.merge(thor); // operacion update

			em.remove(comic); // operacion delete

			String actualizarComic = "UPDATE Comic c SET c.estadoEnum = :estadoEnum " + " WHERE c.id=:idComic";
			Query queryActualizarComic = em.createQuery(actualizarComic);
			queryActualizarComic.setParameter("estadoEnum", EstadoEnum.INACTIVO);
			queryActualizarComic.setParameter("idComic", 4L);
			int recordsUpdate = queryActualizarComic.executeUpdate();
			LOG.error("Se actualizaron " + recordsUpdate);

			String eliminarComics = "DELETE FROM Comic " + " WHERE c.id IN ( :idComics ) ";
			Query queryEliminarComic = em.createQuery(eliminarComics);
			queryEliminarComic.setParameter("idComics", Arrays.asList(1L, 3L));
			int records = queryEliminarComic.executeUpdate();
			LOG.error("Se eliminaron " + records);

			// consulta algunos campos de la entidad y retorn una lista de objetos
			String consultaCampos = "SELECT c.nombre, c.estadoEnum, c.precio FROM Comic c " + " WHERE c.id = :idComic ";
			Query queryCampos = em.createQuery(consultaCampos);
			queryCampos.setParameter("idComic", 5L);

			Object[] data = (Object[]) queryCampos.getSingleResult();
			String nombre = (String) data[0];
			EstadoEnum estadoEnum = (EstadoEnum) data[1];
			BigDecimal precio = (BigDecimal) data[2];
			
			
			// consulta algunos campos de la entidad usando el constructor de comicDTO y retorn una lista de objetos
			String consultaCamposConstructor = "SELECT new com.hbt.semillero.dtos.ComicDTO(c.nombre, c.estadoEnum, c.precio) "
					+ " FROM Comic "
					+ " WHERE c.id = :idComic ";
			Query queryCamposConstructor = em.createQuery(consultaCamposConstructor);
			queryCamposConstructor.setParameter("idComic", 4L);
			//ComicDTO 

		} catch (NonUniqueResultException nure) {
			LOG.error("Se ha presentado ducplicidad de datos con el id 15" + nure.getMessage());
		} catch (NoResultException nre) {
			LOG.error("No se encontro registro para el id 15" + nre.getMessage());
		} catch (Exception e) {
			LOG.error("Se ha presentado un error tecnico" + e.getMessage());
		}

		LOG.info("Finaliza generarOperacionComic()");
		return "";
	}

}
