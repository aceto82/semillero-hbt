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

import com.hbt.semillero.dtos.ConsultarComicTamanioNombreDTO;
import com.hbt.semillero.dtos.ResultadoDTO;
import com.hbt.semillero.poo.interfaces.IGestionarComicTallerIILocal;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
@Path("/gestionarComicTallerIIRest")
public class GestionarComicTallerIIRest {
	
	@EJB
	private IGestionarComicTallerIILocal gestionarComicTallerIIBean;
	
	/**
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @return
	 */
	@GET
	@Path("/consultarComicTamanioNombre")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO consultarComicTamanioNombre(@QueryParam("lengthComic") Short lengthComic) {
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
