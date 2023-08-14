package com.api.hairpass.adapters.persistence;

import com.api.hairpass.domain.entities.AgendamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long> {
}
