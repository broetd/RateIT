package ch.bbc.rateit.model;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the customer database table.
 * 
 */
@Named
@Entity
@NamedQueries({
       @NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
       @NamedQuery(name="User.findByUsernameAndPassword", query ="SELECT u FROM User u WHERE u.username = :userName AND u.password = :userPW")
})

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUser;

	private String username;

	private String password;
	
	private String name;
	
	private String surname;

	public User() {
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}