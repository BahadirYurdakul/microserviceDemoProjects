package pluralsight.demo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GenerationType;

@Entity
public class Personel {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PER_SEQ")
    @SequenceGenerator(sequenceName = "per_seq", allocationSize = 1, name = "PER_SEQ")
	private
    Long id;
	
    private String name;
    
	private String email;

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
    
    @Column(name = "UPDATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
    
    @PrePersist
    protected void onCreate() {
    	createdDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
    	updatedDate = new Date();
    }
    
    public static Personel mergePersonel(Personel personelToUpdate, Personel personelParams) {
    	if(personelParams.getEmail() != null)
    		personelToUpdate.setEmail(personelParams.getEmail());
    	if(personelParams.getName() != null)
    		personelToUpdate.setName(personelParams.getName());
    	return personelToUpdate;
    }

    protected Personel() {}

    public Personel(String name, String email) {
        this.setName(name);
        this.setEmail(email);
    }

    @Override
    public String toString() {
        return String.format(
                "Personel[id=%d, name='%s', email='%s', createdDate='%s']",
                getId(), getName(), getEmail(), getCreatedDate());
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}