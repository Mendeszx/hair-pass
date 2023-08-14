package com.api.hairpass.domain.services;

import com.api.hairpass.adapters.controllers.dtos.request.CadastroUsuarioRequest;
import com.api.hairpass.adapters.persistence.UsuarioRepository;
import com.api.hairpass.common.enums.RoleEnum;
import com.api.hairpass.domain.entities.UsuarioEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<UsuarioEntity> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public void save(CadastroUsuarioRequest cadastroUsuarioRequest) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        BeanUtils.copyProperties(cadastroUsuarioRequest, usuarioEntity);
        usuarioEntity.setSenha(new BCryptPasswordEncoder().encode(cadastroUsuarioRequest.getSenha()));
        usuarioEntity.setRole(RoleEnum.ROLE_USUARIO);
        usuarioEntity.setAtivo(true);
        usuarioRepository.save(usuarioEntity);
    }
}
