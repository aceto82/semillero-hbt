package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dtos.ResultadoDTO;
import com.hbt.semillero.poo.interfaces.IGestionarComicLocal;

/**
 * <b>Descripción:<b> Clase que determina donde se configura la api rest con sus
 * respectivos endpoits
 * 
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
@Path("/gestionComicRest")
public class GestionarComicRest {

	/*
	 * Atributo que se inyecta el cual gestiona la logica del negocio
	 */
	@EJB
	private IGestionarComicLocal gestionarComicLocal;

	/**
	 * Metodo encargado de generar el endpoint tipo GET para realizar la consulta
	 * del nombre y precio de un comic, segun el identificador
	 * 
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param idComic identificador del comic
	 * @return ConsultaNombrePrecioComicDTO dto del nombre y precio de un comic
	 */
	@GET
	@Path("/consultarNombrePrecioComic")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(@QueryParam("idComic") Long idComic) {
		return this.gestionarComicLocal.consultarNombrePrecioComic(idComic);
	}

	/**
	 * Metodo encargado de generar el endpoint tipo POST para crear un comic, con la
	 * informacion recibida en formato json
	 * 
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param comicDTO dto con la informacion del comic
	 * @return ResultadoDTO dto que solo indica si fue exitoso o no y su respetivo
	 *         mensaje
	 */
	@POST
	@Path("/crearComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearComic(ComicDTO comicDTO) {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		try {
			resultadoDTO = this.gestionarComicLocal.crearComic(comicDTO);
		} catch (Exception e) {
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensajeEjecucion(e.getMessage());
		}
		return resultadoDTO;
	}

}
