package com.sistema.faculdade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.faculdade.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> { }
