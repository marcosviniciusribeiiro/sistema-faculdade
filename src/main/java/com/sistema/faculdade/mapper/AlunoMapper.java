package com.sistema.faculdade.mapper;

import com.sistema.faculdade.dto.AlunoDTO;
import com.sistema.faculdade.model.Aluno;

public class AlunoMapper {
	public static Aluno toEntity(AlunoDTO dto) {
		Aluno a = new Aluno();
		a.setMatricula(dto.getMatricula());
		a.setNome(dto.getNome());
		a.setEndereco(dto.getEndereco());
		a.setCurso(dto.getCurso());
		return a;
	}
	public static AlunoDTO toDTO(Aluno a) {
		AlunoDTO dto = new AlunoDTO();
		dto.setMatricula(a.getMatricula());
		dto.setNome(a.getNome());
		dto.setEndereco(a.getEndereco());
		dto.setCurso(a.getCurso());
		return dto;
	}
}
