package com.miw.model;

public enum Estado {

	CANCELADO("Cancelado"), CONFIRMADO("Confirmado"), SIN_CONFIRMAR("Sin Confirmar");

	private final String label;

	Estado(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	public static Estado getEstado(String estado) {
		switch (estado) {
		case "Cancelado":
			return Estado.CANCELADO;
		case "Confirmado":
			return Estado.CONFIRMADO;
		case "Sin Confirmar":
			return Estado.SIN_CONFIRMAR;
		}
		return null;
	}

}
