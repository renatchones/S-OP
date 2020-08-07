package com.qintess.realocacao.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.qintess.realocacao.domain.Java;
import com.qintess.realocacao.service.JavaService;

@Component
public class StringToJavaConverter implements Converter<String, Java> {
	
	@Autowired
	private JavaService service;

	@Override
	public Java convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
