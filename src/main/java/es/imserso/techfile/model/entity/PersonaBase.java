package es.imserso.techfile.model.entity;

import static javax.persistence.EnumType.STRING;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Entity implementation class for Entity: PersonaBase
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonaBase implements Serializable {

	public enum TipoPension {
		JUBILACION, INVALIDEZ
	}

	public enum TipoIdentificacion {
		NIF, NIE, CODIGO_FISCAL, OTRO
	}

	@Id
	private Long id;
	@Column(length = 50, nullable = false)
	private String nombre;
	@Column(length = 50, nullable = false)
	private String apellidos;
	@Enumerated(STRING)
	private TipoIdentificacion tipoIdentificacion;
	@Column(length = 9, nullable = false, unique = false)
	private String documentoIdentificacion;
	private Long digitosControl;
	@Enumerated(STRING)
	private TipoPension tipoPension;
	private static final long serialVersionUID = 1L;

	public PersonaBase() {
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

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getDocumentoIdentificacion() {
		return documentoIdentificacion;
	}

	public void setDocumentoIdentificacion(String documentoIdentificacion) {
		this.documentoIdentificacion = documentoIdentificacion;
	}

	public TipoPension getTipoPension() {
		return tipoPension;
	}

	public void setTipoPension(TipoPension tipoPension) {
		this.tipoPension = tipoPension;
	}

	public Long getDigitosControl() {
		return digitosControl;
	}

	public void setDigitosControl(Long digitosControl) {
		this.digitosControl = digitosControl;
	}

}
