package com.api.services;



import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.api.dto.UsuarioDTO;
import com.api.dto.UsuarioRespuesta;
import com.api.exceptions.ResourceNotFoundException;
import com.api.models.UsuarioModel;
import com.api.repository.UsuarioRepositorio;

@Service
public class UsuarioServiceImp implements UsuarioService {
	// ESTÁ CLASE SERVICIO DONDE SE UTILIZAR PARA REALIZAR LLAMADOS HACIA EL CONTROLADOR PARA REALIZAR LISTAR, GUARDAR, ACTUALIZAR, ELIMINAR
	@Autowired
	private ModelMapper modelmapper; //INYECCIÓN DE CLASE MODELMAPPER 
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio; //INYECCIÓN DE CLASE USUARIOREPOSITORIO
	
	//MÉTODO GUARDAR 
	@Override
	public UsuarioDTO guardarUsuario(UsuarioDTO usuario) {
		UsuarioModel usuarios = mapearModelo(usuario);
		
		UsuarioModel nuevoUsuario = usuarioRepositorio.save(usuarios);
		
		UsuarioDTO  usuarioRespuesta = mapearDTO(nuevoUsuario);
		
		return usuarioRespuesta;
	}
	
	//MÉTODO EN LISTAR USUARIOS
	@Override
	public UsuarioRespuesta obtenerListaUsuarios(int numeroPagina, int medidaDePagina, String ordenarPor,
			String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(ordenarPor).ascending():Sort.by(ordenarPor).descending();
		Pageable pageable = PageRequest.of(numeroPagina, medidaDePagina, sort);
		Page<UsuarioModel> usuarios = usuarioRepositorio.findAll(pageable);
		
		List<UsuarioModel> listasDeUsuarios = usuarios.getContent();
		List<UsuarioDTO> contenido = listasDeUsuarios.stream().map(usuario -> mapearDTO(usuario)).collect(Collectors.toList());
		
		UsuarioRespuesta usuariosRespuesta =  new UsuarioRespuesta();
		usuariosRespuesta.setContenido(contenido); 
		usuariosRespuesta .setNumeroPagina(usuarios.getNumber());
		usuariosRespuesta.setMedidaPagina(usuarios.getSize());
		usuariosRespuesta.setTotalElementos(usuarios.getTotalElements());
		usuariosRespuesta.setUltima(usuarios.isLast());
		
		return usuariosRespuesta;
	}
	
	//MÉTODO EN LISTAR USUARIO POR ID
	@Override
	public UsuarioDTO obtenerPorId(Long idUsuario) {
		UsuarioModel usuario = usuarioRepositorio.findById(idUsuario)
				.orElseThrow(() -> new ResourceNotFoundException("usuarios", "idUsuario", idUsuario));
				
		return mapearDTO(usuario);
	}
	
	//MÉTODO ACTUALIZAR USUARIO DEL REGISTRO
	@Override
	public UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO, Long idUsuario) {
		UsuarioModel usuario = usuarioRepositorio.findById(idUsuario)
				.orElseThrow(() -> new ResourceNotFoundException("usuarios", "idUsuario", idUsuario));
		//Mostrar datos a modificar
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setUsername(usuarioDTO.getUsername());
		usuario.setEmail(usuarioDTO.getEmail());
		
		UsuarioModel usuarioActualizar = usuarioRepositorio.save(usuario);
		return mapearDTO(usuarioActualizar);
	}
	
	//MÉTODO ELIMINAR USUARIO
	@Override
	public void eliminarUsuario(Long idUsuario) {
		UsuarioModel usuario = usuarioRepositorio.findById(idUsuario)
				.orElseThrow(() -> new ResourceNotFoundException("usuarios", "idUsuario", idUsuario));
		
		usuarioRepositorio.delete(usuario);
	}
	
	//Método converción de modelo a DTO DATA TRANSPORT OBJECT
	public UsuarioDTO mapearDTO(UsuarioModel usuario) {
		UsuarioDTO usuarioDTO = modelmapper.map(usuario, UsuarioDTO.class);
		
		return usuarioDTO;
	}
	
	//Método converción DTO A modelo PUEDE TAMBIEN EN ENTIDADES EJEMPLO usuarioEntity
	public UsuarioModel mapearModelo(UsuarioDTO usuarioDTO) {
		UsuarioModel usuarioM = modelmapper.map(usuarioDTO, UsuarioModel.class);
		
		return usuarioM;
	}

}
