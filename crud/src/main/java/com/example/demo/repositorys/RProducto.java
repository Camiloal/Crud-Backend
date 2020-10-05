package com.example.demo.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entitys.Producto;

@Repository
public interface RProducto extends CrudRepository<Producto, Long>{

}
