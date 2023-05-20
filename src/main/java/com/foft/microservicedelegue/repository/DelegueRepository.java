package com.foft.microservicedelegue.repository;

import com.foft.microservicedelegue.modele.Delegue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DelegueRepository extends JpaRepository<Delegue, Integer> {
}
