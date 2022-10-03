package com.api.dto;

public class UsuarioDTO {

	private Long idUsuario;

	private String nombre;
	private String username;
	private String email;
	private String password;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(Long idUsuario, String nombre, String username, String email, String password) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.username = username;
		this.email = email;
		this.password = password;
	}

}
