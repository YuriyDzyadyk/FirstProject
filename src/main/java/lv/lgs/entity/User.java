package lv.lgs.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id //каже що поле id буде виконувати роль стовпц€ id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int Id;
	@Column( name = "name")
	String name;
	@Column( name = "mail")
	String mail;
	@Column( name = "password")
	String password;
	@Enumerated(EnumType.ORDINAL)
	Role rolle;
	
	
	
	public User(String name, String password, Role rolle) {
		super();
		this.name = name;
		this.password = password;
		this.rolle = rolle;
	}
	
	public Role getRolle() {
		return rolle;
	}

	public void setRolle(Role rolle) {
		this.rolle = rolle;
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
