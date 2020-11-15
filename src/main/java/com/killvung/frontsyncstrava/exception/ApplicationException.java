package com.killvung.frontsyncstrava.exception;

import org.springframework.stereotype.Component;

@Component
public class ApplicationException {
	public static RuntimeException throwException(String messageTemplate, String... args) {
		return new RuntimeException(format(messageTemplate, args));
	}

	private static String format(String template, String... args) {
		return String.format(template, (Object[]) args);
	}
}
