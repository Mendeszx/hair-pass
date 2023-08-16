package com.api.hairpass.domain.services;

import com.api.hairpass.adapters.controllers.dtos.request.CadastroEmpresasRequest;
import com.api.hairpass.adapters.persistence.EmpresasRepository;
import com.api.hairpass.domain.entities.EmpresasEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmpresasService {

    @Autowired
    EmpresasRepository empresasRepository;

    private final static String DATE_FORMAT = "dd-MM-yyyy";

    @Transactional
    public void save(CadastroEmpresasRequest cadastroEmpresasRequest) {
        EmpresasEntity empresasEntity = new EmpresasEntity();
        BeanUtils.copyProperties(cadastroEmpresasRequest, empresasEntity);

        LocalDate dataDeCadastro = LocalDate.now();

        empresasEntity.setDataDeCadastro(dataDeCadastro);
        empresasEntity.setEmpresaAtivo(true);

        empresasRepository.save(empresasEntity);
    }
}
