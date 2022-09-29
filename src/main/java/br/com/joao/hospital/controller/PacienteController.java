package br.com.joao.hospital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joao.hospital.entity.Pacientes;
import br.com.joao.hospital.form.PacienteForm;
import br.com.joao.hospital.repository.PacienteRepository;
import br.com.joao.hospital.service.PacienteService;
import br.com.joao.hospital.vo.PacienteVO;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteRepository repository;

	@Autowired
	private PacienteService service;

	@GetMapping
	public ResponseEntity<Page<PacienteVO>> mostrarTodos(@PageableDefault(size = 5) Pageable page) {
		return ResponseEntity.ok(service.buscarTodosPacientes(page));
	}

	@GetMapping("/{cpf}")
	public ResponseEntity<PacienteVO> buscarPorCPF(@PathVariable String cpf) {
		return repository.findByCpf(cpf).map(p -> ResponseEntity.ok(service.converterPacienteEntityParaVO(p)))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Pacientes>> buscarPorNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findByNome(nome));
	}

	@PostMapping
	public ResponseEntity<Pacientes> cadastrar(@RequestBody Pacientes pacientes) {
		return ResponseEntity.ok(repository.save(pacientes));
	}

	@PutMapping("/{cpf}")
	public ResponseEntity<PacienteVO> atualizar(@PathVariable String cpf, @RequestBody @Valid PacienteForm paciente) {
		service.atualizarCadastro(paciente, cpf);
		return repository.findByCpf(cpf).map(p -> ResponseEntity.ok(service.converterPacienteEntityParaVO(p)))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{cpf}")
	public ResponseEntity<HttpStatus> deletar(@PathVariable String cpf) {
		return ResponseEntity.ok(HttpStatus.OK);
	}

}
