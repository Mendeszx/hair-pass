package com.api.hairpass.adapters.persistence;

import com.api.hairpass.domain.entities.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {
}
