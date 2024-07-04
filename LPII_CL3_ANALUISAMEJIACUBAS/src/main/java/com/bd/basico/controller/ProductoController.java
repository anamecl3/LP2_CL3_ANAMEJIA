package com.bd.basico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.basico.modelo.TblProductoCL3;
import com.bd.basico.servicio.IProductoServicio;

@Controller
@RequestMapping("/Vistas")
public class ProductoController {
	
	
	//inyeccion de dependencia...
		@Autowired
		private IProductoServicio iproductoservicio;
		//creamos el metodo listado..
		@GetMapping("ListadoProducto")
		public String ListadoProducto(Model modelo) {
			//recuperamos el listado de Productos..
			List<TblProductoCL3> listado=iproductoservicio.ListadoProductos();
			for(TblProductoCL3 lis:listado) {
		System.out.println("codigo "+lis.getIDPRODUCTOCL3()+" "+" nombre "+lis.getNOMBRECL3());
			}
			//enviamos la data hacia la vista..
			modelo.addAttribute("listado",listado);
			//retornamos
			return "/Vistas/ListadoProducto";
			
		}  //fin del metodo listado producto...
		
		
		//creamos los respectivos para metodos para registrar...
		@GetMapping("/RegistrarProducto")
		public String Registrar(Model modelo) {
			//realizamos la respectiva instancia...
			TblProductoCL3 producto=new TblProductoCL3();
			//enviamos a la vista...
			modelo.addAttribute("accion","REGISTRAR");
			modelo.addAttribute("regproducto",producto);
			//retornamos
			return "/Vistas/FrmCrearProducto";
			
		}  //fin del metodo registrar.
		
		//realizamos el mapeo con postmapping
		@PostMapping("/GuardarProducto")
		public String GuardarProducto(@ModelAttribute TblProductoCL3  producto,Model modelo) {
			iproductoservicio.RegistrarProducto(producto);
			System.out.println("dato registrado en la bd");
			//retornamos al listado...
			return "redirect:/Vistas/ListadoProducto";	
		}  //fin del metodo string...
		
		//*****************crearmos el metodo editar...
		@GetMapping("/editar/{id}")
		public String Editar(@PathVariable("id") Integer idproducto,Model modelo) {
			TblProductoCL3 producto=iproductoservicio.BuscarporId(idproducto);
			//enviamos hacia la vista...
			modelo.addAttribute("accion","MODIFICAR");
			modelo.addAttribute("regproducto",producto);
			//retornamos el frmcrearproducto...
			return "/Vistas/FrmCrearProducto";	
		}  //fin del metodo editar...
		
		//************************creamos el metodo eliminar..
		@GetMapping("/eliminar/{id}")
		public String eliminar(@PathVariable("id") Integer idproducto,Model modelo) {
			
			//aplicamos inyeccion de dependencia...
			iproductoservicio.Eliminar(idproducto);
			//actulizar el listado
			List<TblProductoCL3> listado=iproductoservicio.ListadoProductos();
			//enviamos a la vista
			modelo.addAttribute("listado",listado);
			//redireccionamos
			return "redirect:/Vistas/ListadoProducto";		
		}   //fin del metodo eliminar...


	

}   //fin del controlador...
