package br.com.joao.hospital.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.joao.hospital.entity.Consultas;
import br.com.joao.hospital.entity.Medicos;
import br.com.joao.hospital.entity.Pacientes;
import br.com.joao.hospital.form.PacienteForm;
import br.com.joao.hospital.repository.MedicoRepository;
import br.com.joao.hospital.repository.PacienteRepository;
import br.com.joao.hospital.vo.ConsultaVO;
import br.com.joao.hospital.vo.MedicoVO;
import br.com.joao.hospital.vo.PacienteVO;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repository;
	
	@Autowired
	private MedicoRepository medicoRepository;

	public Page<PacienteVO> buscarTodosPacientes(Pageable page) {
		return repository.findAll(page).map(this::converterPacienteEntityParaVO);
	}
	
	public Page<MedicoVO> buscarTodosMedicos(Pageable page){
		return medicoRepository.findAll(page).map(this::converterMedicoEntityParaVO);
	}

	public PacienteVO converterPacienteEntityParaVO(Pacientes paciente) {
		PacienteVO vo = new PacienteVO();
		vo.setCpf(paciente.getCpf());
		vo.setNome(paciente.getNome());
		vo.setDataNascimento(paciente.getDataNascimento());
		vo.setConsultas(paciente.getConsultas().stream().map(this::converterConsultaEntityParaVO).toList());
		return vo;
	}

	private ConsultaVO converterConsultaEntityParaVO(Consultas c) {
		ConsultaVO vo = new ConsultaVO();
		vo.setDataConsulta(c.getDataConsulta());
		vo.setHoraConsulta(c.getHorarioConsulta());
		vo.setStatusConsulta(c.getStatusConsulta());
		vo.setMedico(converterMedicoEntityParaVO(c.getMedico()));
		vo.setPaciente(converterPacienteEntityParaVO(c.getPaciente()));
		return vo;
	}

	public MedicoVO converterMedicoEntityParaVO(Medicos m) {
		MedicoVO vo = new MedicoVO();
		vo.setCodf(m.getCodf());
		vo.setNome(m.getNome());
		vo.setEspecialidade(m.getEspecialidade());
		vo.setConsultas(m.getConsultas().stream().map(this::converterConsultaEntityParaVO).toList());
		return vo;
	}

	public Pacientes atualizarCadastro(PacienteForm form, String cpf) {
		Optional<Pacientes> p = repository.findByCpf(cpf);
		if (p.isPresent()) {
			p.get().setNome(form.getNome());
			p.get().setCpf(form.getCpf());
			p.get().setDataNascimento(form.getDataNascimento());
			return p.get();
		}
		return null;

	}

	public void deletar(Integer id) {
		repository.deleteById(id);
	}
}
