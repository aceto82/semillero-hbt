package com.hbt.semillero.poo.interfaces;

import javax.ejb.Local;

import com.hbt.semillero.dtos.ConsultarComicTamanioNombreDTO;


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
	 * Método encargado de verificar el tipo de dato del parametro, una vez validado
	 * realizara el proceso destinado
	 * 
	 * <b>Caso de Uso</b> Semillero2022
	 * 
	 * @author Diego Armando Ortiz Bastidas
	 * 
	 * @param lengthComic
	 * @return ConsultarComicTamanioNombreDTO dto de la consulta
	 * @throws Exception
	 */
	public ConsultarComicTamanioNombreDTO consultarComicTamanioNombre(String lengthComic) throws Exception;

	// public ConsultarComicTamanioNombreDTO consultarComicTamanioNombre(Short
	// lengthComic) throws Exception;

}
