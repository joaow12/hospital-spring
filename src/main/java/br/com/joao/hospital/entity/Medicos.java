package br.com.joao.hospital.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import br.com.joao.hospital.enums.Especialidade;

@Entity(name = "tb_medicos")
public class Medicos {

	@Id
	private UUID id = UUID.randomUUID();

	@NotBlank
	@Column(unique = true)
	private Integer codf;

	@NotBlank
	private String nome;

	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "medico")
	private List<Consultas> consultas = new ArrayList<>();

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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public List<Consultas> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consultas> consultas) {
		this.consultas = consultas;
	}

}
