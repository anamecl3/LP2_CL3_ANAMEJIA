package com.bd.basico.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.basico.modelo.TblProductoCL3;
import com.bd.basico.repositorio.IProductoRepositorio;


@Service
public class ClassProductoImp  implements IProductoServicio{
	
	//aplicamos la inyeccion de dependencia...
	@Autowired
	private IProductoRepositorio iProductorepository;

	@Override
	public List<TblProductoCL3> ListadoProductos() {
		//devuelve el listado
		return (List<TblProductoCL3>)iProductorepository.findAll();
	}

	@Override
	public void RegistrarProducto(TblProductoCL3 Producto) {
		//registrar los datos
		iProductorepository.save(Producto);
		
	}

	@Override
	public TblProductoCL3 BuscarporId(Integer id) {
		//buscar por codigo, si no encuentra devuelve nulo..		
		return iProductorepository.findById(id).orElse(null);
	}

	@Override
	public void Eliminar(Integer id) {
		//eliminar por codigo
		iProductorepository.deleteById(id);
		
	}
	
	

}  //fin de la clase....
