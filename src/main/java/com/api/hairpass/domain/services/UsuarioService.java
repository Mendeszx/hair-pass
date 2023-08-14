package com.api.hairpass.domain.services;

import com.api.hairpass.adapters.controllers.dtos.request.CadastroUsuarioRequest;
import com.api.hairpass.adapters.persistence.UsuarioRepository;
import com.api.hairpass.common.enums.RoleEnum;
import com.api.hairpass.domain.entities.UsuarioEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    private final static String DATE_FORMAT = "dd-MM-yyyy";

    public Optional<UsuarioEntity> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public void save(CadastroUsuarioRequest cadastroUsuarioRequest) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        BeanUtils.copyProperties(cadastroUsuarioRequest, usuarioEntity);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDate dataDeNascimento = LocalDate.parse(cadastroUsuarioRequest.getDataDeNascimento(), formato);

        LocalDate dataDeCadastro = LocalDate.now();
        usuarioEntity.setDataDeCadastro(dataDeCadastro);
        usuarioEntity.setDataDeNascimento(dataDeNascimento);

        usuarioEntity.setSenha(new BCryptPasswordEncoder().encode(cadastroUsuarioRequest.getSenha()));
        usuarioEntity.setRole(RoleEnum.ROLE_USUARIO);
        usuarioEntity.setAtivo(true);
        usuarioRepository.save(usuarioEntity);
    }
}
