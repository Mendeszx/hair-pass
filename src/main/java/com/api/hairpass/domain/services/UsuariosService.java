package com.api.hairpass.domain.services;

import com.api.hairpass.adapters.controllers.dtos.request.CadastroUsuarioRequest;
import com.api.hairpass.adapters.persistence.UsuariosRepository;
import com.api.hairpass.common.enums.RoleEnum;
import com.api.hairpass.domain.entities.EmpresasEntity;
import com.api.hairpass.domain.entities.FuncionariosEntity;
import com.api.hairpass.domain.entities.UsuariosEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    UsuariosRepository usuariosRepository;

    private final static String DATE_FORMAT = "dd-MM-yyyy";

    public Optional<UsuariosEntity> findByEmail(String email) {
        return usuariosRepository.findByEmail(email);
    }

    @Transactional
    public void cadastrarNovoUsuario(CadastroUsuarioRequest cadastroUsuarioRequest) {
        UsuariosEntity usuariosEntity = new UsuariosEntity();
        BeanUtils.copyProperties(cadastroUsuarioRequest, usuariosEntity);

        usuariosEntity.setSenha(new BCryptPasswordEncoder().encode(cadastroUsuarioRequest.getSenha()));

        LocalDate dataDeNascimento = LocalDate.parse(cadastroUsuarioRequest.getDataDeNascimento());

        LocalDate dataDeCadastro = LocalDate.now();

        usuariosEntity.setDataDeNascimento(dataDeNascimento);
        usuariosEntity.setDataDeCadastro(dataDeCadastro);
        usuariosEntity.setRole(RoleEnum.ROLE_USUARIO);
        usuariosEntity.setUsuarioAtivo(true);

        usuariosRepository.save(usuariosEntity);
    }

    @Transactional
    public void atualizarUsuarioParaUsuarioFuncionario(FuncionariosEntity funcionariosEntity) {
        UsuariosEntity usuariosEntity = findUsuariosById(funcionariosEntity.getUsuarioId().getUsuarioId());

        usuariosEntity.setRole(RoleEnum.ROLE_USUARIO_FUNCIONARIO);
        usuariosEntity.setFuncionarioAtivo(true);
        usuariosEntity.setFuncionarioId(funcionariosEntity);

        usuariosRepository.save(usuariosEntity);
    }

    public UsuariosEntity findUsuariosById(Long usuarioId) {
        Optional<UsuariosEntity> entity = usuariosRepository.findById(usuarioId);

        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new RuntimeException("Usuario não encontrado");
        }
    }

    @Transactional
    public void atualizarUsuarioParaUsuarioEmpresa(EmpresasEntity empresasEntity) {
        UsuariosEntity usuariosEntity = findUsuariosById(empresasEntity.getUsuarioId().getUsuarioId());

        usuariosEntity.setRole(RoleEnum.ROLE_USUARIO_EMPRESA);
        usuariosEntity.setEmpresaAtivo(true);
        usuariosEntity.setEmpresaId(empresasEntity);

        usuariosRepository.save(usuariosEntity);
    }
}
