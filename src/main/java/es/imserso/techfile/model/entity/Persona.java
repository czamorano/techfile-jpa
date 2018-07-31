package es.imserso.techfile.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Persona
 *
 */
@Entity

public class Persona extends PersonaBase implements Serializable {

	private Date fechaNacimiento;
	private Sexo sexo;
	private EstadoCivil estadoCivil;
	private String domicilio;
	private Long codigoPostal;
	private String localidad;
	private Long municipio;
	private Long nacionalidad;
	private Long numeroSeguridadSocial;

	private static final long serialVersionUID = 1L;

	public Persona() {
		super();
	}

	public enum Sexo {
		HOMBRE, MUJER
	}

	public enum EstadoCivil {
		SOLTERO, CASADO, VIUDO, DIVORCIADO, SEPARADO
	}

	

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Long getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Long codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Long getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Long municipio) {
		this.municipio = municipio;
	}

	public Long getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Long nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Long getNumeroSeguridadSocial() {
		return numeroSeguridadSocial;
	}

	public void setNumeroSeguridadSocial(Long numeroSeguridadSocial) {
		this.numeroSeguridadSocial = numeroSeguridadSocial;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
