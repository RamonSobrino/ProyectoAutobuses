package com.miw.model;

public class Billete {

	private long id;
	private long idViaje;
	private long idUsuario;
	private int numPlazas;
	private Estado estado;

	private boolean seguro;
	private int numBicis;
	private int numMascotas;
	private int numTablaSurf;
	private int numEsquies;

	public Billete(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(long idViaje) {
		this.idViaje = idViaje;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public boolean isSeguro() {
		return seguro;
	}

	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}

	public int getNumBicis() {
		return numBicis;
	}

	public void setNumBicis(int numBicis) {
		this.numBicis = numBicis;
	}

	public int getNumMascotas() {
		return numMascotas;
	}

	public void setNumMascotas(int numMascotas) {
		this.numMascotas = numMascotas;
	}

	public int getNumTablaSurf() {
		return numTablaSurf;
	}

	public void setNumTablaSurf(int numTablaSurf) {
		this.numTablaSurf = numTablaSurf;
	}

	public int getNumEsquies() {
		return numEsquies;
	}

	public void setNumEsquies(int numEsquies) {
		this.numEsquies = numEsquies;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Billete other = (Billete) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
