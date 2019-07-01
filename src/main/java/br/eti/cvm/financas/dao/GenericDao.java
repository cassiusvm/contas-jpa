package br.eti.cvm.financas.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.Valid;

public abstract class GenericDao<T, I extends Serializable> {

	@PersistenceContext(unitName = "financas")
	protected EntityManager em;

	private Class<T> persistedClass;

	protected GenericDao() {
	}

	protected GenericDao(Class<T> persistedClass) {
		this();
		this.persistedClass = persistedClass;
	}

	public T salvar(@Valid T entity) {
		em.persist(entity);
		return entity;
	}

	public T atualizar(@Valid T entity) {
		return em.merge(entity);
	}

	public void remover(@Valid T entity) {
		em.remove(entity);
	}

	public List<T> listaTodos() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		return em.createQuery(query).getResultList();
	}

	public T encontrar(I id) {
		return em.find(persistedClass, id);
	}
	
}