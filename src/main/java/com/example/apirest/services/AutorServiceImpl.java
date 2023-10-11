package com.example.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirest.entities.Autor;
import com.example.apirest.repositories.AutorRepository;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor, Long> implements AutorService{

	@Autowired
	private AutorRepository autorRepository;
}
