package com.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
// ESTA CLASE CONTIENE LOS NOMBRE DE LOS RECURSOS A UTILIZAR, NOMBRE PÁGINA, VALOR DEL CAMPO Y OTROS
	
	private static final long serialVersionUID = 1L; // NÚMERO DE IDENTIFICACIÓN DE LOS MENSAJES SALIENTE 

	private String nombreDelRecurso; // NOMBRE DEL RECURSO EJEMPLOS NOMBRE DE UNA PAGINA NO EXISTENTE
	private String nombreDelCampo; // NOMBRE CAMPO REQUERIDO EJEMPLOS NOMBRE DE UN CAMPO NO ENCONTRADO O NO VALIDO
	private long valorDelcampo; // VALORES DE ENTRADAS EJEMPLOS VOLORES DEL CAMPO QUE NO CORESPONDAN
	
	public ResourceNotFoundException(String nombreDelRecurso, String nombreDelCampo, long valorDelcampo) {
		super(String.format("%s No encontrado con : %s : '%s'", nombreDelRecurso, nombreDelCampo, valorDelcampo));
		this.nombreDelRecurso = nombreDelRecurso;
		this.nombreDelCampo = nombreDelCampo;
		this.valorDelcampo = valorDelcampo;
	}

	public String getNombreDelRecurso() {
		return nombreDelRecurso;
	}

	public void setNombreDelRecurso(String nombreDelRecurso) {
		this.nombreDelRecurso = nombreDelRecurso;
	}

	public String getNombreDelCampo() {
		return nombreDelCampo;
	}

	public void setNombreDelCampo(String nombreDelCampo) {
		this.nombreDelCampo = nombreDelCampo;
	}

	public long getValorDelcampo() {
		return valorDelcampo;
	}

	public void setValorDelcampo(long valorDelcampo) {
		this.valorDelcampo = valorDelcampo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
