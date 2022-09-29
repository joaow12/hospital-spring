package br.com.joao.hospital.vo;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.joao.hospital.enums.StatusConsulta;

public class ConsultaVO {

	private LocalDate dataConsulta;
	private LocalTime horaConsulta;
	private StatusConsulta statusConsulta;
	private MedicoVO medico;
	private PacienteVO paciente;

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public LocalTime getHoraConsulta() {
		return horaConsulta;
	}

	public void setHoraConsulta(LocalTime horaConsulta) {
		this.horaConsulta = horaConsulta;
	}

	public StatusConsulta getStatusConsulta() {
		return statusConsulta;
	}

	public void setStatusConsulta(StatusConsulta statusConsulta) {
		this.statusConsulta = statusConsulta;
	}

	public MedicoVO getMedico() {
		return medico;
	}

	public void setMedico(MedicoVO medico) {
		this.medico = medico;
	}

	public PacienteVO getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteVO paciente) {
		this.paciente = paciente;
	}

}
