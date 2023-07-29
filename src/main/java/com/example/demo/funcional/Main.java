package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPersona per = new PersonaImpl();
		per.caminar();
		// 1. Supplier

		// Clases:

		IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
		LOG.info("Supplier clase:" + supplier1.getId());

		// Lambdas
		IPersonaSupplier<String> supplier2 = () -> "17522859486";
		LOG.info("Supplier clase:" + supplier2.getId());

		IPersonaSupplier<String> supplier3 = () -> {
			String cedula = "1564156";
			cedula = cedula + "zzzzzzzzzz";
			return cedula;
		};
		LOG.info("Supplier clase:" + supplier3.getId());
	}

}
