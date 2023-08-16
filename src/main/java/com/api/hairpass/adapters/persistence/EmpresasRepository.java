package com.api.hairpass.adapters.persistence;

import com.api.hairpass.domain.entities.EmpresasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresasRepository extends JpaRepository<EmpresasEntity, Long> {
}
