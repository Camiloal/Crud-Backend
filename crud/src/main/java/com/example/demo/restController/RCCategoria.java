package com.example.demo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoriaDto;
import com.example.demo.entitys.Categoria;
import com.example.demo.services.SCategoria;

@RestController
@RequestMapping("api/v1/categoria")
@CrossOrigin("*")
public class RCCategoria {

	@Autowired
	SCategoria sCategoria;

	@GetMapping(value = "all")
	public ResponseEntity<List<Categoria>> obtenerProductos() {
		return new ResponseEntity<>(sCategoria.obtenerCategorias(), HttpStatus.OK);
	}

	@RequestMapping(value = "{id_Categoria}", method = RequestMethod.GET)
	public ResponseEntity<Categoria> obtenerCategoria(@RequestParam Long id_Categoria) {

		return new ResponseEntity<>(sCategoria.obtenerCategoria(id_Categoria), HttpStatus.ACCEPTED);
	}

	@PostMapping(value = "create")
	public ResponseEntity<Categoria> crearCategoria(@RequestBody CategoriaDto dto) {

		return new ResponseEntity<>(sCategoria.crearCategoria(dto), HttpStatus.ACCEPTED);
	}

	@PutMapping(value = "edit")
	public ResponseEntity<Categoria> editarCategoria(@RequestBody CategoriaDto dto) {

		return new ResponseEntity<>(sCategoria.editarCategoria(dto), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "delete/{id_Categoria}", method = RequestMethod.DELETE)
	public ResponseEntity<String> eliminarCategoria(@RequestParam Long id_Categoria) {

		return new ResponseEntity<>(sCategoria.eliminarCategoria(id_Categoria), HttpStatus.OK);
	}

}
