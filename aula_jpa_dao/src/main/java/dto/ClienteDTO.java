package dto;

public class ClienteDTO {
	
	String nome;
	String evento;
	Double valor;
	
	
	public ClienteDTO(String nome, String evento, Double valor) {
		super();
		this.nome = nome;
		this.evento = evento;
		this.valor = valor;
	}


	@Override
	public String toString() {
		return "ClienteDTO [nome=" + nome + ", evento=" + evento + ", valor=" + valor + "]";
	}
	
	
	
	

}
