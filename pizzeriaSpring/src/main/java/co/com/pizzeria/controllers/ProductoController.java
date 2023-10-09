package co.com.pizzeria.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<?> bucarTodasLosProductos() throws Exception {
		List<Producto> listaProductos = services.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(listaProductos);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> bucarProductosPorId(@PathVariable Integer id) {
		Producto producto = services.buscarProductoPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(producto);
	}

	@PostMapping()
	public ResponseEntity<?> nuevoResgistroDeProductos(@RequestBody Producto nuevoProducto) {
		Producto producto = services.guardarNuevoResgistroProducto(nuevoProducto);
		return ResponseEntity.status(HttpStatus.CREATED).body(producto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarLaCategoriaProductos(@PathVariable Integer id,@RequestBody Producto productoActualziar) {
		Producto producto = services.actualizarUnregistroDeProductos(id,productoActualziar);
		return ResponseEntity.status(HttpStatus.OK).body(producto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarLaCategoriaProductos(@PathVariable Integer id) {
		services.eliminarResgistroProducto(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Se elimino correctamente el resgistro de ID : "+id);
	}
	
}
