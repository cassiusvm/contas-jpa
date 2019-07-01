package br.eti.cvm.financas.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.eti.cvm.financas.model.Conta;

@Stateless
public class ContaService {
	@PersistenceContext(unitName = "financas")
	private EntityManager em;

	public void create(Conta conta) {
		em.persist(conta);
	}

	public Conta update(Conta conta) {
		return em.merge(conta);
	}

	public void delete(Conta conta) {
		em.remove(conta);
	}

	private Conta retrieve(Integer id) {
		return em.find(Conta.class, id);
	}
}
