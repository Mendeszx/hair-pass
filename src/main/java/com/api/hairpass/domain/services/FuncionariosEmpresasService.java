package com.api.hairpass.domain.services;

import com.api.hairpass.adapters.persistence.FuncionariosEmpresasRepository;
import com.api.hairpass.domain.entities.EmpresasEntity;
import com.api.hairpass.domain.entities.FuncionariosEmpresasEntity;
import com.api.hairpass.domain.entities.FuncionariosEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FuncionariosEmpresasService {

    @Autowired
    FuncionariosEmpresasRepository funcionariosEmpresasRepository;

    @Transactional
    public FuncionariosEmpresasEntity cadastratNovoFuncionarioNaEmpresa(FuncionariosEntity funcionariosEntity, EmpresasEntity empresasEntity) {
        FuncionariosEmpresasEntity funcionariosEmpresasEntity = new FuncionariosEmpresasEntity();

        funcionariosEmpresasEntity.setEmpresaId(empresasEntity);
        funcionariosEmpresasEntity.setFuncionarioId(funcionariosEntity);

        LocalDate dataDeCadastro = LocalDate.now();

        funcionariosEmpresasEntity.setDataDeCadastro(dataDeCadastro);
        funcionariosEmpresasEntity.setFuncionarioEmpresaAtivo(true);

        try {
            funcionariosEmpresasEntity = funcionariosEmpresasRepository.save(funcionariosEmpresasEntity);
            return funcionariosEmpresasEntity;
        } catch (Exception e){
            throw e;
        }
    }
}
