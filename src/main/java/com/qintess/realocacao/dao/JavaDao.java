package com.qintess.realocacao.dao;

import java.util.List;

import com.qintess.realocacao.domain.Java;



public interface JavaDao {

    void save(Java java);

    void update(Java java);

    void delete(Long id);

    Java findById(Long id);

    List<Java> findAll();
}
