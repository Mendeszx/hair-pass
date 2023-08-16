package com.api.hairpass.domain.services;


import com.api.hairpass.adapters.controllers.dtos.request.CadastroFuncionariosRequest;
import com.api.hairpass.adapters.persistence.FuncionariosRepository;
import com.api.hairpass.domain.entities.FuncionariosEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FuncionariosService {

    @Autowired
    FuncionariosRepository funcionariosRepository;

    private final static String DATE_FORMAT = "dd-MM-yyyy";

    @Transactional
    public void cadastrarNovoFuncionario(CadastroFuncionariosRequest cadastroFuncionariosRequest) {
        FuncionariosEntity funcionariosEntity = new FuncionariosEntity();
        BeanUtils.copyProperties(cadastroFuncionariosRequest, funcionariosEntity);

        LocalDate dataDeCadastro = LocalDate.now();

        funcionariosEntity.setDataDeCadastro(dataDeCadastro);
        funcionariosEntity.setFuncionarioAtivo(true);

        try {
            funcionariosRepository.save(funcionariosEntity);
        } catch (Exception e){
            throw e;
        }
    }
}
