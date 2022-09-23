package com.grupo_10.grupo_10.repository;

import com.grupo_10.grupo_10.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository <Usuarios, Long>{

    Usuarios findByEmail(String email);
}