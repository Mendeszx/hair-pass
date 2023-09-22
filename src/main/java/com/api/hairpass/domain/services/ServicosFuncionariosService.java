package com.api.hairpass.domain.services;

import com.api.hairpass.adapters.persistence.ServicosFuncionariosRepository;
import com.api.hairpass.domain.entities.FuncionariosEntity;
import com.api.hairpass.domain.entities.ServicosEntity;
import com.api.hairpass.domain.entities.ServicosFuncionariosEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ServicosFuncionariosService {

    @Autowired
    ServicosFuncionariosRepository servicosFuncionariosRepository;

    @Transactional
    public ServicosFuncionariosEntity cadastratNovoServicoParaFuncionario(FuncionariosEntity funcionariosEntity, ServicosEntity servicosEntity) {
        ServicosFuncionariosEntity servicosFuncionariosEntity = new ServicosFuncionariosEntity();

        servicosFuncionariosEntity.setFuncionarioId(funcionariosEntity);
        servicosFuncionariosEntity.setServicoId(servicosEntity);

        LocalDate dataDeCadastro = LocalDate.now();

        servicosFuncionariosEntity.setDataDeCadastro(dataDeCadastro);
        servicosFuncionariosEntity.setServicoFuncionarioAtivo(true);

        try {
            servicosFuncionariosEntity = servicosFuncionariosRepository.save(servicosFuncionariosEntity);
            return servicosFuncionariosEntity;
        } catch (Exception e) {
            throw e;
        }
    }
}
