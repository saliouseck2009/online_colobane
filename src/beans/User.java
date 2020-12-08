package beans;

import java.sql.Timestamp;

public class User {
	private Long      id;
	private String    username;
    private String    email;
    private String    password;
    private String    nom;
    private String    prenom;
    private Timestamp dateInscription;
    private String phone;
    private String address;

    public Long getId() {
        return id;
    }
    public void setId( Long id ) {
        this.id = id;
    }
    
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setEmail( String email ) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }

    public Timestamp getDateInscription() {
        return dateInscription;
    }
    public void setDateInscription( Timestamp dateInscription ) {
        this.dateInscription = dateInscription;
    }
}
