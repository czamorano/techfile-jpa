package es.imserso.techfile.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

/**
 * Entity implementation class for Entity: Fichero
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "SEQ_FICHERO", initialValue = 1, allocationSize = 1, sequenceName = "SEC_FICHERO")
@Table(indexes = { @Index(name = "IDX_FICHERO_NOMBRE", columnList = "nombre", unique = true) })
public class Fichero implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FICHERO")
	private Long id;
	private static final long serialVersionUID = 1L;

	public Fichero() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "agno", referencedColumnName = "agno"),
			@JoinColumn(name = "mes", referencedColumnName = "mes") })
	private Mes mes;

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	/**
	 * Nombre del fichero
	 */
	protected String nombre;
	/**
	 * Tamaño del fichero
	 */
	protected Long tamagno;
	/**
	 * Fecha de creación del fichero en origen
	 */
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Date fechaCreacionOrigen;
	/**
	 * Fecha de alta del fichero en la aplicación
	 */
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Date fechaAltaAplicacion;
	/**
	 * Codificación del fichero
	 */
	protected String encoding;
	/**
	 * número de líneas del fichero
	 */
	protected Long lineas;

	/**
	 * bytes del fichero
	 */
	private FicheroByte ficheroByte;

	@Length(min = 0, max = 30, message = "Longitud máxima 30 caracteres")
	@NotNull(message = "El nombre del fichero no puede ser nulo")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public Long getTamagno() {
		return tamagno;
	}

	public void setTamagno(final Long tamagno) {
		this.tamagno = tamagno;
	}

	public Date getFechaCreacionOrigen() {
		return fechaCreacionOrigen;
	}

	public void setFechaCreacionOrigen(Date fechaCreacion) {
		this.fechaCreacionOrigen = fechaCreacion;
	}

	@XmlTransient
	@OneToOne(mappedBy = "fichero", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	public FicheroByte getFicheroByte() {
		return ficheroByte;
	}

	public void setFicheroByte(FicheroByte ficheroByte) {
		this.ficheroByte = ficheroByte;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((id == null) ? super.hashCode() : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Fichero))
			return false;
		final Fichero other = (Fichero) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		return true;
	}

	public Long getLineas() {
		return lineas;
	}

	public void setLineas(Long lineas) {
		this.lineas = lineas;
	}

	@Override
	public String toString() {
		return StringUtils.joinWith("-", String.valueOf(id), mes.toString(), nombre);
	}

	public Date getFechaAltaAplicacion() {
		return fechaAltaAplicacion;
	}

	public void setFechaAltaAplicacion(Date fechaAltaAplicacion) {
		this.fechaAltaAplicacion = fechaAltaAplicacion;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

}
