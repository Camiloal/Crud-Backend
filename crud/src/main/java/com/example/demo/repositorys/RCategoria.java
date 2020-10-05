package com.example.demo.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entitys.Categoria;

@Repository
public interface RCategoria extends CrudRepository<Categoria, Long>{

}
