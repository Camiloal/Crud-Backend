package com.example.demo.entitys;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@Column(name = "id_categoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_categoria;

	@JsonManagedReference
	@OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER) 
	private List<Producto> listaProductos;

	@Column(name = "tipo")
	private String tipo;

	public Categoria() {

	}

	public Categoria(String tipo) {
		this.tipo = tipo;
	}

	public Categoria(List<Producto> listaProductos, String tipo) {
		this.listaProductos = listaProductos;
		this.tipo = tipo;
	}

	public Long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

}
