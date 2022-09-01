package com.hbt.semillero.poo.interfaces;

import javax.ejb.Local;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dtos.ResultadoDTO;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> Semillero2022
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
@Local
public interface IGestionarComicLocal {
	
	/**
	 * Metodo encargado de 
	 * <b>Caso de Uso</b> Semillero2022
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param idComic
	 * @return
	 */
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic);
	
	/**
	 * Metodo encargado de 
	 * <b>Caso de Uso</b> Semillero2022
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param comicDTO
	 * @return
	 * @throws Exception
	 */
	public ResultadoDTO crearComic(ComicDTO comicDTO) throws Exception;
}
