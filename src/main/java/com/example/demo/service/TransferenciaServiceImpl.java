package com.example.demo.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICuentaBancariaRepository;
import com.example.demo.repository.ITransferenciaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{

	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	@Override
	public void buscar(Transferencia transferencia) {
		this.iTransferenciaRepository.insertar(transferencia);
		
	}

	@Override
	public void borrar(Integer id) {
		this.iTransferenciaRepository.eliminar(id);
		
	}

	@Override
	public Transferencia buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.seleccionarPorId(id);
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		this.iTransferenciaRepository.actualizar(transferencia);
		
	}

	@Override
	public List<Transferencia> reporte() {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.seleccionarTodos();
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void realizarTransferencia(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		CuentaBancaria ctaOrigen=this.bancariaRepository.seleccionarPorNumero(numeroCtaOrigen);
		CuentaBancaria ctaDestino=this.bancariaRepository.seleccionarPorNumero(numeroCtaDestino);
		
		BigDecimal saldoOrigen=ctaOrigen.getSaldo();
		BigDecimal saldoDestino=ctaDestino.getSaldo();
		
			ctaOrigen.setSaldo(saldoOrigen.subtract(monto));
			ctaDestino.setSaldo(saldoDestino.add(monto));
			this.bancariaRepository.actualizar(ctaOrigen);
			this.bancariaRepository.actualizar(ctaDestino);
			
			Transferencia miTransferencia = new Transferencia();
			miTransferencia.setFecha(LocalDateTime.now());
			miTransferencia.setMonto(monto);
			miTransferencia.setCuentaOrigen(ctaOrigen);
			miTransferencia.setCuentaDestino(ctaDestino);
			
			this.iTransferenciaRepository.insertar(miTransferencia);
			BigDecimal saldo=ctaOrigen.getSaldo();
			
			if(saldo.compareTo(new BigDecimal(0))<0) {
				throw new RuntimeException();
				
			}
			
		
		
		
	}

}
