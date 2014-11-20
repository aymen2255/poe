package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.treeptik.dao.Genericdao;

public class GenericDaoImpl<T,PK> implements Genericdao<T, PK> {
	
	protected Class<T> entityClass;
	
	@PersistenceContext
	protected EntityManager em;

	public GenericDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	
	public T create(T t) {
		this.em.persist(t);
		return t;
	}
	public T findById(PK id) {
		
		return this.em.find(entityClass, id);
		
	}

	public T update(T t) {
		return em.merge(t);
		
	}
	public void delete(T t) {
		this.em.remove(t);
		
	}
	public List<T> findAll(Class entityClass) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
