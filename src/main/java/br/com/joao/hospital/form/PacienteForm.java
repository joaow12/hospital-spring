package br.com.joao.hospital.form;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.joao.hospital.entity.Pacientes;
import br.com.joao.hospital.repository.PacienteRepository;

public class PacienteForm {

	@NotBlank
	private String nome;

	@NotBlank
	@Length(max = 14, min = 11)
	private String cpf;

	@NotNull
	private LocalDate dataNascimento;

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

	public Pacientes converter(UUID id, PacienteRepository repository) {
		Optional<Pacientes> p = repository.findById(id);
		
		p.get().setNome(this.nome);
		p.get().setCpf(this.cpf);
		p.get().setDataNascimento(this.dataNascimento);
		
		return p.get();
	}

}
