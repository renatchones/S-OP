package com.qintess.realocacao.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.qintess.realocacao.domain.Python;
import com.qintess.realocacao.service.PythonService;

@Component
public class StringToPythonConverter implements Converter<String, Python> {
	
	@Autowired
	private PythonService service;

	@Override
	public Python convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
