package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ConsultarComicDTO;
import com.hbt.semillero.dtos.ObtenerComicsDTO;
import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dtos.ResultadoDTO;
import com.hbt.semillero.poo.interfaces.IGestionarComicLocal;
import com.hbt.semillero.poo.interfaces.IGestionarCompraComicLocal;

/**
 * <b>Descripción:<b> Clase que determina donde se configura la api rest con sus
 * respectivos endpoits para la gestion de la compra de comics
 * 
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
@Path("/gestionarCompraComicRest")
public class GestionarCompraComicRest {

	/*
	 * Atributo que se inyecta el cual gestiona la logica del negocio
	 */
	@EJB
	private IGestionarCompraComicLocal gestionarCompraComicLocal;

	


	/**
	 * Metodo encargado de generar el endpoint tipo PUT para comprar un comic, segun el id del mismo
	 * 
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param idComic
	 * @param cantidad
	 * @return ResultadoDTO
	 */
	@PUT
	@Path("/comprarComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO eliminarComic(@QueryParam("idComic") Long idComic, @QueryParam("cantidad") Short cantidad) {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		try {
			resultadoDTO = this.gestionarCompraComicLocal.ComprarComic(idComic, cantidad);
		} catch (Exception e) {
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensajeEjecucion(e.getMessage());
		}
		return resultadoDTO;
	}
	

}
