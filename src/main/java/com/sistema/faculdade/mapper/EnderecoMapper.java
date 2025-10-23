package com.sistema.faculdade.mapper;

import com.sistema.faculdade.dto.EnderecoDTO;
import com.sistema.faculdade.model.Endereco;

public class EnderecoMapper {
	public static Endereco toEntity(EnderecoDTO dto) {
		Endereco endereco = new Endereco();
		endereco.setId(dto.getId());
		endereco.setCep(dto.getCep());
		endereco.setEstado(dto.getEstado());
		endereco.setCidade(dto.getCidade());
		endereco.setRua(dto.getRua());
		endereco.setNumero(dto.getNumero());
		endereco.setComplemento(dto.getComplemento());
		return endereco;
	}
	public static EnderecoDTO toDTO(Endereco endereco) {
		if(endereco == null) {
			return null;
		}
		
		EnderecoDTO dto = new EnderecoDTO();
		dto.setId(endereco.getId());
		dto.setCep(endereco.getCep());
		dto.setEstado(endereco.getEstado());
		dto.setCidade(endereco.getCidade());
		dto.setRua(endereco.getRua());
		dto.setNumero(endereco.getNumero());
		dto.setComplemento(endereco.getComplemento());
		return dto;
	}
}