package com.qintess.realocacao.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

@SuppressWarnings("serial")
@Entity
@Table(name = "OBJETIVOS")
public class Objetivo extends AbstractEntity<Long> {
	
	@Valid
	@JoinColumn
	private String nome;
	
	@OneToMany(mappedBy = "objetivo")
	private List<Funcionario> funcionarios;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	

}
