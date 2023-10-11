package com.example.apirest.controllers;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.apirest.entities.Base;

public interface BaseController <E extends Base, ID extends Serializable>{
	public ResponseEntity<?> getAll();
	public ResponseEntity<?> getOne(@PathVariable ID id);
	public ResponseEntity<?> save(@RequestBody E entity);
	public ResponseEntity<?> delete(@PathVariable ID id);
	public ResponseEntity<?> update(@RequestBody E entity, @PathVariable ID id);
}
