package com.bd.basico.servicio;

import java.util.List;

import com.bd.basico.modelo.TblProductoCL3;

public interface IProductoServicio {
	
	//declaramos los metodos
	public List<TblProductoCL3> ListadoProductos();
	public void RegistrarProducto(TblProductoCL3 Producto);
	public TblProductoCL3 BuscarporId(Integer id);
	public void Eliminar(Integer id);

} //fin de la interface...
