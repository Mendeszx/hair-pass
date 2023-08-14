package com.api.hairpass.domain.services;

import com.api.hairpass.adapters.persistence.ServicoRepository;
import com.api.hairpass.domain.entities.ServicoEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

    @Autowired
    ServicoRepository servicoRepository;

    @Transactional
    public void save(ServicoEntity servicoEntity) {
        servicoRepository.save(servicoEntity);
    }
}
