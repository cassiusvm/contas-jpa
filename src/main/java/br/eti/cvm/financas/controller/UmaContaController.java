package br.eti.cvm.financas.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import br.eti.cvm.financas.model.Conta;
import lombok.Getter;

@Named
@ViewScoped
public class UmaContaController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private EntityManager em;
	
	@Getter
	private Conta conta = new Conta();
	
	
	@PostConstruct
	@Transactional
	private void init() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("financas");
		em = entityManagerFactory.createEntityManager();
		
		conta.setTitular("Uma Pessoa");
		conta.setAgencia("999");
		conta.setBanco("999");
		conta.setNumero("999");
		
		em.persist(conta);
	}
	
}
