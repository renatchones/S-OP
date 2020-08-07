package com.qintess.realocacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qintess.realocacao.dao.PythonDao;
import com.qintess.realocacao.domain.Java;
import com.qintess.realocacao.domain.Python;

@Service
public class PythonServiceImpl implements PythonService {
	
	@Autowired
	private PythonDao dao;


	@Transactional(readOnly = false)
	@Override
	public void salvar(Python python) {
		dao.save(python);	
		
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Python python) {
		dao.update(python);	
		
	}
	
	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Transactional(readOnly = true)
	@Override
	public Python buscarPorId(Long id) {
		return dao.findById(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Python> buscarTodos() {
		
		return dao.findAll();
	}


}
