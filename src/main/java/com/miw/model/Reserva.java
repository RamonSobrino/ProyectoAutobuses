package com.miw.model;

public class Reserva {

	private long id;
	private String codigoReserva;
	private long idBilleteIda;
	private long idBilleteVuelta;
	private String Nombre;
	private String Apellidos;
	private String Dni;
	private String correo;

	public Reserva(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public long getIdBilleteIda() {
		return idBilleteIda;
	}

	public void setIdBilleteIda(long idBilleteIda) {
		this.idBilleteIda = idBilleteIda;
	}

	public long getIdBilleteVuelta() {
		return idBilleteVuelta;
	}

	public void setIdBilleteVuelta(long idBilleteVuelta) {
		this.idBilleteVuelta = idBilleteVuelta;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
