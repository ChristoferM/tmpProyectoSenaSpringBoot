package co.com.pizzeria.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.pizzeria.models.Producto;
import co.com.pizzeria.services.ProductosServices;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin("*")
public class ProductoController {

	private static final Logger log = LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	private ProductosServices services;
	@GetMapping()
	public ResponseEntity<?> bucarTodasLosProductos() {
		return null;
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> bucarProductosPorId(@PathVariable Integer id) {
		return null;
	}

	@PostMapping()
	public ResponseEntity<?> nuevoResgistroDeProductos(@RequestBody Producto nuevoProducto) {
		return null;
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarLaCategoriaProductos(@PathVariable Integer id,@RequestBody Producto productoActualziar) {
		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarLaCategoriaProductos(@PathVariable Integer id) {
		return null;
	}
	
}
