package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductoDto;
import com.example.demo.entitys.Producto;
import com.example.demo.repositorys.RProducto;
import com.example.demo.services.interfaces.IProducto;
import com.example.demo.entitys.Categoria;
import com.example.demo.repositorys.RCategoria;

@Service
public class SProducto implements IProducto {

	@Autowired
	RProducto rProducto;

	@Autowired
	RCategoria rCategoria;
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Producto obtenerProducto(Long id) {

		Optional<Producto> producto = rProducto.findById(id);
		if (producto.isPresent()) {
			return producto.get();
		} else {
			return null;
		}

	}

	@Override
	public Producto crearProducto(ProductoDto productoDto) {

		Optional<Categoria> categoria = rCategoria.findById(productoDto.getIdCategoria());

		if (categoria.isPresent()) {

			Producto nproducto = new Producto();
			nproducto.setCantidad(productoDto.getCantidad());
			nproducto.setNombre(productoDto.getNombre());
			nproducto.setPrecio(productoDto.getPrecio());
			nproducto.setCategoria(categoria.get());
			rProducto.save(nproducto);
			return nproducto;

		} else {
			return null;
		}

	}

	@Override
	public String eliminarProducto(Long id) {
		Optional<Producto> producto = rProducto.findById(id);
		if (producto.isPresent()) {
			rProducto.delete(producto.get());
			return "Producto Eliminado";

		} else {
			return "El producto no existe";
		}
	}

	@Override
	public Producto editarProducto(ProductoDto productoDto) {
		Optional<Producto> producto = rProducto.findById(productoDto.getIdProducto());

		Optional<Categoria> categoria = rCategoria.findById(productoDto.getIdCategoria());

		if (producto.isPresent()) {
			Producto eProducto = producto.get();
			eProducto.setNombre(
					(!productoDto.getNombre().isEmpty() || !productoDto.getNombre().isBlank()) ? productoDto.getNombre()
							: eProducto.getNombre());
			eProducto.setCantidad(
					(productoDto.getCantidad() != 0) ? productoDto.getCantidad() : eProducto.getCantidad());
			eProducto.setPrecio((productoDto.getPrecio() != 0) ? productoDto.getPrecio() : eProducto.getPrecio());
			if (categoria.isPresent()) {
				eProducto.setCategoria(categoria.get());
				rProducto.save(eProducto);

			}
			return eProducto;

		} else {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> obtenerProductos() {

		String jpql = "SELECT p, c.tipo FROM Producto p, Categoria c WHERE c.id_categoria = p.categoria.id_categoria";
		Query query = em.createQuery(jpql);
		
		return query.getResultList();

	} 

}
