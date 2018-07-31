package es.imserso.techfile.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Etiologia
 *
 */
@Entity

public class Etiologia implements Serializable {

	
	@Id
	private Long id;
	@Column(unique = true, length = 100, nullable = false)
	private String descripcion;
	@ManyToMany(mappedBy = "etiologias")
	List<Pensionista> pensionistas;
	private static final long serialVersionUID = 1L;

	public Etiologia() {
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
	public List<Pensionista> getPensionistas() {
		return pensionistas;
	}
	public void setPensionistas(List<Pensionista> pensionistas) {
		this.pensionistas = pensionistas;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etiologia etiologia = (Etiologia) o;
        return Objects.equals(descripcion, etiologia.descripcion);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(descripcion);
    }
   
}