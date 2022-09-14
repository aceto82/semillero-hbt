package com.hbt.semillero.poo.interfaces;

import javax.ejb.Local;

import com.hbt.semillero.dtos.ComicDTO;
import com.hbt.semillero.dtos.ConsultarComicDTO;
import com.hbt.semillero.dtos.ObtenerComicsDTO;
import com.hbt.semillero.dtos.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dtos.ResultadoDTO;

/**
 * <b>Descripción:<b> Interface que determina las acciones que puede realizar en
 * la gestion del comic
 * 
 * <b>Caso de Uso:<b> Semillero2022
 * 
 * @author Diego Armando Ortiz Bastidas
 * @version 1.0
 */
@Local
public interface IGestionarComicLocal {

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
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic);

	/**
	 * Metodo encargado de crear y verificar el comic, con la informacion recibida
	 * del dto comic
	 * 
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param comicDTO dto con los datos del comic
	 * @return ResultadoDTO dto resultado
	 * @throws Exception
	 */
	public ResultadoDTO crearComic(ComicDTO comicDTO) throws Exception;

	/**
	 * Metodo encargado de consultar todos los datos de un comic 
	 * 
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param idComic
	 * @return ConsultaComicDTO
	 */
	public ConsultarComicDTO consultarComic(Long idComic);

	/**
	 * Metodo encargado de actualizar la información de un comic
	 * 
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param comicDTO
	 * @return ResultadoDTO
	 * @throws Exception
	 */
	public ResultadoDTO ActualizarComic(ComicDTO comicDTO) throws Exception;

	/**
	 * Metodo encargado de eliminar la informacion de un comic
	 * 
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param idComic
	 * @return ResultadoDTO
	 * @throws Exception
	 */
	public ResultadoDTO EliminarComic(Long idComic) throws Exception;
	
	/**
	 * Metodo encargado de generar un listado de todos los comics 
	 * 
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 *  
	 * @return ObtenerComicsDTO
	 */
	public ObtenerComicsDTO obtenerComics();
}
