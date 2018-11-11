package com.miw.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class Viaje {

	private long id;
	private String origen;
	private String destino;

	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime fechaSalida;

	private int plazasTotales;
	private int plazasRestantes;
	private double precio;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getPlazasTotales() {
		return plazasTotales;
	}

	public void setPlazasTotales(int plazasTotales) {
		this.plazasTotales = plazasTotales;
	}

	public int getPlazasRestantes() {
		return plazasRestantes;
	}

	public void setPlazasRestantes(int plazasRestantes) {
		this.plazasRestantes = plazasRestantes;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
