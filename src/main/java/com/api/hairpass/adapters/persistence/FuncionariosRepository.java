package com.api.hairpass.adapters.persistence;

import com.api.hairpass.domain.entities.FuncionariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionariosRepository extends JpaRepository<FuncionariosEntity, Long> {
    Optional<FuncionariosEntity> findByCpf(String funcionarioCPF);
}
