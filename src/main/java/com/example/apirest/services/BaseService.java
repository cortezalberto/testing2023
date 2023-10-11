package com.example.apirest.services;

import java.io.Serializable;
import java.util.List;

import com.example.apirest.entities.Base;



public interface BaseService<E extends Base, ID extends Serializable> {

	List<E> findAll() throws Exception;
	E findById(ID id) throws Exception;
	E save (E entity) throws Exception;
	E update (E entity, ID id) throws Exception;
	boolean delete (ID id) throws Exception;
	
}
