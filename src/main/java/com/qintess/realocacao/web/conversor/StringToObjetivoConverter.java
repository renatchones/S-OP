package com.qintess.realocacao.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.qintess.realocacao.domain.Objetivo;
import com.qintess.realocacao.service.ObjetivoService;

@Component
public class StringToObjetivoConverter implements Converter<String, Objetivo> {
	
	@Autowired
	private ObjetivoService service;

	@Override
	public Objetivo convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
