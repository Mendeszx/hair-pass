package com.api.hairpass.adapters.persistence;

import com.api.hairpass.domain.entities.FuncionariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosRepository extends JpaRepository<FuncionariosEntity, Long> {
}
