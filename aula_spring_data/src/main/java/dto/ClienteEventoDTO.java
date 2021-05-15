package dto;

import lombok.Data;

@Data
public class ClienteEventoDTO {
	
	private String evento;
	private String cliente;
	
	public ClienteEventoDTO(String evento, String cliente) {
		super();
		this.evento = evento;
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "ClienteEventoDTO [evento=" + evento + ", cliente=" + cliente + "]";
	}
	
	
	

}
