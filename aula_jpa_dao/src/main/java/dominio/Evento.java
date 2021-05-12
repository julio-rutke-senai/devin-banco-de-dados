package dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
//@Entity(name="eventos") *** Para usar um nome da tabela diferente da classe
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column
	private String nome;
	
	@OneToMany(mappedBy = "evento")
	List<Inscricao> inscricoes;
	
	public Evento() {
		
	}
	
	public Evento(String evento) {
		this.nome = evento;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Evento [codigo=" + codigo + ", nome=" + nome + "]";
	}
	
	
	
	

}
