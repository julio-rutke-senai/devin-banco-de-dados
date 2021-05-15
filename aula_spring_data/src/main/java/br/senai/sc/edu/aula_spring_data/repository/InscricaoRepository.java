package br.senai.sc.edu.aula_spring_data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.senai.sc.edu.aula_spring_data.dominio.Inscricao;
import dto.ClienteEventoDTO;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
	
	@Query("Select new dto.ClienteEventoDTO(i.evento.nome, i.cliente.nome) from Inscricao i")
	List<ClienteEventoDTO> buscarClienteEvento();
	
	@Query(name = "ClienteEventoQuery", nativeQuery = true)
	List<ClienteEventoDTO> buscarClienteEventoNativo();
	

}
