package br.com.joao.hospital.vo;

import java.time.LocalDate;
import java.util.List;

public class PacienteVO {

	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	List<ConsultaVO> consultas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<ConsultaVO> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<ConsultaVO> consultas) {
		this.consultas = consultas;
	}

}
