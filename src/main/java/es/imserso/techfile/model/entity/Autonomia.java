package es.imserso.techfile.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Autonomia
 *
 */
@Entity

public class Autonomia implements Serializable {

	@Id
	private Long id;
	@Column(unique = true, length = 50, nullable = false)
	private String nombre;
	@OneToMany(mappedBy = "autonomia", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Provincia> provincias;
	private static final long serialVersionUID = 1L;

	public Autonomia() {
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

	public List<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}
	
	public void addProvincia(Provincia provincia) {
		provincias.add(provincia);
		provincia.setAutonomia(this);
    }
 
    public void removeProvincia(Provincia provincia) {
    	provincias.remove(provincia);
    	provincia.setAutonomia(null);
    }

}
