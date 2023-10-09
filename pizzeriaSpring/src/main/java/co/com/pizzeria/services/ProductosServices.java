package co.com.pizzeria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.com.pizzeria.models.Producto;
import co.com.pizzeria.models.Producto;
import co.com.pizzeria.repository.ProductoRepository;

@Service
@Scope("singleton")
public class ProductosServices {

	@Autowired
	private ProductoRepository repository;
	
	
	@Transactional(readOnly = true)
	public List<Producto> findAll() throws Exception {
		List<Producto> listaProducto = (List<Producto>) repository.findAll();
		return listaProducto ;
	}
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor =Exception.class)
	public Producto guardarNuevoResgistroProducto(Producto registroNuevo) {
		validarDatosNuevoProducto(registroNuevo);
		Producto nuevoRegistro = repository.save(registroNuevo);
		return nuevoRegistro;
	}

	public Producto actualizarUnregistroDeProductos(Integer id, Producto registroActualizado) {
		Producto ProductoAntiguo = buscarProductoPorId(id);
		
		ProductoAntiguo.setNombreProducto(registroActualizado.getNombreProducto());
		ProductoAntiguo.setCategoria(registroActualizado.getCategoria());
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

	
	private void validarDatosNuevoProducto(Producto registro) {
		if(registro.getCategoria() == null) {
			throw new NullPointerException("Alguno de los datos ES nulo, Por favor revisar ");	
		}else if(registro.getCategoria().getNombre() == null ||
				registro.getCategoria().getNombre().isBlank() ||
				registro.getCategoria().getNombre().isEmpty() ||
				registro.getCategoria().getCodigo() == null ||
				registro.getCategoria().getCodigo() <=0
				) {
			throw new IllegalArgumentException(
					"Los valores de Canridad y Costo por unidad deben ser superiores a CERO");
			
		}
		
		
	}
}
