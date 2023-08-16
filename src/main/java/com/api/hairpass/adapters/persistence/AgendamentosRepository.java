package com.api.hairpass.adapters.persistence;

import com.api.hairpass.domain.entities.AgendamentosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentosRepository extends JpaRepository<AgendamentosEntity, Long> {
}
