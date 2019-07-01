package br.eti.cvm.financas.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.eti.cvm.financas.model.Conta;
import br.eti.cvm.financas.service.ContaService;
import lombok.Getter;

@Named
@ViewScoped
public class UmaContaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private ContaService contaService;
	
	@Getter
	private Conta conta = new Conta();
	
	@PostConstruct
	private void init() {
		conta.setTitular("Uma Pessoa");
		conta.setAgencia("999");
		conta.setBanco("999");
		conta.setNumero("999");
		
		contaService.create(conta);
	}
	
}
