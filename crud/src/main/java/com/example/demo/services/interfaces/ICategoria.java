package com.example.demo.services.interfaces;

import java.util.List;

import com.example.demo.dto.CategoriaDto;
import com.example.demo.entitys.Categoria;

public interface ICategoria {

	public Categoria obtenerCategoria(Long id);

	public Categoria crearCategoria(CategoriaDto categoriaDto);

	public String eliminarCategoria(Long id);

	public Categoria editarCategoria(CategoriaDto categoriaDto);
	
	public List<Categoria> obtenerCategorias();

}
