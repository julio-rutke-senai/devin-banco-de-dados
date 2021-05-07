package aula_jdbc;

import java.util.List;

public class Main {

	public static void main(String[] args) {
//		Gerenciamento ger = new Gerenciamento();
//
//		//ger.inserir("Rock in Rio");
//		
//		ger.consultar();
		
		Evento evento = new Evento();
		evento.setNome("Dev in House Summit");
		evento.setCodigo(6);
		
		EventoService servico = new EventoService();
		//String mensagem = servico.atualizarEvento(evento);
		//String mensagem = servico.inserirEvento(evento);
		List<Evento> eventos = servico.listarTodos();
		
		for (Evento e : eventos) {
			StringBuilder message = new StringBuilder(e.getCodigo()+"")
					.append(" - ").append(e.getNome());
			System.out.println(message);
		}
		
		
		//System.out.println(mensagem);
		

	}

}
