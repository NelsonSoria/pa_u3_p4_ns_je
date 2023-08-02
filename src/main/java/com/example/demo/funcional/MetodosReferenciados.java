package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {
	private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class);

	public static Integer getId() {
		return 8;
	}
	public static String getIdHO() {
		LOG.info("Metodos referenciado y HO");
		return "Nelson Soria";
	}
	
	public static   void aceptar(String arg) {
		String cadena = "Nelson";
		LOG.info(cadena+ " "+ arg);
	}
	public static boolean evaluar(Integer arg) {
		
		if(arg.compareTo(100)<0) {
			return true;
		}else {
			return false;
		}
		
		
	}
}
