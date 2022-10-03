package com.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {
	// CLASE POJO DE MODELO DE USUARIO
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonBackReference
	private Long idUsuario;// ATRIBUTO ID-USUARIOS
	
	private String nombre;// ATRIBUTO NOMBRE
	private String username;// ATRIBUTO NOMBRE USUARIO
	private String email;// ATRIBUTO EMAIL
	private String password;// ATRIBUTO PASSWARD
	
	//MÉTODO GETTER ENTRADA DE DATOS
	public Long getIdUsuario() {
		return idUsuario;
	}
	//MÉTODO SETTER SALIDA DE DATOS
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	//MÉDOTOD GETTER
	public String getNombre() {
		return nombre;
	}
	//MÉTODO SETTER SALIDA DE DATOS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//MÉDOTOD GETTER
	public String getUsername() {
		return username;
	}
	//MÉTODO SETTER SALIDA DE DATOS
	public void setUsername(String username) {
		this.username = username;
	}
	//MÉDOTOD GETTER
	public String getEmail() {
		return email;
	}
	//MÉTODO SETTER SALIDA DE DATOS
	public void setEmail(String email) {
		this.email = email;
	}
	//MÉDOTOD GETTER
	public String getPassword() {
		return password;
	}
	//MÉTODO SETTER SALIDA DE DATOS
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
