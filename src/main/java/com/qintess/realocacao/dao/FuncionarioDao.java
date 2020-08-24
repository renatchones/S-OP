package com.qintess.realocacao.dao;

import java.util.List;

import com.qintess.realocacao.domain.Funcionario;

public interface FuncionarioDao {
    
	void save(Funcionario funcionario);

    void update(Funcionario funcionario);

    void delete(Long id);

    Funcionario findById(Long id);

    List<Funcionario> findAll();
    
    List<Funcionario> findByObjetivo(String objetivo);
    

}
