package com.curso.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.entidades.Producto;
import com.curso.repositorio.GenericRepositorio;

@Service
@Transactional
public class ProductoServiceImp implements ProductoService {

	@Autowired
	@Qualifier("ProductoJPARepository")
	private GenericRepositorio<Producto, Integer> productoRepositorio;

	@Override
	public Producto crearProducto(Producto p) {
		
		return productoRepositorio.create(p);
	}

}
