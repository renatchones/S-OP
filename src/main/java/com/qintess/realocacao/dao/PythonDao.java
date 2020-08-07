package com.qintess.realocacao.dao;

import java.util.List;

import com.qintess.realocacao.domain.Python;



public interface PythonDao {

    void save(Python python);

    void update(Python python);

    void delete(Long id);

    Python findById(Long id);

    List<Python> findAll();
}
