package com.desafio.fluig.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LocalDateFluigDeserializer extends JsonDeserializer<LocalDate> {
	
	private static final DateTimeFormatter formatterDiaMesAno = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Override
	public LocalDate deserialize(JsonParser parser, DeserializationContext contexto) throws IOException, JacksonException {
		String date = parser.getValueAsString();
		return LocalDate.parse(date, formatterDiaMesAno);
	}

}
