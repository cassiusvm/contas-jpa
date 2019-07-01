package br.eti.cvm.financas.service;

import javax.ejb.Stateless;

import br.eti.cvm.financas.model.Conta;

@Stateless
public class ContaDao extends GenericDao<Conta, Integer> {

	public ContaDao() {
		super(Conta.class);
	}

}
