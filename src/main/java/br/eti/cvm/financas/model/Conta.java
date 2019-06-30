package br.eti.cvm.financas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(name="SEQ_CONTAS", sequenceName="SEQ_CONTAS", initialValue = 1)
public class Conta {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_CONTAS")
	private Integer id;
	
	private String titular;
	
	private String banco;
	
	private String agencia;
	
	private String numero;
}
