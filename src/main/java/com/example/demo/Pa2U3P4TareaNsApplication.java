package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.mapping.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.funcional.Main;
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
@EnableAsync
public class Pa2U3P4TareaNsApplication implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(Pa2U3P4TareaNsApplication.class);

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
		/*
		 * 
		 * // ASINCRONO FUTURO SIN RESPUESTA //Imprime el nombre del hilo con el que se
		 * ejecuta mi propgrama LOG.info("Tiempo transcurrido: " +
		 * Thread.currentThread().getName());
		 * 
		 * 
		 * long tiempoInicial = System.currentTimeMillis(); List<CuentaBancaria> lista =
		 * new ArrayList<>(); for(int i=0;i<10;i++) { CuentaBancaria cta1=new
		 * CuentaBancaria(); cta1.setNumero(String.valueOf(i)); cta1.setSaldo(new
		 * BigDecimal(50)); cta1.setTipo('A'); lista.add(cta1);
		 * this.bancariaService.guardarAsincrono(cta1); }
		 * 
		 * //lista.stream().forEach(cta -> this.bancariaService.guardar(cta)); //List
		 * <String> listaCambiada = lista.parallelStream().map(cta ->
		 * this.bancariaService.guardar2(cta)) // .collect(Collectors.toList());
		 * 
		 * //LOG.info("Se guardaron las siguientes cuentas: ");
		 * //listaCambiada.forEach(cadena -> LOG.info(cadena));
		 * 
		 * long tiempoFinal = System.currentTimeMillis(); long tiempoTranscurrido =
		 * (tiempoFinal-tiempoInicial)/1000; LOG.info("Tiempo transcurrido: " +
		 * tiempoTranscurrido); LOG.info("Tiempo transcurrido: " +
		 * (tiempoFinal-tiempoInicial));
		 * 
		 * LOG.info("Se termino de procesar todo ");
		 */

		//                     ASINCRONO FUTURO CON RESPUESTA
		
		// Imprime el nombre del hilo con el que se ejecuta mi propgrama
		LOG.info("Tiempo transcurrido: " + Thread.currentThread().getName());

		long tiempoInicial = System.currentTimeMillis();
		
		List<CuentaBancaria> lista = new ArrayList<>();
		List<CompletableFuture<String>> listaRespuestas= new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			CuentaBancaria cta1 = new CuentaBancaria();
			cta1.setNumero(String.valueOf(i));
			cta1.setSaldo(new BigDecimal(50));
			cta1.setTipo('A');
			lista.add(cta1);
			CompletableFuture<String> respuesta=this.bancariaService.guardarAsincrono2(cta1); // Una promesa que se va a completar en el Futuro
			listaRespuestas.add(respuesta);
		}
		//Senterncia que espera que termine de procesarse todos los hilos para obtener la respuesta
		CompletableFuture.allOf(listaRespuestas.get(0),listaRespuestas.get(1),listaRespuestas.get(2),listaRespuestas.get(3),listaRespuestas.get(4),
				listaRespuestas.get(5),listaRespuestas.get(6),listaRespuestas.get(7),listaRespuestas.get(8),listaRespuestas.get(9));

		LOG.info("Respuesta 0:"+ listaRespuestas.get(0).get());
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		LOG.info("Tiempo transcurrido: " + tiempoTranscurrido);
		LOG.info("Tiempo transcurrido: " + (tiempoFinal - tiempoInicial));

		LOG.info("Se termino de procesar todo ");

	}

}