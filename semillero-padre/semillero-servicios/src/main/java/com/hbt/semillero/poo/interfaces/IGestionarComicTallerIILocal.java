package com.hbt.semillero.poo.interfaces;

import javax.ejb.Local;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dtos.ConsultarComicTamanioNombreDTO;
import com.hbt.semillero.dtos.ResultadoDTO;

/**
 * <b>Descripción:<b> Interface que determina las acciones que puede realizar en
 * la gestion del comic taller II
 * 
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
@Local
public interface IGestionarComicTallerIILocal {

	/**
	 * Metodo encargado de consultar el nombre y precio de un comic dado el
	 * identificador del mismo
	 * 
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param idComic identificador del comic
	 * @return ConsultaNombrePrecioComicDTO dto de la consulta
	 */
	public ConsultarComicTamanioNombreDTO consultarComicTamanioNombre(Short lengthComic) throws Exception;

	
}
