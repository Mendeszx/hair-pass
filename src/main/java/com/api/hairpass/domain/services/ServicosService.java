package com.api.hairpass.domain.services;

import com.api.hairpass.adapters.controllers.dtos.request.CadastroServicoRequest;
import com.api.hairpass.adapters.persistence.ServicosRepository;
import com.api.hairpass.domain.entities.EmpresasEntity;
import com.api.hairpass.domain.entities.ServicosEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class ServicosService {

    @Autowired
    ServicosRepository servicosRepository;

    private final static String DATE_FORMAT = "dd-MM-yyyy";

    @Transactional
    public void criarNovoServicoParaEmpresa(CadastroServicoRequest cadastroServicoRequest, EmpresasEntity empresasEntity) {
        ServicosEntity servicosEntity = new ServicosEntity();
        BeanUtils.copyProperties(cadastroServicoRequest, servicosEntity);

        servicosEntity.setEmpresaId(empresasEntity);
        servicosEntity.setValor(new BigDecimal(cadastroServicoRequest.getValor()));
        servicosEntity.setDuracao(Time.valueOf(cadastroServicoRequest.getDuracao()));

        LocalDate dataDeCadastro = LocalDate.now();

        servicosEntity.setDataDeCadastro(dataDeCadastro);
        servicosEntity.setServicoAtivo(true);

        servicosEntity = servicosRepository.save(servicosEntity);
    }

    public ServicosEntity findServicosById(String servicoId) {
        Optional<ServicosEntity> entity = servicosRepository.findById(Long.valueOf(servicoId));

        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new RuntimeException("Serviço não encontrado.");
        }
    }
}
