package com.examen.truper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.truper.entities.Productos;
import com.examen.truper.repository.ProductoRepository;
import com.examen.truper.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;
	
	
	@Override
	public void updatePrecioById(Long id, double precio) {
		 productoRepository.updatePrecioById(id, precio);
		 
	}


	@Override
	public Productos save(Productos producto) {
		return productoRepository.save(producto);
	}
}
