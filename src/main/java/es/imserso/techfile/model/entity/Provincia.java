package es.imserso.techfile.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Provincia
 *
 */
@Entity

public class Provincia implements Serializable {

	@Id
	private Long id;
	@Column(unique = true, length = 50, nullable = false)
	private String nombre;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "autonomia_id")
	private Autonomia autonomia;
	private static final long serialVersionUID = 1L;

	public Provincia() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Autonomia getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(Autonomia autonomia) {
		this.autonomia = autonomia;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Provincia))
			return false;
		return id != null && id.equals(((Provincia) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

}
