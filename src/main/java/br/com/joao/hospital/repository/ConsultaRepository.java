package br.com.joao.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joao.hospital.entity.Consultas;

public interface ConsultaRepository extends JpaRepository<Consultas, Long>{

}
