package com.qintess.realocacao.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.qintess.realocacao.domain.Funcionario;
import com.qintess.realocacao.service.FuncionarioService;

@Component
public class StringToFuncionarioConversor implements Converter<String, Funcionario> {

	@Autowired
	private FuncionarioService service;
	
	@Override
	public Funcionario convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
}
