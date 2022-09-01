package com.hbt.semillero.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoDTO implements Serializable {

	private static final long serialVersionUID = -4222511647302179781L;

	private Boolean exitoso;

	private String mensajeEjecucion;

}