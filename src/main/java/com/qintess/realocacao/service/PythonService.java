package com.qintess.realocacao.service;

import java.util.List;

import com.qintess.realocacao.domain.Python;

public interface PythonService {

    void salvar(Python python);

    void editar(Python python);

    void excluir(Long id);

    Python buscarPorId(Long id);
    
    List<Python> buscarTodos();


}
