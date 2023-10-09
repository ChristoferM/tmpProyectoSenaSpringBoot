package co.com.pizzeria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.pizzeria.models.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto,Integer>{

}
