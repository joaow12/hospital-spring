package br.com.joao.hospital.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.joao.hospital.entity.Pacientes;

@Repository
public interface PacienteRepository extends JpaRepository<Pacientes, Integer> {
	
	Optional<Pacientes> findByCpf(String cpf);
	
	List<Pacientes> findByNome(String nome);
}
