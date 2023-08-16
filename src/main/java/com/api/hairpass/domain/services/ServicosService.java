package com.api.hairpass.domain.services;

import com.api.hairpass.adapters.controllers.dtos.request.CadastroServicosRequest;
import com.api.hairpass.adapters.persistence.ServicosRepository;
import com.api.hairpass.domain.entities.ServicosEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;

@Service
public class ServicosService {

    @Autowired
    ServicosRepository servicosRepository;

    private final static String DATE_FORMAT = "dd-MM-yyyy";

    @Transactional
    public void save(CadastroServicosRequest cadastroServicosRequest) {
        ServicosEntity servicosEntity = new ServicosEntity();
        BeanUtils.copyProperties(cadastroServicosRequest, servicosEntity);

        servicosEntity.setValor(new BigDecimal(cadastroServicosRequest.getValor()));
        servicosEntity.setDuracao(new Time(Long.parseLong(cadastroServicosRequest.getDuracao())));

        LocalDate dataDeCadastro = LocalDate.now();

        servicosEntity.setDataDeCadastro(dataDeCadastro);
        servicosEntity.setServicoAtivo(true);

        servicosRepository.save(servicosEntity);
    }
}
