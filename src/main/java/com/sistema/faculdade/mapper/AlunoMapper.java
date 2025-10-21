package com.sistema.faculdade.mapper;

import com.sistema.faculdade.dto.AlunoDTO;
import com.sistema.faculdade.model.Aluno;

public class AlunoMapper {
	public static Aluno toEntity(AlunoDTO dto) {
		Aluno aluno = new Aluno();
		aluno.setId(dto.getId());
		aluno.setNome(dto.getNome());
		aluno.setEndereco(EnderecoMapper.toEntity(dto.getEndereco()));
		return aluno;
	}
	public static AlunoDTO toDTO(Aluno aluno) {
		AlunoDTO dto = new AlunoDTO();
		dto.setId(aluno.getId());
		dto.setNome(aluno.getNome());
		dto.setEndereco(EnderecoMapper.toDTO(aluno.getEndereco()));
		dto.setCursoId(aluno.getCurso().getId());
		return dto;
	}
}
