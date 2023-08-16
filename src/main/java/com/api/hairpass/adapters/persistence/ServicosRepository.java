package com.api.hairpass.adapters.persistence;

import com.api.hairpass.domain.entities.ServicosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicosRepository extends JpaRepository<ServicosEntity, Long> {
}
