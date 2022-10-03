package com.api.services;

import com.api.dto.UsuarioDTO;
import com.api.dto.UsuarioRespuesta;

public interface UsuarioService {

	public UsuarioDTO guardarUsuario(UsuarioDTO usuario);
	
	public UsuarioRespuesta obtenerListaUsuarios(int numeroPagina, int medidaDePagina, String ordenarPor, String sortDir);
	
	public UsuarioDTO obtenerPorId(Long idUsuario);
	
	public UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO, Long idUsuario);
	
	public void eliminarUsuario(Long idUsuario);
}
