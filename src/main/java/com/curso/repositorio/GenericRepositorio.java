package com.curso.repositorio;

import java.util.List;

public interface GenericRepositorio <E, K> {

	//lo definimos despues en donde sea necesario
	//seria como poner lo siguiente
	
	E get(K id); //Producto get(Integer id)
	E create(E entidad); //Producto create(Producto entidad)
	E update(E entidad); //Producto update(Producto entidad)
	void delete(K id); //void delete(Integer id)
	List<E> getAll(); //List<Producto> getAll()
	
	//pero se puede reusar en otros casos
}
