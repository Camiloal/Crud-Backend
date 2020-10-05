package com.example.demo.services.interfaces;

import java.util.List;

import com.example.demo.dto.ProductoDto;
import com.example.demo.entitys.Producto;

public interface IProducto {
	
	public Producto obtenerProducto(Long id);

	public Producto crearProducto(ProductoDto productoDto);

	public String eliminarProducto(Long id);

	public Producto editarProducto(ProductoDto productoDto);
	
	public List<Producto> obtenerProductos();

}
