package aula_jdbc;

import java.util.List;

public class EventoService {
	
	private EventoDAO dao;
	private Conexao conexao;
	
	public EventoService() {
		dao = new EventoDAO();
		conexao = new Conexao();
	}
	
	public String inserirEvento(Evento evento) {
		
		dao.setEvento(evento);
		dao.setConexao(conexao);
		
		try {
			
			conexao.conecta();
			
			if(dao.inserir()) {
				conexao.confirmarTransacao();
			}else {
				conexao.cancelarTransacao();
			}
			
			conexao.fechar();	
			
			return "Evento Inserido com Sucesso";					
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
	}
	
	public String atualizarEvento(Evento evento) {
		
		dao.setEvento(evento);
		dao.setConexao(conexao);
		
		try {
			conexao.conecta();
			
			if(dao.atualizar()) {
				conexao.confirmarTransacao();
			} else {
				conexao.cancelarTransacao();
			}
			
			conexao.fechar();
			
			return "Evento atualizado com Sucesso";
			
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
	}
	
	public List<Evento> listarTodos(){
		
		dao.setConexao(conexao);
		
		try {
			conexao.conecta();
			
			List<Evento> e = dao.buscarTodos();
			
			conexao.fechar();
			
			return e;		
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
