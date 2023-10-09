
package co.com.pizzeria.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "carrito_compras")
public class CarritoCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_carrito")
	private Integer idCarritoCompras;
	
   @OneToMany(mappedBy="carritoCompras")
	private List<Producto> listaProductos;

	@Column(name = "detalle")
	private String detalle;

	@Column(name = "costo_und")
	private Integer costoUnd;

	@Column(name = "costo_total")
	private Integer costoTotal;

	@Column(name = "metodo_pago")
	private String metodoPago;

	@Column(name = "cantidad")
	private Integer cantidad;

	public CarritoCompra() {

	}

	public Integer getIdCarritoCompras() {
		return idCarritoCompras;
	}

	public void setIdCarritoCompras(Integer idCarritoCompras) {
		this.idCarritoCompras = idCarritoCompras;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Integer getCostoUnd() {
		return costoUnd;
	}

	public void setCostoUnd(Integer costoUnd) {
		this.costoUnd = costoUnd;
	}

	public Integer getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(Integer costoTotal) {
		this.costoTotal = costoTotal;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "CarritoCompras [idCarritoCompras=" + idCarritoCompras + ", listaProductos=" + listaProductos
				+ ", detalle=" + detalle + ", costoUnd=" + costoUnd + ", costoTotal=" + costoTotal + ", metodoPago="
				+ metodoPago + ", cantidad=" + cantidad + "]";
	}

}
