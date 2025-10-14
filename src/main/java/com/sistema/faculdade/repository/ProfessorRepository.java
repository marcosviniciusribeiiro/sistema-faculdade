package com.sistema.faculdade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.faculdade.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> { }
