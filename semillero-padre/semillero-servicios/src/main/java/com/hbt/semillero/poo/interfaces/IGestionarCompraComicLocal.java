package com.hbt.semillero.poo.interfaces;

import javax.ejb.Local;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ConsultarComicDTO;
import com.hbt.semillero.dtos.ObtenerComicsDTO;
import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dtos.ResultadoDTO;

/**
 * <b>Descripción:<b> Interface que determina las acciones que puede realizar en
 * la gestion de la compra del comic
 * 
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
@Local
public interface IGestionarCompraComicLocal {

	
	/**
	 * Metodo encargado de comprar un comic
	 * 
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param idComic
	 * @param cantidad
	 * @return ResultadoDTO
	 * @throws Exception
	 */
	public ResultadoDTO ComprarComic(Long idComic, Short cantidad) throws Exception;
	
	
}
