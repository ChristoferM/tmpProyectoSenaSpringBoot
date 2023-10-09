package co.com.pizzeria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.pizzeria.models.CarritoCompra;

@Repository
public interface CarritoCompraRespository extends CrudRepository<CarritoCompra, Integer> {

}
