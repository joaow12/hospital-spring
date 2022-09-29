package br.com.joao.hospital.form;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotBlank;

public class ConsultaForm {

	@NotBlank
	private LocalDate dataConsulta;

	@NotBlank
	private LocalTime horarioConsulta;

	@NotBlank
	private String paciente;

	@NotBlank
	private String medico;

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

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

}
