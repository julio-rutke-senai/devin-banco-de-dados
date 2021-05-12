package aula_devin_jpa;

import java.util.List;

import dao.ClienteDAO;
import dao.EventoDAO;
import dao.InscricaoDAO;
import dominio.Cliente;
import dominio.Evento;
import dominio.Inscricao;
import dto.ClienteDTO;

public class Aplicacao {

	public static void main(String[] args) {
		EventoDAO eventoDAO = new EventoDAO();
		
		//Evento evento = new Evento("Aglomeration 2021");
		
		//eventoDAO.inserir(evento);
		
		//evento.setCodigo(7L);
		//evento.setNome("Vacination 2021");
		
//		eventoDAO.alterar(evento);
		
//		evento.setCodigo(9L);
//		
//		eventoDAO.remover(evento);
		
		//Evento evento = eventoDAO.find(5L);
		
		ClienteDAO clienteDAO = new ClienteDAO();
//
//		Cliente cliente = new Cliente();
//		cliente.setNome("Maria");
//		cliente.setCpf("000");
//		cliente.setEmail("maria@senai");
//		cliente.setRg("0102");
//		cliente.setSenha("pass");
//		cliente.setTelefone("0974");
//		
//		clienteDAO.inserir(cliente);
		
		
		InscricaoDAO inscricaoDAO = new InscricaoDAO();

//		Evento evento;
//		Cliente cliente;
//		
//		evento = eventoDAO.find(8L);
//		cliente = clienteDAO.find(1L);
//		
//		Inscricao insc = new Inscricao();
//		insc.setCliente(cliente);
//		insc.setEvento(evento);
//		insc.setValor(130.00);
//		insc.setParcela(1);
//		insc.setObservacao("Nada");
//		
//		inscricaoDAO.inserir(insc);
//		
//		List<Inscricao> lista = inscricaoDAO.findAll();
//		
//		for (Inscricao inscricao : lista) {
//			System.out.println(inscricao);
//		}
		

		List<ClienteDTO> lista = inscricaoDAO.findAllClientes();
		
		for (ClienteDTO inscricao : lista) {
			System.out.println(inscricao);
		}
		
		
//		System.out.println(cliente);

	}

}
