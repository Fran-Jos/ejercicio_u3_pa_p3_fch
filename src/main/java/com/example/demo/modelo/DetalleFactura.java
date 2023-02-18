package com.example.demo.modelo;

import java.math.BigDecimal;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalleFactura")
public class DetalleFactura {

	@Column(name = "deta_id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deta_seq")
	@SequenceGenerator(name = "deta_seq", sequenceName = "deta_seq", allocationSize = 1)
	private String id;
	
	@Column(name = "deta_cantidad")
	private Integer cantidad; 

	@Column(name = "deta_precioUnitario")

	private BigDecimal precioUnitario;
	
	@Column(name = "deta_subtotal")
	private BigDecimal subTotal;
	

	@ManyToOne
	@JoinColumn(name = "detalle_id_fac")
	private Factura factura;
	
	@ManyToOne
	@JoinColumn(name = "detalle_id_item")
	private Item item;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "DetalleFactura [id=" + id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario
				+ ", subTotal=" + subTotal + ", factura=" + factura + ", item=" + item + "]";
	}
	

	
}
