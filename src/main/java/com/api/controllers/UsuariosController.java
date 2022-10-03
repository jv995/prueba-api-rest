package com.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.UsuarioDTO;
import com.api.dto.UsuarioRespuesta;
import com.api.services.UsuarioService;
import com.api.utilities.AppConstantes;

@RestController
@RequestMapping("/api/usuarios")// BACKEND RUTA DE LA API- REST LOCALHOST:8080/API/USUARIOS

@CrossOrigin()// PROTOCOLO DE DATOS CRUZADOS
public class UsuariosController {

	@Autowired
	private UsuarioService usuarioService;// ASIGNACIÓN CON EL MÉTODO INYECCIÓN DE CLASES DE USUARIOSERVICE DEL PAQUETE SERVICES
	
	// ROUTER DE LISTAR USUARIOS
	@GetMapping
	public UsuarioRespuesta listarUsuarios(
			@RequestParam(value = "pageNo", defaultValue = AppConstantes.NUMERO_DE_PAGINA_POR_DEFECTO, required = false) int numeroPagina,
			@RequestParam(value = "pageSize", defaultValue = AppConstantes.MEDIDA_DE_PAGINA_POR_DEFECTO, required = false) int medidaDePagina,
			@RequestParam(value = "sortBy", defaultValue = AppConstantes.ORDEN_POR_DEFECTO, required = false) String ordenarPor,
			@RequestParam(value = "sortDir", defaultValue = AppConstantes.ORDEN_DIRECCION_POR_DEFECTO, required = false) String sortDi
			) {
		return usuarioService.obtenerListaUsuarios(numeroPagina, medidaDePagina, ordenarPor, sortDi);
	}
	
	// ROUTER DE GUARDAR USUARIOS
	@PostMapping
	public ResponseEntity<UsuarioDTO> guardarUsuarios(@Valid @RequestBody UsuarioDTO usuarioDTO){
		return new ResponseEntity<>(usuarioService.guardarUsuario(usuarioDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<UsuarioDTO> obtenerUsuarioPorId(@PathVariable(name = "idUsuario") Long idUsuario){
		return ResponseEntity.ok(usuarioService.obtenerPorId(idUsuario));
	}
	
	@PutMapping("/{idUsuario}")
	public ResponseEntity<UsuarioDTO> actualizarUsuarios(@Valid @RequestBody UsuarioDTO usuarioDTO, @PathVariable(name = "idUsuario") long idUsuario){
		UsuarioDTO usuarioRespuesta = usuarioService.actualizarUsuario(usuarioDTO, idUsuario);
		return new ResponseEntity<>(usuarioRespuesta, HttpStatus.OK);
	}
	
	@DeleteMapping("/{idUsuario}")
	public ResponseEntity<String> eliminarUsuario(@PathVariable(name = "idUsuario") long idUsuario){
		usuarioService.eliminarUsuario(idUsuario);
		return new ResponseEntity<>("Usuario eliminado con exito", HttpStatus.OK);
	}
}
