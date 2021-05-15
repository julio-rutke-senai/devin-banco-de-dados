package br.senai.sc.edu.aula_spring_data;

import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import br.senai.sc.edu.aula_spring_data.dominio.Evento;
import br.senai.sc.edu.aula_spring_data.repository.EventoRepository;
import br.senai.sc.edu.aula_spring_data.repository.InscricaoRepository;
import dto.ClienteEventoDTO;

@SpringBootApplication
public class AulaSpringDataApplication implements CommandLineRunner{
	
	@Autowired
	EventoRepository eventoRepository;
	
	@Autowired
	InscricaoRepository inscricaoRepository;

	public static void main(String[] args) {
		SpringApplication.run(AulaSpringDataApplication.class, args);
	}
	
	@Override
	public void run(String... args) {
		
		//List<Evento> lista = eventoRepository.findAll();
		
		//List<Evento> lista = eventoRepository.nomeContainingOrderByNomeDesc("in");
		
		//Evento evento = new Evento("Aglomeration 2022");
		
//		Evento evento = eventoRepository.codigo(3L);
//		
//		evento.setNome("Vacination Now");
//		
//		eventoRepository.save(evento);
//		
//		Evento e1 = new Evento("Evento 1");
//		Evento e2 = new Evento("Evento 2");
//		Evento e3 = new Evento("Evento 3");
//		
//		eventoRepository.saveAll(Arrays.asList(e1, e2, e3));
		
		//List<Evento> lista = eventoRepository.buscaPorNome("%Evento%");
		
//		Order order = new Order
//		
//		Page<Evento> lista = eventoRepository.findAll(PageRequest.of(0, 3));
		
		
		//int count = eventoRepository.countEvento();
		
//		System.out.println("++++++++++++++++");
		
//		System.out.println(count);
//
//		System.out.println("+++++++ Página 1 +++++++++");
//		
//		lista.forEach(System.out::println);
//		
//
//		System.out.println("+++++++++ Página 2 +++++++");
//		
//		lista = eventoRepository.findAll(PageRequest.of(1, 3));
//		
//		lista.forEach(System.out::println);
//		
//
//		System.out.println("+++++++ Página 3 +++++++++");
//
//		lista = eventoRepository.findAll(PageRequest.of(2, 3));
//		
//		lista.forEach(System.out::println);
//		
//
//
//		System.out.println("+++++++ Página 4 +++++++++");
//
//		lista = eventoRepository.findAll(PageRequest.of(3, 3));
		
		List<ClienteEventoDTO> lista = inscricaoRepository.buscarClienteEventoNativo();
		
		lista.forEach(System.out::println);
		
	}

}
