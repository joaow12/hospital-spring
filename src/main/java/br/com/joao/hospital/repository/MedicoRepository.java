package br.com.joao.hospital.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joao.hospital.entity.Medicos;

public interface MedicoRepository extends JpaRepository<Medicos, Integer> {
	
	Optional<Medicos> findByCodf(Integer codf);

	List<Medicos> findByNome(String nome);

}
