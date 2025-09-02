package com.examen.truper.service;

import com.examen.truper.entities.Productos;

public interface IProductoService {

	public void updatePrecioById(Long id, double precio);
	public Productos save(Productos producto);
}
