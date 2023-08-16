package com.api.hairpass.domain.services;

import com.api.hairpass.adapters.persistence.AgendamentosRepository;
import com.api.hairpass.domain.entities.AgendamentosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentosService {

    @Autowired
    AgendamentosRepository agendamentosRepository;

    public void save(AgendamentosEntity agendamentosEntity) {
        agendamentosRepository.save(agendamentosEntity);
    }
}
