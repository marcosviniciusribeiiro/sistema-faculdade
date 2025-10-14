package com.sistema.faculdade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.faculdade.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> { }
