package co.com.pizzeria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.pizzeria.models.Producto;
import co.com.pizzeria.models.Producto;
import co.com.pizzeria.repository.ProductoRepository;

@Service
public class ProductosServices {

	@Autowired
	private ProductoRepository repository;
	
	
	
	public List<Producto> findAll() throws Exception {
		return (List<Producto>) repository.findAll();
	}

	public Producto guardarNuevoResgistroProducto(Producto registroActualizado) {
		Producto nuevoRegistro = repository.save(registroActualizado);
		return nuevoRegistro;
	}

	public Producto actualizarUnregistroDeProductos(Integer id, Producto registroActualizado) {
		Producto ProductoAntiguo = buscarProductoPorId(id);
		
		
		Producto ProductoNuevo = repository.save(ProductoAntiguo) ;
		
		return ProductoNuevo;
	}

	public Producto buscarProductoPorId(Integer id) {
		Optional<Producto> categorioaOptional = repository.findById(id);
		if (categorioaOptional.isEmpty()) {
			throw new NullPointerException("No se encontro datos con el ID : " + id);

		}
		return categorioaOptional.get();

	}
	public void eliminarResgistroProducto(Integer id) {
		buscarProductoPorId(id);
		repository.deleteById(id);
	}

}
