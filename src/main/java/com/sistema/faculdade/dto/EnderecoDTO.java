package com.sistema.faculdade.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class EnderecoDTO {
	private Long id;
	
	@NotBlank(message = "O CEP é obrigatório!")
	private String cep;
	
	@NotBlank(message = "A cidade é obrigatório!")
	private String cidade;
	
	@NotBlank(message = "O estado é obrigatório!")
	private String estado;
	
	@NotBlank(message = "A rua é obrigatória!")
	private String rua;
	
	@Positive(message = "O número da casa deve ser maior que zero!")
	private int numero;
	
	private String complemento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
