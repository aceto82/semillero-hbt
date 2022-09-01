package com.hbt.semillero.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaNombrePrecioComicDTO extends ResultadoDTO implements Serializable {

	private static final long serialVersionUID = -8625395796453762497L;
	
	private String nombre;
	
	private BigDecimal precio;	
	

}
