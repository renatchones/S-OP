package com.qintess.realocacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qintess.realocacao.dao.JavaDao;
import com.qintess.realocacao.domain.Java;

@Service
public class JavaServiceImpl implements JavaService {
	
	@Autowired
	private JavaDao dao;


	@Transactional(readOnly = false)
	@Override
	public void salvar(Java java) {
		dao.save(java);	
		
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Java java) {
		dao.update(java);	
		
	}
	
	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Transactional(readOnly = true)
	@Override
	public Java buscarPorId(Long id) {
		return dao.findById(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Java> buscarTodos() {
		
		return dao.findAll();
	}


}
