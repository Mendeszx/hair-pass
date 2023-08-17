package com.api.hairpass.domain.services;


import com.api.hairpass.adapters.persistence.FuncionariosRepository;
import com.api.hairpass.domain.entities.FuncionariosEntity;
import com.api.hairpass.domain.entities.UsuariosEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FuncionariosService {

    @Autowired
    FuncionariosRepository funcionariosRepository;

    private final static String DATE_FORMAT = "dd-MM-yyyy";

    @Transactional
    public FuncionariosEntity cadastrarNovoFuncionario(UsuariosEntity usuariosEntity) {
        FuncionariosEntity funcionariosEntity = new FuncionariosEntity();

        funcionariosEntity.setUsuarioId(usuariosEntity);

        LocalDate dataDeCadastro = LocalDate.now();

        funcionariosEntity.setDataDeCadastro(dataDeCadastro);
        funcionariosEntity.setFuncionarioAtivo(true);

        try {
            funcionariosEntity = funcionariosRepository.save(funcionariosEntity);
            return funcionariosEntity;
        } catch (Exception e){
            throw e;
        }
    }
}
