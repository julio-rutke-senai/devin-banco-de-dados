package aula_jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO implements IGerenciamentoDAO {
	
	private Evento evento;
	private Conexao conexao;

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}	
	
	public Conexao getConexao() {
		return conexao;
	}

	public void setConexao(Conexao conexao) {
		this.conexao = conexao;
	}

	@Override
	public boolean inserir() {
		try {
			PreparedStatement pst = this.conexao.getConexao()
					.prepareStatement("INSERT INTO evento (nome) VALUES (?)");

			pst.setString(1, evento.getNome());
			
			pst.executeUpdate();
			
			pst.close();
			
			return true;
	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean atualizar() {	
		try {		
			PreparedStatement pst = conexao.getConexao()
					.prepareStatement("UPDATE evento SET nome = ? WHERE codigo = ?");
			
			pst.setString(1, evento.getNome());
			pst.setInt(2, evento.getCodigo());
			
			pst.executeUpdate();
			
			pst.close();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean excluir() {
		try {
			PreparedStatement pst = conexao.getConexao()
					.prepareStatement("DELETE FROM evento WHERE codigo = ?");
			
			pst.setInt(1, evento.getCodigo());
			
			int linha = pst.executeUpdate();
			
			if(linha > 0)
				System.out.println("Evento alterado com sucesso");
			
			pst.close();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Evento> buscarTodos(){
		try {
			PreparedStatement pst = conexao.getConexao()
					.prepareStatement("SELECT * FROM evento");
			
			ResultSet result = pst.executeQuery();
			
			List<Evento> lista = new ArrayList<>();
			
			while(result.next()) {
				Evento e = new Evento();
				
				e.setCodigo(result.getInt("codigo"));
				e.setNome(result.getString("nome"));
				
				lista.add(e);
			}
			
			result.close();
			
			pst.close();
			
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
