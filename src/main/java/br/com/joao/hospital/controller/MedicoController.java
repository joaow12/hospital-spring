package br.com.joao.hospital.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
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

import br.com.joao.hospital.entity.Medicos;
import br.com.joao.hospital.form.MedicoForm;
import br.com.joao.hospital.repository.MedicoRepository;
import br.com.joao.hospital.service.PacienteService;
import br.com.joao.hospital.vo.MedicoVO;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private MedicoRepository repository;

	@Autowired
	private PacienteService service;

	@GetMapping
	public ResponseEntity<Page<MedicoVO>> mostrarTodos(@PageableDefault(size = 5) Pageable page) {
		return ResponseEntity.ok(service.buscarTodosMedicos(page));
	}

	@GetMapping("/{codf}")
	public ResponseEntity<MedicoVO> buscaPorCodf(@PathVariable Integer codf) {
		return repository.findByCodf(codf).map(m -> ResponseEntity.ok(service.mostrarMedicoVO(m)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<MedicoVO>> buscarPorNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findByNome(nome).stream().map(m -> service.mostrarMedicoVO(m)).toList());
	}
	
	@PostMapping
	public ResponseEntity<MedicoVO> cadastrar(@RequestBody Medicos medico){
		return ResponseEntity.ok(service.mostrarMedicoVO(repository.save(medico)));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<MedicoVO> atualizar(@PathVariable Integer id, @RequestBody @Valid MedicoForm form) {
		Optional<Medicos> m = repository.findById(id);
		if(m.isPresent()) {
			Medicos med = form.converter(id, repository);
			return ResponseEntity.ok(new MedicoVO(med));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deletar(@PathVariable Integer id){
		repository.deleteById(id);
		return ResponseEntity.ok(HttpStatus.OK);
	}

}
