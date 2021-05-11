package aula_devin_jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import dominio.Evento;

public class Aplicacao {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("aula_jpa");
		
		EntityManager entityManager = emf.createEntityManager();
		
		//Evento evento;
		//evento.setCodigo(1L);
		
		List<Evento> eventos = new ArrayList<>();
		
		entityManager.getTransaction().begin();
		
		//entityManager.merge(evento);
		
		//entityManager.persist(evento);
		
//		eventos = entityManager.createQuery(
//				"from Evento e where e.nome like '%in%'").getResultList();
		
		TypedQuery<Evento> query = entityManager.createQuery(
				"from Evento e where e.nome like :nome", Evento.class);
		
		query.setParameter("nome", "%in%");
		
		eventos = query.getResultList();
		
		//entityManager.remove(evento);
		
		//entityManager.getTransaction().commit();
		
		entityManager.close();
		
		//System.out.println(evento);
		
		//eventos.forEach(System.out::println);
		
		for (Evento evento : eventos) {
			System.out.println(evento);
		}

	}

}
