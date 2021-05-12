package dao;

import javax.persistence.EntityManager;

import aula_devin_jpa.JPAUtil;

public class DAO<T> implements IDao<T> {

	@Override
	public void inserir(T objeto) {
		EntityManager entityManager = JPAUtil.entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(objeto);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();	
	}

	@Override
	public void alterar(T objeto) {
		EntityManager entityManager = JPAUtil.entityManagerFactory.createEntityManager();
		try {	
			entityManager.getTransaction().begin();
			
			entityManager.merge(objeto);
			
			entityManager.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}finally {
			entityManager.close();
		}
		
}


}
