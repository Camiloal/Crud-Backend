package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CategoriaDto;
import com.example.demo.entitys.Categoria;
import com.example.demo.repositorys.RCategoria;
import com.example.demo.services.interfaces.ICategoria;

@Service
public class SCategoria implements ICategoria {

	@Autowired
	RCategoria rCategoria;
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Categoria obtenerCategoria(Long id_Categoria) {
		Optional<Categoria> categoria = rCategoria.findById(id_Categoria);
		if (categoria.isPresent()) {
			return categoria.get();
		} else {
			return null;
		}
	}

	@Override
	public Categoria crearCategoria(CategoriaDto categoriaDto) {
		Categoria nCategoria = new Categoria(categoriaDto.getTipo());
		rCategoria.save(nCategoria);
		return nCategoria;
	}

	@Override
	public String eliminarCategoria(Long id_Categoria) {
		Optional<Categoria> categoria = rCategoria.findById(id_Categoria);
		if (categoria.isPresent()) {
			rCategoria.delete(categoria.get());
			return "Categoria Eliminado";

		}else {
			return "El categoria no existe";
		}
	}

	@Override
	public Categoria editarCategoria(CategoriaDto categoriaDto) {
		Optional<Categoria> categoria = rCategoria.findById(categoriaDto.getId_categoria());
		if (categoria.isPresent()) {
			Categoria eCategoria = categoria.get();
			eCategoria.setTipo(
					(!categoriaDto.getTipo().isEmpty() || !categoriaDto.getTipo().isBlank()) ? categoriaDto.getTipo()
							: eCategoria.getTipo());
			
			rCategoria.save(eCategoria);
			return eCategoria;

		} else {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> obtenerCategorias() {
		String jpql = "SELECT c FROM  Categoria c";
		Query query = em.createQuery(jpql);
		
		return query.getResultList();

	}
	
	

}
