package com.qintess.realocacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qintess.realocacao.dao.ObjetivoDao;
import com.qintess.realocacao.domain.Java;
import com.qintess.realocacao.domain.Objetivo;

@Service
public class ObjetivoServiceImpl implements ObjetivoService {
	
	@Autowired
	private ObjetivoDao dao;


	@Transactional(readOnly = false)
	@Override
	public void salvar(Objetivo objetivo) {
		dao.save(objetivo);	
		
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Objetivo objetivo) {
		dao.update(objetivo);	
		
	}
	
	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Transactional(readOnly = true)
	@Override
	public Objetivo buscarPorId(Long id) {
		return dao.findById(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Objetivo> buscarTodos() {
		
		return dao.findAll();
	}
	
	@Override
	public boolean objetivoTemFuncionarios(Long id) {
		if (buscarPorId(id).getFuncionarios().isEmpty()) {
			return false;
		}
		return true;
	}


}