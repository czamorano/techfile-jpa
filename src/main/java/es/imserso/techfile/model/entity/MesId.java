package es.imserso.techfile.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

/**
 * Entity implementation class for Entity: Mes
 *
 */
@Embeddable
public class MesId implements Serializable {

	@Column(name = "agno")
	private Short agno;
	@Column(name = "mes")
	private Short mes;
	private static final long serialVersionUID = 1L;

	public MesId() {
		super();
	}

	public MesId(Short agno, Short mes) {
		super();
		this.agno = agno;
		this.mes = mes;
	}

	public Short getAgno() {
		return this.agno;
	}

	public void setAgno(Short agno) {
		this.agno = agno;
	}

	public Short getMes() {
		return this.mes;
	}

	public void setMes(Short mes) {
		this.mes = mes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof MesId))
			return false;
		MesId that = (MesId) o;
		return Objects.equals(getAgno(), that.getAgno()) && Objects.equals(getMes(), that.getMes());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getAgno(), getMes());
	}

	@Transient
	public String getLiteralMes() {
		return Meses.values()[this.mes].toString();
	}

	enum Meses {
		ZERO, ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE
	}

	@Override
	public String toString() {
		return StringUtils.joinWith("-", String.valueOf(agno), getLiteralMes());
	}

}
