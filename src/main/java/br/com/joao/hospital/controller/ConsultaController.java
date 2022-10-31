package br.com.joao.hospital.controller;

import java.util.UUID;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joao.hospital.entity.Consultas;
import br.com.joao.hospital.repository.ConsultaRepository;
import br.com.joao.hospital.service.PacienteService;
import br.com.joao.hospital.vo.ConsultaVO;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
	@Autowired
	private ConsultaRepository repository;
	
	@Autowired
	private PacienteService service;

	@GetMapping
	public ResponseEntity<Page<ConsultaVO>> mostrarTudo(@PageableDefault(size = 5) Pageable page){
		return ResponseEntity.ok(service.buscarTodasConsultas(page));
	}
	
	@PostMapping
	public ResponseEntity<Consultas> cadastrar(@RequestBody Consultas consulta) {
		return ResponseEntity.ok(repository.save(consulta));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deletar(@PathVariable UUID id) {
		service.deletarConsulta(id);
		return ResponseEntity.ok(HttpStatus.OK);
	}
}
