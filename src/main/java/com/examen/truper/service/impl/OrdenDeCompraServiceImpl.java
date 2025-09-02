package com.examen.truper.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.truper.entities.Ordenes;
import com.examen.truper.repository.OrdenDeCompraRepository;
import com.examen.truper.service.IOrdenDeCompraService;

@Service
public class OrdenDeCompraServiceImpl implements IOrdenDeCompraService {

	@Autowired
	private OrdenDeCompraRepository ordenDeCompraRepository;
	
	
	@Override
	public Ordenes save(Ordenes orden) {
		return ordenDeCompraRepository.save(orden);
	}

	@Override
	public Ordenes findById(Long id) {
		Optional<Ordenes> byId = ordenDeCompraRepository.findById(id);
		
		if(byId != null && byId.isPresent()){
			return byId.get();
		}
		
		return null;
	}

}
