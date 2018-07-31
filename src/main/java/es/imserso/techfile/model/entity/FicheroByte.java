package es.imserso.techfile.model.entity;

import java.io.Serializable;
import java.lang.Long;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: FicheroByte
 *
 */
@Entity

public class FicheroByte implements Serializable {
	   
	@Id
	private Long id;
	private byte[] fileBytes;
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
	private Fichero fichero;
	private static final long serialVersionUID = 1L;

	public FicheroByte() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public byte[] getFileBytes() {
		return fileBytes;
	}

	public void setFileBytes(final byte[] fileBytes) {
		this.fileBytes = fileBytes;
	}
	
	public Fichero getFichero() {
		return fichero;
	}

	public void setFichero(Fichero fichero) {
		this.fichero = fichero;
	}
   
}
