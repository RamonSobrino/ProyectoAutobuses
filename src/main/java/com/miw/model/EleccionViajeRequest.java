package com.miw.model;

public class EleccionViajeRequest {

	private long idUsuario;
	private long idViajeIda;
	private long idViajeVuelta;

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public long getIdViajeIda() {
		return idViajeIda;
	}

	public void setIdViajeIda(long idViajeIda) {
		this.idViajeIda = idViajeIda;
	}

	public long getIdViajeVuelta() {
		return idViajeVuelta;
	}

	public void setIdViajeVuelta(long idViajeVuelta) {
		this.idViajeVuelta = idViajeVuelta;
	}

}
