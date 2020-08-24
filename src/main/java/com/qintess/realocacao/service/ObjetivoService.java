package com.qintess.realocacao.service;

import java.util.List;

import com.qintess.realocacao.domain.Java;
import com.qintess.realocacao.domain.Objetivo;

public interface ObjetivoService {
	 
		void salvar(Objetivo objetivo);

	    void editar(Objetivo objetivo);

	    void excluir(Long id);

	    Objetivo buscarPorId(Long id);
	    
	    List<Objetivo> buscarTodos();
	    
	    boolean objetivoTemFuncionarios(Long id);
	    
	}
