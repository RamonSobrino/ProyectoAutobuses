package com.miw.model;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class BusquedaViajeRequest {

	@NotEmpty(message = "Debe indicar un Origen.")
	private String origen;

	@NotEmpty(message = "Debe indicar un Destino.")
	private String destino;

	@Future
	@NotNull(message = "Debe indicar una Fecha de Salida.")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaIda;

	@Future
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaVuelta;

	@Min(1)
	@NotNull(message = "Debe indicar un número de Plazas.")
	private Integer plazas;

	private boolean idaYVuelta;

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

	public Date getFechaIda() {
		return fechaIda;
	}

	public void setFechaIda(Date fechaIda) {
		this.fechaIda = fechaIda;
	}

	public Date getFechaVuelta() {
		return fechaVuelta;
	}

	public void setFechaVuelta(Date fechaVuelta) {
		this.fechaVuelta = fechaVuelta;
	}

	public Integer getPlazas() {
		return plazas;
	}

	public void setPlazas(Integer plazas) {
		this.plazas = plazas;
	}

	public boolean isIdaYVuelta() {
		return idaYVuelta;
	}

	public void setIdaYVuelta(boolean idaYVuelta) {
		this.idaYVuelta = idaYVuelta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((fechaIda == null) ? 0 : fechaIda.hashCode());
		result = prime * result + ((fechaVuelta == null) ? 0 : fechaVuelta.hashCode());
		result = prime * result + (idaYVuelta ? 1231 : 1237);
		result = prime * result + ((origen == null) ? 0 : origen.hashCode());
		result = prime * result + ((plazas == null) ? 0 : plazas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusquedaViajeRequest other = (BusquedaViajeRequest) obj;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (fechaIda == null) {
			if (other.fechaIda != null)
				return false;
		} else if (!fechaIda.equals(other.fechaIda))
			return false;
		if (fechaVuelta == null) {
			if (other.fechaVuelta != null)
				return false;
		} else if (!fechaVuelta.equals(other.fechaVuelta))
			return false;
		if (idaYVuelta != other.idaYVuelta)
			return false;
		if (origen == null) {
			if (other.origen != null)
				return false;
		} else if (!origen.equals(other.origen))
			return false;
		if (plazas == null) {
			if (other.plazas != null)
				return false;
		} else if (!plazas.equals(other.plazas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BusquedaViajeRequest [origen=" + origen + ", destino=" + destino + ", fechaIda=" + fechaIda
				+ ", fechaVuelta=" + fechaVuelta + ", plazas=" + plazas + ", idaYVuelta=" + idaYVuelta + "]";
	}

}
