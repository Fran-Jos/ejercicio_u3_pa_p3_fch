package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {

	@Column(name = "fac_id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
	@SequenceGenerator(name = "item_seq", sequenceName = "item_seq", allocationSize = 1)
	private String id;
	
	@Column(name = "fac_numero")
	private String numero;

	@Column(name = "fac_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "fac_cedulaCliente")
	private String cedulaCliente;
	
	@Column(name = "fac_totalVenta")
	private BigDecimal totalVenta;
	
	@OneToMany(mappedBy = "factura",cascade = CascadeType.ALL , fetch = FetchType.LAZY )
	private List<DetalleFactura> detalleFactura;
	
	@OneToMany(mappedBy = "factura",cascade = CascadeType.ALL , fetch = FetchType.LAZY  )
	private List<Item> items;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public BigDecimal getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(BigDecimal totalVenta) {
		this.totalVenta = totalVenta;
	}

	public List<DetalleFactura> getDetalleFactura() {
		return detalleFactura;
	}

	public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
		this.detalleFactura = detalleFactura;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", numero=" + numero + ", fecha=" + fecha + ", cedulaCliente=" + cedulaCliente
				+ ", totalVenta=" + totalVenta + "]";
	}
	

	
}
