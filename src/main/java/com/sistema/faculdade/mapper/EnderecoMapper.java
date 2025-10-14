package com.sistema.faculdade.mapper;

import com.sistema.faculdade.dto.EnderecoDTO;
import com.sistema.faculdade.model.Endereco;

public class EnderecoMapper {
	public static Endereco toEntity(EnderecoDTO dto) {
		Endereco e = new Endereco();
		e.setId(dto.getId());
		e.setCep(dto.getCep());
		e.setEstado(dto.getEstado());
		e.setCidade(dto.getCidade());
		e.setRua(dto.getRua());
		e.setNumero(dto.getNumero());
		e.setComplemento(dto.getComplemento());
		return e;
	}
	public static EnderecoDTO toDTO(Endereco e) {
		EnderecoDTO dto = new EnderecoDTO();
		dto.setId(e.getId());
		dto.setCep(e.getCep());
		dto.setEstado(e.getEstado());
		dto.setCidade(e.getCidade());
		dto.setRua(e.getRua());
		dto.setNumero(e.getNumero());
		dto.setComplemento(e.getComplemento());
		return dto;
	}
}
