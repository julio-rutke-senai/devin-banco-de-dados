package aula_bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Gerenciamento {
	
	final static String URL = "jdbc:postgresql://127.0.0.1:5432/aula_dev_in_house";
	final static String USER = "postgres";
	final static String PASS = "postgres";
	
	public void consultar() {
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
			Connection conexao = DriverManager.getConnection(URL, USER, PASS);
			
			Statement stmt = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
			
			ResultSet result = stmt.executeQuery("SELECT "
					+ "e.nome evento, c.nome cliente, i.codigo inscricao FROM evento e "
					+ "INNER JOIN inscricao i ON i.evento = e.codigo "
					+ "INNER JOIN cliente c ON c.codigo = i.cliente");
			
			while(result.next()) {
				String evento = result.getString("evento");
				String cliente = result.getString("cliente");
				Integer codigo = result.getInt("inscricao");
				
				StringBuilder dados = new StringBuilder(cliente)
				.append(" inscrito no evento ")
				.append(evento)
				.append(" com o código ")
				.append(codigo);
				
				System.out.println(dados.toString());
	
				
			}
			
			
			
			result.close();
			
			stmt.close();
			
			conexao.close();
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void inserir(String evento) {
		try {
			Class.forName("org.postgresql.Driver");
		
		
			Connection conexao = DriverManager.getConnection(URL, USER, PASS);
			
			Statement stmt = conexao.createStatement();
			
			PreparedStatement pst = conexao.prepareStatement(
					"INSERT INTO evento (nome) VALUES (?)");
			
			pst.setString(1, evento);
			
			int linha = pst.executeUpdate();
			
			if(linha > 0)
				System.out.println("Evento Inserido com sucesso");
	
			stmt.close();
			
			conexao.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
