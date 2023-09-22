package com.api.hairpass.adapters.persistence;

import com.api.hairpass.domain.entities.FuncionariosEmpresasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionariosEmpresasRepository extends JpaRepository<FuncionariosEmpresasEntity, Long> {
}
