package co.com.pizzeria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.pizzeria.models.CarritoCompra;
import co.com.pizzeria.repository.CarritoCompraRespository;

@Service
public class CarritoComprasServices {

	@Autowired
	private CarritoCompraRespository repository;

	public List<CarritoCompra> findAll() throws Exception {
		return (List<CarritoCompra>) repository.findAll();
	}

	public CarritoCompra nuevoRegistroCarritoDeCompras(CarritoCompra nuevoResgistroCarritoCompras) throws Exception {
		validarDatosDeunRegistroDeCarritoCompras(nuevoResgistroCarritoCompras);
		Integer valorTotal = nuevoResgistroCarritoCompras.getCostoUnd() * nuevoResgistroCarritoCompras.getCantidad();
		nuevoResgistroCarritoCompras.setCostoTotal(valorTotal);
		CarritoCompra nuevoRegistro = repository.save(nuevoResgistroCarritoCompras);
		return nuevoRegistro;
	}

	private void validarDatosDeunRegistroDeCarritoCompras(CarritoCompra carritoCompras) throws Exception {
		if (carritoCompras.getListaProductos() == null || carritoCompras.getDetalle() == null
				|| carritoCompras.getCostoUnd() == null || carritoCompras.getCantidad() == null) {
			throw new NullPointerException("Alguno de los datos ES nulo, Por favor revisar ");
		} else if (carritoCompras.getCantidad() <= 0 || carritoCompras.getCostoUnd() <= 0
				|| carritoCompras.getListaProductos().size() <= 0) {
			throw new IllegalArgumentException(
					"Los valores de Canridad y Costo por unidad deben ser superiores a CERO");
		}
	}

}
