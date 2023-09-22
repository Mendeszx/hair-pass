package com.api.hairpass.domain.services;

import com.api.hairpass.adapters.controllers.dtos.request.CadastroEmpresasRequest;
import com.api.hairpass.adapters.persistence.EmpresasRepository;
import com.api.hairpass.domain.entities.EmpresasEntity;
import com.api.hairpass.domain.entities.FuncionariosEntity;
import com.api.hairpass.domain.entities.ServicosEntity;
import com.api.hairpass.domain.entities.UsuariosEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class EmpresasService {

    @Autowired
    EmpresasRepository empresasRepository;

    private final static String DATE_FORMAT = "dd-MM-yyyy";

    @Transactional
    public EmpresasEntity cadastrarNovaEmpresa(UsuariosEntity usuariosEntity, CadastroEmpresasRequest cadastroEmpresasRequest) {
        EmpresasEntity empresasEntity = new EmpresasEntity();
        BeanUtils.copyProperties(cadastroEmpresasRequest, empresasEntity);

        empresasEntity.setUsuarioId(usuariosEntity);

        LocalDate dataDeCadastro = LocalDate.now();

        empresasEntity.setDataDeCadastro(dataDeCadastro);
        empresasEntity.setEmpresaAtivo(true);

        try {
            empresasEntity = empresasRepository.save(empresasEntity);
            return empresasEntity;
        } catch (Exception e){
            throw e;
        }
    }

    public EmpresasEntity findEmpresaById(String empresaId) {
        Optional<EmpresasEntity> entity = empresasRepository.findById(Long.valueOf(empresaId));

        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new RuntimeException("Empresa não encontrada");
        }
    }
}
