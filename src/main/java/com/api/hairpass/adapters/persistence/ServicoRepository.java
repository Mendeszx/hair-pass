package com.api.hairpass.adapters.persistence;

import com.api.hairpass.domain.entities.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<ServicoEntity, Long> {
}
