package com.example.demo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.Persona;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.repository.modelo.Transferencia;
import com.example.demo.service.FacturaService;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.IPruebaService;
import com.example.demo.service.ITransferenciaService;
import com.example.demo.service.PersonaService;

@SpringBootApplication
public class Pa2U3P4TareaNsApplication implements CommandLineRunner{
	
	@Autowired
	private ICuentaBancariaService bancariaService;
	
	@Autowired
	private IPropietarioService iPropietarioService;
	@Autowired
	private IPruebaService iPruebaService;
	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4TareaNsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Main: "+ TransactionSynchronizationManager.isActualTransactionActive());
		
		Propietario p1= new Propietario();
		p1.setApellido("Espinosa");
		p1.setCedula("415465");
		p1.setNombre("Joel");
		this.iPropietarioService.guardar(p1);
		
		
		
		
	}

}