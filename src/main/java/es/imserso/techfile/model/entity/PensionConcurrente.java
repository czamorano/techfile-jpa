package es.imserso.techfile.model.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PensionConcurrente
 *
 */
@Entity

public class PensionConcurrente implements Serializable {

	   
	@Id
	private String codigo;
	@Column(unique = true, length = 150, nullable = false)
	private String descripcion;
	private static final long serialVersionUID = 1L;

	public PensionConcurrente() {
		super();
	}   
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
   
}
