/**
 * TallerIIServicioRest.java
 */
package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dtos.ResultadoDTO;
import com.hbt.semillero.poo.interfaces.IGestionarComicTallerIILocal;

/**
 * <b>Descripción:<b> Clase que determina el api del taller 2 servicio web tipo
 * rest 
 * 
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
@Path("/gestionarComicTallerIIRest")
public class GestionarComicTallerIIRest {

	/*
	 * Atributo que se inyecta el cual gestiona la logica del negocio
	 */
	@EJB
	private IGestionarComicTallerIILocal gestionarComicTallerIIBean;

	/**
	 * Metodo encargado de generar el endpoint tipo GET que compara la longitud del
	 * nombre de todos los comics, segun el valor dado en parametro lengthComic
	 * 
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param lengthComic
	 * @return dto
	 */
	@GET
	@Path("/consultarComicTamanioNombre")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO consultarComicTamanioNombre(@QueryParam("lengthComic") String lengthComic) {
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		try {
			resultadoDTO = this.gestionarComicTallerIIBean.consultarComicTamanioNombre(lengthComic);
		} catch (Exception e) {
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensajeEjecucion(e.getMessage());
		}
		return resultadoDTO;
	}

}
