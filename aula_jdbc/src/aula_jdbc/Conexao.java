package aula_jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	final static String URL = "jdbc:postgresql://127.0.0.1:5432/aula_dev_in_house";	
	final static String USER = "postgres";
	final static String PASS = "postgres";

    private static Connection conexao;

    public boolean conecta() throws Exception {
        try {
            if (conexao != null && !conexao.isClosed()) {
                return true;
            }
            Class.forName("org.postgresql.Driver");

            conexao = DriverManager.getConnection(URL , USER, PASS);
//                    
            conexao.setAutoCommit(false);
            conexao.setTransactionIsolation(
                    Connection.TRANSACTION_READ_COMMITTED);
        } catch (ClassNotFoundException cnf) {
            throw new Exception("Driver não encontrado!");
        } catch (SQLException sql) {
            throw new Exception("Falha ocorrida: " + sql.getMessage());
        }
        return true;
    }

    public boolean conecta(String ip, String banco, String user, String pass) throws Exception {
        try {
            if (conexao != null && !conexao.isClosed()) {
                return true;
            }
            Class.forName("org.postgresql.Driver");
            StringBuilder url = new StringBuilder("jdbc:postgresql://");
            url.append(ip).append("/").append(banco);
            conexao = DriverManager.getConnection(url.toString() , user, pass);
//                    
            conexao.setAutoCommit(false);
            conexao.setTransactionIsolation(
                    Connection.TRANSACTION_READ_COMMITTED);
        } catch (ClassNotFoundException cnf) {
            throw new Exception("Driver não encontrado!");
        } catch (SQLException sql) {
            throw new Exception("Falha ocorrida: " + sql.getMessage());
        }
        return true;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void fechar() throws Exception {
        try {
            if (conexao == null || conexao.isClosed()) {
                return;
            }
            conexao.close();
        } catch (SQLException sql) {
            throw new Exception("Falha ocorrida: " + sql.getMessage());
        }
    }

    public void confirmarTransacao() throws Exception {
        try {
            if (conexao == null || conexao.isClosed()) {
                return;
            }
            conexao.commit();
        } catch (SQLException sql) {
            throw new Exception("Falha ocorrida: " + sql.getMessage());
        }
    }

    public void cancelarTransacao() throws Exception {
        try {
            if (conexao == null || conexao.isClosed()) {
                return;
            }
            conexao.rollback();
        } catch (SQLException sql) {
            throw new Exception("Falha ocorrida: " + sql.getMessage());
        }
    }
}