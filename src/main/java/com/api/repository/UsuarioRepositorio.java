package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.UsuarioModel;

public interface UsuarioRepositorio extends JpaRepository<UsuarioModel, Long>{

}
