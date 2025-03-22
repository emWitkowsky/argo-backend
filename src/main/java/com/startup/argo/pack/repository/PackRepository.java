package com.startup.argo.pack.repository;

import com.startup.argo.pack.model.Pack;
import com.startup.argo.survey.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PackRepository extends JpaRepository<Pack, UUID> {
}
