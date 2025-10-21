package com.sistema.faculdade.model;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "curso")
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	@ManyToMany
	@JoinTable(name = "curso_disciplina",
			joinColumns = @JoinColumn(name = "curso_id"),
			inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
	private List<Disciplina> disciplinas_curso = new ArrayList<Disciplina>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Disciplina> getDisciplinas_curso() {
		return disciplinas_curso;
	}

	public void setDisciplinas_curso(List<Disciplina> disciplinas_curso) {
		this.disciplinas_curso = disciplinas_curso;
	}
}
