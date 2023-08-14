package com.api.hairpass.domain.services;

import com.api.hairpass.adapters.persistence.AgendamentoRepository;
import com.api.hairpass.domain.entities.AgendamentoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    @Autowired
    AgendamentoRepository agendamentoRepository;

    public void save(AgendamentoEntity agendamentoEntity) {
        agendamentoRepository.save(agendamentoEntity);
    }
}
