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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.pizzeria.models.CarritoCompra;
import co.com.pizzeria.services.CarritoComprasServices;

@RestController
@RequestMapping("/api/carrito")
@CrossOrigin("*")
public class CarritoComprasController {

	private static final Logger log = LoggerFactory.getLogger(CarritoComprasController.class);

	@Autowired
	private CarritoComprasServices services;
	@GetMapping()
	public ResponseEntity<?> bucarTodasLasCarritoCompras() throws Exception {
		
		List<CarritoCompra> listaCarritodeCompras = services.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(listaCarritodeCompras);
	}

	@PostMapping()
	public ResponseEntity<?> nuevoResgistroDeCarritoCompras(@RequestBody CarritoCompra nuevoResgistroCarritoCompras)throws Exception {
		
		CarritoCompra nuevoRegistroResponse = services.nuevoRegistroCarritoDeCompras(nuevoResgistroCarritoCompras);

		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRegistroResponse);
	}

	@PutMapping()
	public ResponseEntity<?> actualizarLaCategoriaCarritoCompras() {
		return null;
	}

	@DeleteMapping()
	public ResponseEntity<?> borrarLaCategoriaCarritoCompras() {
		return null;
	}
	

}
