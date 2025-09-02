package com.examen.truper.service;

import com.examen.truper.entities.Ordenes;

public interface IOrdenDeCompraService {
	
	public Ordenes save(Ordenes orden); 
	public Ordenes findById(Long id);

}
