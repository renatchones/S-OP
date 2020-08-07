package com.qintess.realocacao.service;

import java.util.List;

import com.qintess.realocacao.domain.Java;

public interface JavaService {

    void salvar(Java java);

    void editar(Java java);

    void excluir(Long id);

    Java buscarPorId(Long id);
    
    List<Java> buscarTodos();


}
