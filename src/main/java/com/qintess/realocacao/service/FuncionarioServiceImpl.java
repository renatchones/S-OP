package com.qintess.realocacao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qintess.realocacao.dao.FuncionarioDao;
import com.qintess.realocacao.domain.Funcionario;

@Service
@Transactional(readOnly = true)
public class FuncionarioServiceImpl implements FuncionarioService {
	
	@Autowired
	private FuncionarioDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Funcionario funcionario) {
		dao.save(funcionario);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Funcionario funcionario) {
		dao.update(funcionario);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Funcionario buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override
	public List<Funcionario> buscarTodos() {
		
		return dao.findAll();
	}
	
	@Override
	public List<Funcionario> buscarPorObjetivo(String objetivo) {

		System.out.println("\n\n\n\n\n\nAlo");
		if (!objetivo.isEmpty()) {
			List<Funcionario> ret = new ArrayList<Funcionario>();
			ret = dao.findAll();
			
			for (int i = 0; i < ret.size(); i++) {
				if(consultaObjetivo(ret.get(i), objetivo) == false) {
					ret.remove(i);
				}
			}
			
			return ret;
		}
		return null;
	}
	
	private boolean consultaObjetivo(Funcionario func, String objetivo) {
		for (String st : func.getObjetivo().split(",")) {
			if(st.equals(objetivo)) {
				System.out.println(func.getNome()+" tem o objetivo solicitado.");
				return true;
			}
		}
		return false;
	}
	
	
}