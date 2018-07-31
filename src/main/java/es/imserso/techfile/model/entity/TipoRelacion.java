package es.imserso.techfile.model.entity;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TipoRelacion
 *
 */
@Entity

public class TipoRelacion implements Serializable {

	   
	@Id
	private Long id;
	@Column(unique = true, length = 50, nullable = false)
	private String descripcion;
	private static final long serialVersionUID = 1L;

	public TipoRelacion() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
   
}
