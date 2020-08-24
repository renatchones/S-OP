package com.qintess.realocacao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qintess.realocacao.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

	public List<Funcionario> findByObjetivo(String objetivo) {
		
		return createQuery("select f from Funcionario f where f.objetivo.nome like concat('%',?1,'%') ", objetivo);
	}
	
}