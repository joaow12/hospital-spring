package br.com.joao.hospital.form;

import javax.validation.constraints.NotBlank;

import br.com.joao.hospital.enums.Especialidade;

public class MedicoForm {

	@NotBlank
	private Integer codf;

	@NotBlank
	private String nome;

	@NotBlank
	private Especialidade especialidade;

	public Integer getCodf() {
		return codf;
	}

	public void setCodf(Integer codf) {
		this.codf = codf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

}
