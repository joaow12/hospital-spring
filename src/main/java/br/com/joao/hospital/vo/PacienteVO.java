package br.com.joao.hospital.vo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import br.com.joao.hospital.entity.Pacientes;
import br.com.joao.hospital.repository.PacienteRepository;

public class PacienteVO {

	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	List<ConsultaVO> consultas;
	
	public PacienteVO() {
	}

	public PacienteVO(Pacientes pac) {
		this.cpf = pac.getCpf();
		this.nome = pac.getNome();
		this.dataNascimento = pac.getDataNascimento();
	}

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

	public Pacientes converter(String cpf, PacienteRepository repository) {
		Optional<Pacientes> p = repository.findByCpf(cpf);
		p.get().setCpf(this.cpf);
		p.get().setNome(this.nome);
		p.get().setDataNascimento(this.dataNascimento);

		return p.get();
	}

}
