package com.hbt.semillero.bean;

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

/**
 * <b>Descripción:<b> Clase que determina la logica de verificar y procesar los
 * datos
 * 
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
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

	/**
	 * @see com.hbt.semillero.poo.interfaces.IGestionarComicLocal#consultarNombrePrecioComic(java.lang.Long)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic) {
		LOGGER.info("Inicia ejecucion consultarNombrePrecioComic() ");

		ConsultaNombrePrecioComicDTO dto = new ConsultaNombrePrecioComicDTO();
		String consultaNombrePrecioComic = "SELECT new com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO(nombre, precio) "
				+ " FROM Comic " + " WHERE id = :idComic ";
		try {
			Query queryConsultaNombrePrecioComic = em.createQuery(consultaNombrePrecioComic);
			queryConsultaNombrePrecioComic.setParameter("idComic", idComic);
			dto = (ConsultaNombrePrecioComicDTO) queryConsultaNombrePrecioComic.getSingleResult();
			dto.setExitoso(true);
			dto.setMensajeEjecucion("Se ha ejecutado exitosamente");
		} catch (NonUniqueResultException nure) {
			LOGGER.info("Se ha presentado NonUniqueResultException: " + nure.getMessage());
			dto.setExitoso(false);
			dto.setMensajeEjecucion("Existen registros duplicados para el id " + idComic);
		} catch (NoResultException nre) {
			LOGGER.info("Se ha presentado NoResultException: " + nre.getMessage());
			dto.setExitoso(false);
			dto.setMensajeEjecucion("No existen registros para el comic con id " + idComic);
		} catch (Exception e) {
			dto.setExitoso(false);
			dto.setMensajeEjecucion("Se ha presentado un error tecnico " + e.getMessage());
			LOGGER.info("Se ha presentado un error tecnico " + e.getMessage());
		}
//		try {
//			Query queryConsultaNombrePrecioComic = em.createQuery(consultaNombrePrecioComic);
//			queryConsultaNombrePrecioComic.setParameter("idComic", idComic);
//			List<ConsultaNombrePrecioComicDTO> dtoList = queryConsultaNombrePrecioComic.getResultList();
//			
//			if(dtoList.isEmpty()) {
//				dto.setExitoso(false);
//				dto.setMensajeEjecucion("No existen registros para el comic con id " + idComic);
//				return dto;
//			}
//			dto.setNombre(dtoList.get(0).getNombre());
//			dto.setPrecio(dtoList.get(0).getPrecio());
//			dto.setExitoso(true);
//			dto.setMensajeEjecucion("Se ha ejecutado exitosamente");	
//		} catch (Exception e) {
//			dto.setExitoso(false);
//			dto.setMensajeEjecucion("Se ha presentado un error tecnico " + e.getMessage());
//			LOGGER.info("Se ha presentado un error tecnico " + e.getMessage());
//		}

		LOGGER.info("Finaliza ejecucion consultarNombrePrecioComic() ");

		return dto;
	}

	/**
	 * @see com.hbt.semillero.poo.interfaces.IGestionarComicLocal#crearComic(com.hbt.semillero.dtos.ComicDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO crearComic(ComicDTO comicDTO) throws Exception {
		LOGGER.info("Inicia ejecucion crearComic() ");
		if (comicDTO.getNombre() == null) {
			throw new Exception("El campo nombre es requerido");
		}

		verificaEnum(TematicaEnum.values(), comicDTO.getTematicaEnum(), "tematicaEnum");

		verificaEnum(EstadoEnum.values(), comicDTO.getEstadoEnum(), "estadoEnum");

		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		this.actualizarComicDTOToComic(comicDTO, comic);
		// this.convertirComicDTOToComic(comicDTO);
		em.persist(comic);

		ResultadoDTO resultadoDTO = new ResultadoDTO();
		resultadoDTO.setExitoso(true);
		resultadoDTO.setMensajeEjecucion("El comic ha sido creado exitosamente");

		LOGGER.info("Finaliza ejecucion crearComic() ");
		return resultadoDTO;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ConsultarComicDTO consultarComic(Long idComic) {
		LOGGER.info("Inicia ejecucion consultarComic() ");

		ConsultarComicDTO dto = new ConsultarComicDTO();
		String consultaComic = "SELECT c " + " FROM Comic c " + " WHERE id = :idComic ";
		try {
			Query queryConsultaComic = em.createQuery(consultaComic);
			queryConsultaComic.setParameter("idComic", idComic);
			Comic comic = (Comic) queryConsultaComic.getSingleResult();
			dto.setComic(comic);
			dto.setExitoso(true);
			dto.setMensajeEjecucion("Se ha ejecutado exitosamente");
		} catch (NonUniqueResultException nure) {
			LOGGER.info("Se ha presentado NonUniqueResultException: " + nure.getMessage());
			dto.setExitoso(false);
			dto.setMensajeEjecucion("Existen registros duplicados para el id " + idComic);
		} catch (NoResultException nre) {
			LOGGER.info("Se ha presentado NoResultException: " + nre.getMessage());
			dto.setExitoso(false);
			dto.setMensajeEjecucion("No existen registros para el comic con id " + idComic);
		} catch (Exception e) {
			dto.setExitoso(false);
			dto.setMensajeEjecucion("Se ha presentado un error tecnico " + e.getMessage());
			LOGGER.info("Se ha presentado un error tecnico " + e.getMessage());
		}
		LOGGER.info("Finaliza ejecucion consultarComic() ");

		return dto;
	}

	/**
	 * @see com.hbt.semillero.poo.interfaces.IGestionarComicLocal#ActualizarComic(com.hbt.semillero.dtos.ComicDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO ActualizarComic(ComicDTO comicDTO) throws Exception {
		LOGGER.info("Inicia ejecucion ActualizarComic() ");

		if (comicDTO.getId() == null || comicDTO.getId() == 0) {
			throw new Exception("El campo id es requerido");
		}

		if (comicDTO.getNombre() == null) {
			throw new Exception("El campo nombre es requerido");
		}

		verificaEnum(TematicaEnum.values(), comicDTO.getTematicaEnum(), "tematicaEnum");

		verificaEnum(EstadoEnum.values(), comicDTO.getEstadoEnum(), "estadoEnum");

		ResultadoDTO resultadoDTO = new ResultadoDTO();

		try {
			Comic comic = em.find(Comic.class, comicDTO.getId());

			this.actualizarComicDTOToComic(comicDTO, comic);
			em.merge(comic);
			resultadoDTO.setExitoso(true);
			resultadoDTO.setMensajeEjecucion("El comic ha sido actualizado exitosamente");

		} catch (NullPointerException nure) {
			LOGGER.info("Se ha presentado NullPointerException: " + nure.getMessage());
			throw new Exception("No existen registros para el comic con id " + comicDTO.getId());
		} catch (Exception e) {
			LOGGER.info("Se ha presentado un error tecnico " + e.getMessage());
			throw new Exception("Se ha presentado un error tecnico " + e.getMessage());
		}

		LOGGER.info("Finaliza ejecucion ActualizarComic() ");
		return resultadoDTO;
	}

	/**
	 * Metodo encargado de verificar si el valor recibido pertenece a los items del
	 * enum declarado
	 * 
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param items
	 * @param compare
	 * @param nombreCampo
	 * @throws Exception
	 */
	private void verificaEnum(Object items[], Object compare, String nombreCampo) throws Exception {
		boolean checkEnum = false;
		for (Object itemsEnum : items) {
			if (itemsEnum.toString().equals(compare.toString())) {
				checkEnum = true;
				break;
			}
		}
		if (!checkEnum) {
			throw new Exception("El campo " + nombreCampo + " no es valido");
		}
	}

	/**
	 * Metodo encargado de actualizar los datos del DTO a la entidad comic
	 * 
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param comicDTO
	 * @param comic
	 */
	private void actualizarComicDTOToComic(ComicDTO comicDTO, Comic comic) {
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(TematicaEnum.valueOf(comicDTO.getTematicaEnum()));
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(EstadoEnum.valueOf(comicDTO.getEstadoEnum()));
		comic.setCantidad(comicDTO.getCantidad());
	}

	/**
	 * @see com.hbt.semillero.poo.interfaces.IGestionarComicLocal#EliminarComic(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO EliminarComic(Long idComic) throws Exception {
		LOGGER.info("Inicia ejecucion EliminarComic() ");

		if (idComic == null || idComic == 0) {
			throw new Exception("El campo id es requerido");
		}

		ResultadoDTO resultadoDTO = new ResultadoDTO();

		try {
			Comic comic = em.find(Comic.class, idComic);
			em.remove(comic);
			resultadoDTO.setExitoso(true);
			resultadoDTO.setMensajeEjecucion("El comic ha sido eliminado exitosamente");

		} catch (IllegalArgumentException nure) {
			LOGGER.info("Se ha presentado IllegalArgumentException: " + nure.getMessage());
			throw new Exception("No existen registros para el comic con id " + idComic);
		} catch (Exception e) {
			LOGGER.info("Se ha presentado un error tecnico " + e.getMessage());
			throw new Exception("Se ha presentado un error tecnico " + e.getMessage());
		}

		LOGGER.info("Finaliza ejecucion EliminarComic() ");
		return resultadoDTO;
	}

	@Override
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ObtenerComicsDTO obtenerComics() {
		LOGGER.info("Inicia ejecucion obtenerComics() ");

		ObtenerComicsDTO dto = new ObtenerComicsDTO();
		String consultaComics = "SELECT c " + " FROM Comic c ";
		
		List<Comic> comicsList = new ArrayList<>();
		try {
			Query queryConsultaComic = em.createQuery(consultaComics);			
			comicsList = queryConsultaComic.getResultList();
//			comics.forEach( (comic) ->{
//				ComicDTO comicDTO = new ComicDTO();
//				this.actualizarComicToComicDTO(comic, comicDTO);
//				comicsList.add(comicDTO);
//			} );
			dto.setComicsList(comicsList);
			dto.setExitoso(true);
			dto.setMensajeEjecucion("Se ha ejecutado exitosamente");
		} catch (NoResultException nre) {
			LOGGER.info("Se ha presentado NoResultException: " + nre.getMessage());
			dto.setComicsList(comicsList);
			dto.setExitoso(false);
			dto.setMensajeEjecucion("No existen registros en la tabla");
		} catch (Exception e) {
			dto.setComicsList(comicsList);
			dto.setExitoso(false);
			dto.setMensajeEjecucion("Se ha presentado un error tecnico " + e.getMessage());
			LOGGER.info("Se ha presentado un error tecnico " + e.getMessage());
		}
		LOGGER.info("Finaliza ejecucion obtenerComics() ");

		return dto;
	}
	
	/**
	 * Metodo encargado de actualizar los datos de la entidad comic al DTO 
	 * 
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param comicDTO
	 * @param comic
	 */
	private void actualizarComicToComicDTO(Comic comic, ComicDTO comicDTO) {
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setEditorial(comic.getEditorial());
		comicDTO.setTematicaEnum(comic.getTematicaEnum().toString());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
		comicDTO.setPrecio(comic.getPrecio());
		comicDTO.setAutores(comic.getAutores());
		comicDTO.setColor(comic.getColor());
		comicDTO.setFechaVenta(comic.getFechaVenta());
		comicDTO.setEstadoEnum(comic.getEstadoEnum().toString());
		comicDTO.setCantidad(comic.getCantidad());
	}

}