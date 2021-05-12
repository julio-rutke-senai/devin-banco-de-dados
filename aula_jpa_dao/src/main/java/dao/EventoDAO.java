package dao;

import javax.persistence.EntityManager;

import aula_devin_jpa.JPAUtil;
import dominio.Evento;

public class EventoDAO extends DAO<Evento> {


	public void remover(Evento objeto) {
		EntityManager entityManager = JPAUtil.entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		objeto = entityManager.find(Evento.class, objeto.getCodigo());
		
		entityManager.remove(objeto);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();	
	}
	
	public Evento find(Long l) {
		EntityManager entityManager = JPAUtil.entityManagerFactory.createEntityManager();
		Evento evento = null;
		try {	
			entityManager.getTransaction().begin();
			
			evento = entityManager.find(Evento.class, l);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
		
		return evento;
		
	}
	
	

}
