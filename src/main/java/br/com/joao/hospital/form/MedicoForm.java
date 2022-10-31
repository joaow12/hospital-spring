package br.com.joao.hospital.form;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import br.com.joao.hospital.entity.Medicos;
import br.com.joao.hospital.entity.Pacientes;
import br.com.joao.hospital.enums.Especialidade;
import br.com.joao.hospital.repository.MedicoRepository;

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

	public Medicos converter(Integer id, MedicoRepository repository) {
		Optional<Medicos> m = repository.findById(id);

		m.get().setNome(this.nome);
		m.get().setCodf(this.codf);
		m.get().setEspecialidade(this.especialidade);

		return m.get();
	}

}
