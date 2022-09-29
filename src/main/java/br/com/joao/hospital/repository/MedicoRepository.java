package br.com.joao.hospital.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joao.hospital.entity.Medicos;

public interface MedicoRepository extends JpaRepository<Medicos, UUID> {

}
