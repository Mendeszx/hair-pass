package com.api.hairpass.adapters.persistence;

import com.api.hairpass.domain.entities.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Long> {
    Optional<UsuariosEntity> findByEmail(String email);
}
