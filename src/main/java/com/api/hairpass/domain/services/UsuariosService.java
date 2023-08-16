package com.api.hairpass.domain.services;

import com.api.hairpass.adapters.controllers.dtos.request.CadastroFuncionariosRequest;
import com.api.hairpass.adapters.controllers.dtos.request.CadastroUsuariosRequest;
import com.api.hairpass.adapters.persistence.UsuariosRepository;
import com.api.hairpass.common.enums.RoleEnum;
import com.api.hairpass.domain.entities.UsuariosEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    UsuariosRepository usuariosRepository;

    private final static String DATE_FORMAT = "dd-MM-yyyy";

    public Optional<UsuariosEntity> findByEmail(String email) {
        return usuariosRepository.findByEmail(email);
    }

    public void save(CadastroUsuariosRequest cadastroUsuariosRequest) {
        UsuariosEntity usuariosEntity = new UsuariosEntity();
        BeanUtils.copyProperties(cadastroUsuariosRequest, usuariosEntity);

        usuariosEntity.setSenha(new BCryptPasswordEncoder().encode(cadastroUsuariosRequest.getSenha()));

        DateTimeFormatter formato = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDate dataDeNascimento = LocalDate.parse(cadastroUsuariosRequest.getDataDeNascimento(), formato);

        LocalDate dataDeCadastro = LocalDate.now();

        usuariosEntity.setDataDeNascimento(dataDeNascimento);
        usuariosEntity.setDataDeCadastro(dataDeCadastro);
        usuariosEntity.setRole(RoleEnum.ROLE_USUARIO);
        usuariosEntity.setUsuarioAtivo(true);

        usuariosRepository.save(usuariosEntity);
    }

    public void atualizarUsuarioParaUsuarioFuncionario(CadastroFuncionariosRequest cadastroFuncionariosRequest) {
        UsuariosEntity usuariosEntity = findUsuariosById(cadastroFuncionariosRequest.getUsuarioId());

        usuariosEntity.setRole(RoleEnum.ROLE_USUARIO_FUNCIONARIO);
        usuariosEntity.setFuncionarioAtivo(true);

        usuariosRepository.save(usuariosEntity);
    }

    public UsuariosEntity findUsuariosById(Long id) {
        Optional<UsuariosEntity> entity = usuariosRepository.findById(id);

        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new RuntimeException("Usuario não encontrado");
        }
    }
}
