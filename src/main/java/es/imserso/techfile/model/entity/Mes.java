package es.imserso.techfile.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Mes
 *
 */
@Entity

public class Mes implements Serializable {

	@EmbeddedId
    private MesId id;
	
	private static final long serialVersionUID = 1L;

	public Mes() {
		super();
	}
	
	public MesId getId() {
        return id;
    }
 
    public void setId(MesId id) {
        this.id = id;
    }
    
    
    
   
}
