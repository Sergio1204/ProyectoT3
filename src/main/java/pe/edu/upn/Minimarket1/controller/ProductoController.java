package pe.edu.upn.Minimarket1.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.Minimarket1.model.entity.Almacen;
import pe.edu.upn.Minimarket1.model.entity.Categoria;
import pe.edu.upn.Minimarket1.model.entity.DetallePedido;
import pe.edu.upn.Minimarket1.model.entity.Pedido;
import pe.edu.upn.Minimarket1.model.entity.Producto;
import pe.edu.upn.Minimarket1.model.entity.Tarjeta;
import pe.edu.upn.Minimarket1.service.AlmacenService;
import pe.edu.upn.Minimarket1.service.CategoriaService;
import pe.edu.upn.Minimarket1.service.DetallePedidoService;
import pe.edu.upn.Minimarket1.service.PedidoService;
import pe.edu.upn.Minimarket1.service.ProductoService;
import pe.edu.upn.Minimarket1.service.ProveedorService;
import pe.edu.upn.Minimarket1.service.TarjetaService;

@Controller
@RequestMapping("/Productos")
public class ProductoController {
	@Autowired
	ProductoService productoService;
	@Autowired
	CategoriaService categoriaService;
	@Autowired
	ProveedorService proveedorService;
	@Autowired
	AlmacenService almacenService;
	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	DetallePedidoService detallePService;
	
	@Autowired
	TarjetaService tarjetaService;
	
	//Lista de pedido llena despues de llamar metodo especifico
	List<Producto> pedidoProducto = new ArrayList<>();
	List<Producto> aux = new ArrayList<>();
	
	//Lista de tarjetas llena despues de llamar metodo especifico
	List<Tarjeta> tarjetas = new ArrayList<>();
	
	float total = 0;
	
	@GetMapping
	public String consultar(Model model) {
		try {
			List<Producto> productos = productoService.findAll();
			model.addAttribute("productos",productos);
			pedidoProducto.clear();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "/Productos/catalogo";
	}
	
	@GetMapping("/edit/{codProd}")
	public String editar(@PathVariable("codProd") String id,Model model) {
		try {
			Optional<Producto> optional = productoService.findById(id);
			
			if(optional.isPresent()) {
				List<Categoria> categorias = categoriaService.findAll();
				List<Almacen> almacenes = almacenService.findAll();
				
				
				model.addAttribute("producto", optional.get());
				model.addAttribute("categorias", categorias);
				model.addAttribute("almacenes", almacenes);
			}else {
				return "redirect:/Principal";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/Productos/edit";
	}
	
	@GetMapping("/register")
	public String registrar(Model model) {
		Producto producto = new Producto();
		
		model.addAttribute("producto",producto);
		try {
			List<Categoria> categorias = categoriaService.findAll();
			List<Almacen> almacenes = almacenService.findAll();
			
			model.addAttribute("categorias",categorias);
			model.addAttribute("almacenes",almacenes);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/Productos/register";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("producto") Producto producto,
			Model model, SessionStatus status) {
		try {
			productoService.save(producto);
			status.setComplete();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/Productos";
	}
	
	@GetMapping("/del/{id}")
	public String delete(@PathVariable("id") String id, Model model) {
		try {
			Optional<Producto> producto = productoService.findById(id);
			if(producto.isPresent()) {
				productoService.deleteById(id);
			}
		}catch(Exception e) {
			model.addAttribute("dangerDel", "ERROR - Violacion contra el principio de integridad referencial");
			try {
				List<Producto> productos = productoService.findAll();
				model.addAttribute("productos",productos);
			}catch(Exception ex) {
				System.out.println(e.getMessage());
			}
			return "/Productos/catalogo";
		}
		return "redirect:/Productos";
	}
	
	@GetMapping("/carrito/{id}")
	public String carro(@PathVariable("id") String id, Model model) {
		try {
			List<Producto> productos = productoService.findAll();
			Optional<Producto> optional = productoService.findById(id);
			if(optional.isPresent()) {
				pedidoProducto.add(optional.get());
			}
			model.addAttribute("productosPedido",pedidoProducto);
			model.addAttribute("productos",productos);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "/Operaciones/Pedido/nuevo";
	}
	
	@GetMapping("/delPedido/{id}")
	public String borrar(@PathVariable("id") String id, Model model) {
		Optional<Producto> p = null;
		
		try {
			p = productoService.findById(id);
			List<Producto> productos = productoService.findAll();
			
			model.addAttribute("productos",productos);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(p.isPresent()) {
			for(int i=0;i<pedidoProducto.size();i++) {
				Producto pr = pedidoProducto.get(i);
				
				if(pr.getCodProd().compareTo(p.get().getCodProd()) == 0) {
					pedidoProducto.remove(i);
				}
				
			}
		}else { 
			return "redirect:/Productos/carrito/0";
		}
		model.addAttribute("productosPedido",pedidoProducto);
		
		return "/Operaciones/Pedido/nuevo";
	}
	
	@GetMapping("/confirmarP")
	public String confirmarP(Model model, SessionStatus status) {
		Date d = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		Pedido p;
		DetallePedido detalle;
		
		for(Producto pr : aux){
			System.out.println(pr.getNomProd());
		}
		
		String c1;
		String c2;
		int cantidad = 1;
		try {
			p = new Pedido(formato.format(d));
			pedidoService.save(p);
			
			for(int i=0; i<aux.size(); i++) {
				cantidad=1;
				for(int j=i+1; j<aux.size(); j++) {
					c1 = aux.get(i).getNomProd();
					c2 = aux.get(j).getNomProd();
					if(c1.compareTo(c2) == 0) {
						aux.remove(j);
						cantidad++;
					}
					c1="";
					c2="";
				}
				detalle = new DetallePedido(aux.get(i), p, cantidad);
				detallePService.save(detalle);
			}
			status.setComplete();
			
			if(status.isComplete()) {
				return "/principal";
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "/Pago/realizado";
	}
	
	@GetMapping("/pago")
	public String pago(Model model) {
		Tarjeta tarjeta = new Tarjeta();
		
		/*
		for(Producto p : pedidoProducto){
			System.out.println(p.getNomProd());
		}
		*/
		
		model.addAttribute("tarjeta",tarjeta);
		
		return "/Pago/pago";
	}
	
	@PostMapping("/validate")
	public String validate(@ModelAttribute("tarjeta") Tarjeta tarjeta, Model model, SessionStatus status) {
		boolean band = false;
		
		
		/*for(Producto p : pedidoProducto){
			System.out.println(p.getNomProd());
		}*/
		
		
		try {
			
			tarjetas = tarjetaService.findAll();
			
			for(int i=0;i<tarjetas.size();i++) {
				Tarjeta t = tarjetas.get(i);
				if(tarjeta.getNumero().compareTo(t.getNumero()) == 0) {
					if(tarjeta.getCodigoSeguridad() == t.getCodigoSeguridad()) {
						band = true;
						aux = pedidoProducto;
						return "redirect:/Productos/confirmarP";
					}else {
						model.addAttribute("bandE1","FALLO AL VALIDAR DATOS DE FACTURACION");
						
						return "/Pago/pago";
					}
				}
			}
			
			if(band == false) {
				model.addAttribute("bandE2","ERROR: TARJETA INEXISTENTE O SIN FONDOS");
				
				return "/Pago/pago";
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "/Pago/pago";
	}
	
}
