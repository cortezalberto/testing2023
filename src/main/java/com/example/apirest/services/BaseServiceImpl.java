package com.example.apirest.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.apirest.entities.Base;
import com.example.apirest.repositories.BaseRepository;

public abstract class BaseServiceImpl <E extends Base, ID extends Serializable> implements BaseService<E, ID>{

	@Autowired
	protected BaseRepository<E, ID> baseRepository;
	
	

	@Override
	@Transactional
	public List<E> findAll() throws Exception {
		try {
			List<E> entities = baseRepository.findAll();
			return entities;
		}
		catch (Exception e){
			throw new Exception (e.getMessage());
		}
	}

	@Override
	@Transactional
	public E findById(ID id) throws Exception {
		try {
			Optional<E> entityOptional = baseRepository.findById(id);
			return entityOptional.get();
		}
		catch (Exception e){
			throw new Exception (e.getMessage());
		}
	}

	@Override
	@Transactional
	public E save(E entity) throws Exception {
		try {
			baseRepository.save(entity);
			return entity;
		}
		catch (Exception e){
			throw new Exception (e.getMessage());
		}
	}

	@Override
	@Transactional
	public E update(E entity, ID id) throws Exception {
		try {
			Optional<E> entityOptional = baseRepository.findById(id);
			E entityUpdate = entityOptional.get();
			entityUpdate = baseRepository.save(entity);
			return entityUpdate;
		}
		catch (Exception e){
			throw new Exception (e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean delete(ID id) throws Exception {
		try {
			if(baseRepository.existsById(id)) {
				baseRepository.deleteById(id);
				return true;
			}
			else {
				throw new Exception();
			}
		}
		catch (Exception e){
			throw new Exception (e.getMessage());
		}
	}
}
