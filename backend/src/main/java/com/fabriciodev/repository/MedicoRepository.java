package com.fabriciodev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fabriciodev.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}
