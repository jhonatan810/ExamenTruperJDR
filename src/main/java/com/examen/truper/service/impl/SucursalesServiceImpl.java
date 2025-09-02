package com.examen.truper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.truper.entities.Sucursales;
import com.examen.truper.repository.SucursalesRepository;
import com.examen.truper.service.ISucursalesService;

@Service
public class SucursalesServiceImpl implements ISucursalesService {

	@Autowired
	private SucursalesRepository sucursalesRepository;
	
	@Override
	public Sucursales save(Sucursales sucursal) {
		return sucursalesRepository.save(sucursal);
	}

}
