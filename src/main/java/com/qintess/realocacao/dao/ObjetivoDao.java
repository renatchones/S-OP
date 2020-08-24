package com.qintess.realocacao.dao;

import java.util.List;

import com.qintess.realocacao.domain.Java;
import com.qintess.realocacao.domain.Objetivo;

public interface ObjetivoDao {
   
	void save(Objetivo objetivo);

    void update(Objetivo objetivo);

    void delete(Long id);

    Objetivo findById(Long id);

    List<Objetivo> findAll();

}
