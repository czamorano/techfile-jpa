package es.imserso.techfile.model.entity;

import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * Entity implementation class for Entity: Pensionista
 *
 */
@Entity
@SequenceGenerator(name = "SEQ_PENSIONISTA", initialValue = 1, allocationSize = 1, sequenceName = "SEC_PENSIONISTA")

public class Pensionista implements Serializable {

	/**
	 * Identificador del pensionista en la aplicación
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PENSIONISTA")
	private Long id;
	/**
	 * Datos personales del pensionista
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private PersonaBase pensionista;
	/**
	 * Clave Numérica de la Autonomía
	 */
	@Column(nullable = false)
	private Autonomia autonomia;
	/**
	 * Clave Numérica de la Provincia
	 */
	@Column(nullable = false)
	private Provincia provincia;
	/**
	 * 
	 */
	@Column(nullable = false)
	private Long situacionPension;
	/**
	 * 
	 */
	private BigDecimal ingresosTotalesAnuales;
	/**
	 * 
	 */
	private Boolean trabaja;
	/**
	 * 
	 */
	private PensionConcurrente codigoPrimeraPensionConcurrente;
	/**
	 * 
	 */
	private PensionConcurrente codigoSegundaPensionConcurrente;
	/**
	 * 
	 */
	private RegimenProcedencia regimenProcedencia;
	/**
	 * 
	 */
	private Short totalConvivientes;
	/**
	 * 
	 */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "pensionista_id")
	private List<Persona> convivientes;
	private BigDecimal ingresosAnualesConvivientes;
	/**
	 * 
	 */
	private Short gradoMinusvalia;
	/**
	 * 
	 */
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "pensionista_discapacidad", joinColumns = @JoinColumn(name = "pensionista_id"), inverseJoinColumns = @JoinColumn(name = "discapacidad_id"))
	private List<Discapacidad> discapacidades;
	/**
	 * 
	 */
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "pensionista_diagnostico", joinColumns = @JoinColumn(name = "pensionista_id"), inverseJoinColumns = @JoinColumn(name = "discapacidad_id"))
	private List<Diagnostico> diagnosticos;
	/**
	 * 
	 */
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "pensionista_etiologia", joinColumns = @JoinColumn(name = "pensionista_id"), inverseJoinColumns = @JoinColumn(name = "discapacidad_id"))
	private List<Etiologia> etiologias;
	/**
	 * 
	 */
	private Short porcentajeDiscapacidad;
	/**
	 * Total del baremo de factores sociales y complementarios
	 */
	private Short baremoFactoresSocialesComplementarios;
	/**
	 * Total baremo de necesidad de otra Persona
	 */
	private Short baremoNecesidadTerceraPersona;
	/**
	 * Fecha en que solicitó la pensión
	 */
	@Temporal(DATE)
	private Date fechaSolicitudPension;
	/**
	 * Fecha de resolución de la pensión
	 */
	@Temporal(DATE)
	private Date fechaResolucionPension;
	/**
	 * Año y mes de alta en Nómina
	 */
	@Temporal(DATE)
	private Date fechaAltaNomina;
	/**
	 * Importe Mensual de la Pensión
	 */
	private BigDecimal importeMensualPension;
	/**
	 * Importe Mensual por complemento necesidad de otra persona
	 */
	private BigDecimal importeMensualComplementoTerceraPersona;
	/**
	 * Código de relación del perceptor con el Pensionista
	 */
	@Column(nullable = false)
	private TipoRelacion relacionPerceptorPensionista;
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@MapsId
	private PersonaBase perceptor;
	/**
	 * Sistemas de Cobro de la Pensión
	 */
	@NotNull
	private FormaCobro formaCobro;
	/**
	 * Código de entidad bancaria conforme el Consejo Superior Bancario
	 */
	private Long entidadBancaria;
	/**
	 * Código de agencia bancaria conforme el Consejo Superior Bancario
	 */
	@Column()
	private Long agenciaBancaria;
	/**
	 * Número de Cuenta Bancaria
	 */
	@Column(length = 15)
	@Length(max = 15, message = "el número de cuenta no puede exceder los 15 caracteres")
	private String numeroCuenta;

	private static final long serialVersionUID = 1L;

	public Pensionista() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Autonomia getAutonomia() {
		return this.autonomia;
	}

	public void setAutonomia(Autonomia autonomia) {
		this.autonomia = autonomia;
	}

	public enum SituacionPension {
		ALTA, SUSPENSION_DE_PAGO
	}

	public enum FormaCobro {
		DIRECTO_EN_VENTANILLA, INGRESO_EN_CUENTA
	}

	public void addDiscapacidad(Discapacidad discapacidad) {
		discapacidades.add(discapacidad);
		discapacidad.getPensionistas().add(this);
	}

	public void removeDiscapacidad(Discapacidad discapacidad) {
		discapacidades.remove(discapacidad);
		discapacidad.getPensionistas().remove(this);
	}

	public void addDiagnostico(Diagnostico diagnostico) {
		diagnosticos.add(diagnostico);
		diagnostico.getPensionistas().add(this);
	}

	public void removeDiagnostico(Diagnostico diagnostico) {
		diagnosticos.remove(diagnostico);
		diagnostico.getPensionistas().remove(this);
	}

	public void addEtiologia(Etiologia etiologia) {
		etiologias.add(etiologia);
		etiologia.getPensionistas().add(this);
	}

	public void removeEtiologia(Etiologia etiologia) {
		etiologias.remove(etiologia);
		etiologia.getPensionistas().remove(this);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Pensionista))
			return false;
		return id != null && id.equals(((Pensionista) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	public PersonaBase getPensionista() {
		return pensionista;
	}

	public void setPensionista(PersonaBase pensionista) {
		this.pensionista = pensionista;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Long getSituacionPension() {
		return situacionPension;
	}

	public void setSituacionPension(Long situacionPension) {
		this.situacionPension = situacionPension;
	}

	public BigDecimal getIngresosTotalesAnuales() {
		return ingresosTotalesAnuales;
	}

	public void setIngresosTotalesAnuales(BigDecimal ingresosTotalesAnuales) {
		this.ingresosTotalesAnuales = ingresosTotalesAnuales;
	}

	public Boolean getTrabaja() {
		return trabaja;
	}

	public void setTrabaja(Boolean trabaja) {
		this.trabaja = trabaja;
	}

	public PensionConcurrente getCodigoPrimeraPensionConcurrente() {
		return codigoPrimeraPensionConcurrente;
	}

	public void setCodigoPrimeraPensionConcurrente(PensionConcurrente codigoPrimeraPensionConcurrente) {
		this.codigoPrimeraPensionConcurrente = codigoPrimeraPensionConcurrente;
	}

	public PensionConcurrente getCodigoSegundaPensionConcurrente() {
		return codigoSegundaPensionConcurrente;
	}

	public void setCodigoSegundaPensionConcurrente(PensionConcurrente codigoSegundaPensionConcurrente) {
		this.codigoSegundaPensionConcurrente = codigoSegundaPensionConcurrente;
	}

	public RegimenProcedencia getRegimenProcedencia() {
		return regimenProcedencia;
	}

	public void setRegimenProcedencia(RegimenProcedencia regimenProcedencia) {
		this.regimenProcedencia = regimenProcedencia;
	}

	public Short getTotalConvivientes() {
		return totalConvivientes;
	}

	public void setTotalConvivientes(Short totalConvivientes) {
		this.totalConvivientes = totalConvivientes;
	}

	public List<Persona> getConvivientes() {
		return convivientes;
	}

	public void setConvivientes(List<Persona> convivientes) {
		this.convivientes = convivientes;
	}

	public BigDecimal getIngresosAnualesConvivientes() {
		return ingresosAnualesConvivientes;
	}

	public void setIngresosAnualesConvivientes(BigDecimal ingresosAnualesConvivientes) {
		this.ingresosAnualesConvivientes = ingresosAnualesConvivientes;
	}

	public Short getGradoMinusvalia() {
		return gradoMinusvalia;
	}

	public void setGradoMinusvalia(Short gradoMinusvalia) {
		this.gradoMinusvalia = gradoMinusvalia;
	}

	public List<Discapacidad> getDiscapacidades() {
		return discapacidades;
	}

	public void setDiscapacidades(List<Discapacidad> discapacidades) {
		this.discapacidades = discapacidades;
	}

	public List<Diagnostico> getDiagnosticos() {
		return diagnosticos;
	}

	public void setDiagnosticos(List<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}

	public List<Etiologia> getEtiologias() {
		return etiologias;
	}

	public void setEtiologias(List<Etiologia> etiologias) {
		this.etiologias = etiologias;
	}

	public Short getPorcentajeDiscapacidad() {
		return porcentajeDiscapacidad;
	}

	public void setPorcentajeDiscapacidad(Short porcentajeDiscapacidad) {
		this.porcentajeDiscapacidad = porcentajeDiscapacidad;
	}

	public Short getBaremoFactoresSocialesComplementarios() {
		return baremoFactoresSocialesComplementarios;
	}

	public void setBaremoFactoresSocialesComplementarios(Short baremoFactoresSocialesComplementarios) {
		this.baremoFactoresSocialesComplementarios = baremoFactoresSocialesComplementarios;
	}

	public Short getBaremoNecesidadTerceraPersona() {
		return baremoNecesidadTerceraPersona;
	}

	public void setBaremoNecesidadTerceraPersona(Short baremoNecesidadTerceraPersona) {
		this.baremoNecesidadTerceraPersona = baremoNecesidadTerceraPersona;
	}

	public Date getFechaSolicitudPension() {
		return fechaSolicitudPension;
	}

	public void setFechaSolicitudPension(Date fechaSolicitudPension) {
		this.fechaSolicitudPension = fechaSolicitudPension;
	}

	public Date getFechaResolucionPension() {
		return fechaResolucionPension;
	}

	public void setFechaResolucionPension(Date fechaResolucionPension) {
		this.fechaResolucionPension = fechaResolucionPension;
	}

	public Date getFechaAltaNomina() {
		return fechaAltaNomina;
	}

	public void setFechaAltaNomina(Date fechaAltaNomina) {
		this.fechaAltaNomina = fechaAltaNomina;
	}

	public BigDecimal getImporteMensualPension() {
		return importeMensualPension;
	}

	public void setImporteMensualPension(BigDecimal importeMensualPension) {
		this.importeMensualPension = importeMensualPension;
	}

	public BigDecimal getImporteMensualComplementoTerceraPersona() {
		return importeMensualComplementoTerceraPersona;
	}

	public void setImporteMensualComplementoTerceraPersona(BigDecimal importeMensualComplementoTerceraPersona) {
		this.importeMensualComplementoTerceraPersona = importeMensualComplementoTerceraPersona;
	}

	public TipoRelacion getRelacionPerceptorPensionista() {
		return relacionPerceptorPensionista;
	}

	public void setRelacionPerceptorPensionista(TipoRelacion relacionPerceptorPensionista) {
		this.relacionPerceptorPensionista = relacionPerceptorPensionista;
	}

	public PersonaBase getPerceptor() {
		return perceptor;
	}

	public void setPerceptor(PersonaBase perceptor) {
		this.perceptor = perceptor;
	}

	public FormaCobro getFormaCobro() {
		return formaCobro;
	}

	public void setFormaCobro(FormaCobro formaCobro) {
		this.formaCobro = formaCobro;
	}

	public Long getEntidadBancaria() {
		return entidadBancaria;
	}

	public void setEntidadBancaria(Long entidadBancaria) {
		this.entidadBancaria = entidadBancaria;
	}

	public Long getAgenciaBancaria() {
		return agenciaBancaria;
	}

	public void setAgenciaBancaria(Long agenciaBancaria) {
		this.agenciaBancaria = agenciaBancaria;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

}
