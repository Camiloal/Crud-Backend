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

import com.example.demo.dto.ProductoDto;
import com.example.demo.entitys.Producto;
import com.example.demo.services.SProducto;

@RestController
@RequestMapping("api/v1/producto")
@CrossOrigin("*")
public class RCProducto {
	
	@Autowired
	SProducto sProducto;
	
	@GetMapping(value = "all")
	public ResponseEntity<List<Producto>> obtenerProductos(){
		return new ResponseEntity<>(sProducto.obtenerProductos(),HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "productoId", method = RequestMethod.GET)
	public ResponseEntity<Producto> obtenerProducto(@RequestParam Long idProducto) {
		
		return new ResponseEntity<>(sProducto.obtenerProducto(idProducto),HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "create")
	public ResponseEntity<Producto> crearProducto(@RequestBody ProductoDto dto) {
		
		return new ResponseEntity<>(sProducto.crearProducto(dto),HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "edit")
	public ResponseEntity<Producto> editarProducto(@RequestBody ProductoDto dto) {
		
		return new ResponseEntity<>(sProducto.editarProducto(dto),HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "delete/productoId", method = RequestMethod.DELETE)
	public ResponseEntity<String> eliminarProducto(@RequestParam Long idProducto) {
		
		return new ResponseEntity<>(sProducto.eliminarProducto(idProducto),HttpStatus.OK);
	}

}
