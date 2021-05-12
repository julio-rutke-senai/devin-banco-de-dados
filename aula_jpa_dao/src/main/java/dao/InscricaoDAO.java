package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import aula_devin_jpa.JPAUtil;
import dominio.Inscricao;
import dto.ClienteDTO;

public class InscricaoDAO extends DAO<Inscricao> {
	
	public List<Inscricao> findAll(){
		EntityManager entityManager = JPAUtil.entityManagerFactory.createEntityManager();
		
		List<Inscricao> lista = new ArrayList<>();
		
		try {
			
			entityManager.getTransaction().begin();
			
			lista = entityManager.createQuery(""
					+ "SELECT e.nome, i.codigo, i.valor from Evento e JOIN e.inscricoes i ")
					.getResultList();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
		
		return lista;		
	}
	
	public List<Long> findAllCodigos(){
		EntityManager entityManager = JPAUtil.entityManagerFactory.createEntityManager();
		
		List<Long> lista = new ArrayList<>();
		
		try {
			
			entityManager.getTransaction().begin();
			
			lista = entityManager.createQuery(""
					+ "SELECT i.codigo from Evento e JOIN e.inscricoes i ")
					.getResultList();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
		
		return lista;		
	}
	

	public List<ClienteDTO> findAllClientes(){
		EntityManager entityManager = JPAUtil.entityManagerFactory.createEntityManager();
		
		List<ClienteDTO> lista = new ArrayList<>();
		
		try {
			
			entityManager.getTransaction().begin();
			
			lista = entityManager.createQuery(""
					+ "SELECT new dto.ClienteDTO(i.cliente.nome, i.evento.nome, i.valor) from Inscricao i")
					.getResultList();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
		
		return lista;		
	}

}
