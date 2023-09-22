package com.api.hairpass.adapters.persistence;

import com.api.hairpass.domain.entities.ServicosFuncionariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicosFuncionariosRepository extends JpaRepository<ServicosFuncionariosEntity, Long> {
}
