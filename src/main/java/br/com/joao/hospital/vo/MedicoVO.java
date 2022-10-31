package br.com.joao.hospital.vo;

import java.util.List;

import br.com.joao.hospital.entity.Medicos;
import br.com.joao.hospital.enums.Especialidade;

public class MedicoVO {

	private Integer codf;
	private String nome;
	private Especialidade especialidade;
	private List<ConsultaVO> consultas;
	
	public MedicoVO() {
	}

	public MedicoVO(Medicos med) {
		this.codf = med.getCodf();
		this.nome = med.getNome();
		this.especialidade = med.getEspecialidade();
	}

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

	public List<ConsultaVO> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<ConsultaVO> consultas) {
		this.consultas = consultas;
	}

}
