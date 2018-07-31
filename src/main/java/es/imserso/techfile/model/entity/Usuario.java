package es.imserso.techfile.model.entity;

import static javax.persistence.EnumType.STRING;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@SequenceGenerator(name = "SEQ_USUARIO", initialValue = 1, allocationSize = 1, sequenceName = "SEC_USUARIO")
@NamedQuery(name = "usuario.all", query = "select u from Usuario u")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
	private Long id;
	@Column(unique = true, length = 20, nullable = false)
	private String nombre;
	@Enumerated(STRING)
	@Column(nullable = true)
	private Role role;
	private static final long serialVersionUID = 1L;

	public Usuario() {
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

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
