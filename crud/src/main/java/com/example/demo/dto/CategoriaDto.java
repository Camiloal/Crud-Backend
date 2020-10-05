package com.example.demo.dto;

public class CategoriaDto {

	private Long id_categoria;
	private String tipo;
	public CategoriaDto() {
		
	}
	public CategoriaDto(String tipo) {
		super();
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
	
	
	
	
}
