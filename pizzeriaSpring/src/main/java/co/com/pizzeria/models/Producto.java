package co.com.pizzeria.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Integer id;
	// @Column(name = "id_categoria")
	// private Integer idCategoria;
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	@Column(name = "nombre_producto")
	private String nombreProducto;
	
	 /*@ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="id_carrito")
	 private CarritoCompra carritoCompras;*/

	// constructor
	public Producto() {
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", categoria=" + categoria + ", nombreProducto=" + nombreProducto + "]";
	}

	public Producto(Integer id, Categoria categoria, String nombreProducto) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.nombreProducto = nombreProducto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

}
