package com.api.hairpass.domain.services;


import com.api.hairpass.adapters.persistence.FuncionarioRepository;
import com.api.hairpass.domain.entities.FuncionarioEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Transactional
    public void save(FuncionarioEntity funcionarioEntity) {
        funcionarioRepository.save(funcionarioEntity);
    }
}
