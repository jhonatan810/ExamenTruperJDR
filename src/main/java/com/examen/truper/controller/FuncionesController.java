package com.examen.truper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.truper.dto.ResponseDto;
import com.examen.truper.entities.Ordenes;
import com.examen.truper.entities.Productos;
import com.examen.truper.entities.Sucursales;
import com.examen.truper.service.IOrdenDeCompraService;
import com.examen.truper.service.IProductoService;
import com.examen.truper.service.ISucursalesService;

@RestController
@RequestMapping("/api/v1/tienda")
public class FuncionesController {
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IOrdenDeCompraService ordenDeCompraService;
	
	@Autowired
	private ISucursalesService sucursalesService;
	
	
	@PostMapping("/save")
	public ResponseEntity<ResponseDto> save(@RequestBody Ordenes orden){
		
		if(orden == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		Ordenes save = ordenDeCompraService.save(orden);
		
		if(save == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		ResponseDto respuesta = ResponseDto.builder()
									.code(HttpStatus.OK.value())
									.message("La orden de compra se guardo correctamente")
									.objeto(save)
									.build();
		
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	@PostMapping("/sucursal/save")
	public ResponseEntity<ResponseDto> saveSucursal(@RequestBody Sucursales sucursal){
		
		if(sucursal == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		Sucursales save = sucursalesService.save(sucursal);
		
		if(save == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		ResponseDto respuesta = ResponseDto.builder()
									.code(HttpStatus.OK.value())
									.message("La sucursal se guardo correctamente")
									.objeto(save)
									.build();
		
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	@PostMapping("/producto/save")
	public ResponseEntity<ResponseDto> saveProducto(@RequestBody Productos producto){
		
		if(producto == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		Productos save = productoService.save(producto);
		
		if(save == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		ResponseDto respuesta = ResponseDto.builder()
									.code(HttpStatus.OK.value())
									.message("El producto se guardo correctamente")
									.objeto(save)
									.build();
		
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<ResponseDto> findById(@PathVariable Long id){
		
		if(id == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		Ordenes byId = ordenDeCompraService.findById(id);
		
		if(byId == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		ResponseDto respuesta = ResponseDto.builder()
									.code(HttpStatus.OK.value())
									.message("La orden de compra se encontro correctamente")
									.objeto(byId)
									.build();
		
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	@PutMapping("/update/price/{id}/{price}")
	public ResponseEntity<ResponseDto> updateProdct(@PathVariable Long id, @PathVariable double price){
		
		if(id == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		productoService.updatePrecioById(id, price);
		
		ResponseDto respuesta = ResponseDto.builder()
									.code(HttpStatus.OK.value())
									.message("Se actualizo cortrectamente")
									.objeto(null)
									.build();
		
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	

}
