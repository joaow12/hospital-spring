package br.com.joao.hospital.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import br.com.joao.hospital.enums.StatusConsulta;

@Entity(name = "tb_consultas")
public class Consultas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotBlank
	private LocalDate dataConsulta;

	@NotBlank
	private LocalTime horarioConsulta;

	@Enumerated(EnumType.STRING)
	private StatusConsulta statusConsulta = StatusConsulta.MARCADA;

	@ManyToOne
	private Medicos medico;

	@ManyToOne
	private Pacientes paciente;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public LocalTime getHorarioConsulta() {
		return horarioConsulta;
	}

	public void setHorarioConsulta(LocalTime horarioConsulta) {
		this.horarioConsulta = horarioConsulta;
	}

	public Medicos getMedico() {
		return medico;
	}

	public void setMedico(Medicos medico) {
		this.medico = medico;
	}

	public Pacientes getPaciente() {
		return paciente;
	}

	public void setPaciente(Pacientes paciente) {
		this.paciente = paciente;
	}

	public StatusConsulta getStatusConsulta() {
		return statusConsulta;
	}

	public void setStatusConsulta(StatusConsulta statusConsulta) {
		this.statusConsulta = statusConsulta;
	}

}
