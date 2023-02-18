package com.example.demo.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
@NamedQuery(name = "buscarPorCodigoDeBarras" , query = "Select i from Item i where i.codigoDeBarras =:datoCB")
public class Item {

	@Column(name = "item_id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
	@SequenceGenerator(name = "item_seq", sequenceName = "item_seq", allocationSize = 1)
    private String id;
	
	@Column(name = "item_codigoDeBarras")
	private String codigoDeBarras;
	
	@Column(name = "item_nombre")
	private String nombre;

	@Column(name = "item_tipo")
	private String tipo;
	
	@Column(name = "item_stock")
	private Integer stock;
	
	@Column(name = "item_precio")
	private BigDecimal precio;

	@OneToMany(mappedBy = "item")
	private  List<DetalleFactura> detalleFactura;
	
	@ManyToOne
	private Factura factura;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<DetalleFactura> getDetalleFactura() {
		return detalleFactura;
	}

	public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
		this.detalleFactura = detalleFactura;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", codigoDeBarras=" + codigoDeBarras + ", nombre=" + nombre + ", tipo=" + tipo
				+ ", stock=" + stock + ", precio=" + precio + "]";
	}
	
	
}
