package dao;

import javax.persistence.EntityManager;

import aula_devin_jpa.JPAUtil;
import dominio.Cliente;

public class ClienteDAO extends DAO<Cliente> {

	public Cliente find(Long l) {
		EntityManager entityManager = JPAUtil.entityManagerFactory.createEntityManager();
		Cliente evento = null;
		try {	
			entityManager.getTransaction().begin();
			
			evento = entityManager.find(Cliente.class, l);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
		
		return evento;
		
	}
}
