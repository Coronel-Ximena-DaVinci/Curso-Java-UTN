package utn.cursojava.sistemabancario.modelos;

public abstract class Persona {
	// Atributos
	protected String nombreApellido;
	protected String cuil;
	protected String telefono;
	protected String email;
	protected String direccion;

	// constructores
	public Persona() {
	}
	public Persona(String cuil) {
		this.cuil = cuil;
	}
	public Persona(String cuil, String nombreApellido) {
		this.cuil = cuil;
		this.nombreApellido = nombreApellido;
	}

	public Persona(String nombreApellido, String cuil, String telefono, String email, String direccion) {
		this.nombreApellido = nombreApellido;
		this.cuil = cuil;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getCuil() {
		return cuil;
	}

	public Cliente setCuil() {
		this.cuil = cuil;
		return null;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
