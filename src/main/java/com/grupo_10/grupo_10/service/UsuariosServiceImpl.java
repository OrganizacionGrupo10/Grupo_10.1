package com.grupo_10.grupo_10.service;

import com.grupo_10.grupo_10.model.Usuarios;
import com.grupo_10.grupo_10.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class UsuariosServiceImpl {

    @Autowired
    private final UsuariosRepository usuariosRepository;


    public UsuariosServiceImpl (UsuariosRepository usuariosRepository){this.usuariosRepository =usuariosRepository;}

    public Usuarios getorCreateuser(Map <String, Object> usuariodata) {

            String email = (String) usuariodata.get("email");

            Usuarios usuario = buscarUsuarioEmail(email);

                    if (usuario == null) {
                        String auth0_id = (String) usuariodata.get("sub");
                        String name = (String) usuariodata.get("nickname");
                        String imagen = (String) usuariodata.get("picture");

                        Usuarios nuevousuario = new Usuarios(name = name, email = email, imagen = imagen, auth0_id = auth0_id);
                        return crearUsuario(nuevousuario);
                    }

                    return usuario;
    }

    public Usuarios crearUsuario (Usuarios nuevousuario){
        return this.usuariosRepository.save(nuevousuario);
    }

    public Usuarios buscarUsuarioEmail (String email) {
        return  this.usuariosRepository.findByEmail(email);
    }


}