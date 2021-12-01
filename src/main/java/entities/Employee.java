package entities;

import javax.persistence.*;

@Entity
@Table (name = "employee")
public class Employee {
	private long id;
	private String lastName;
	private String firstName;
	private String mailAdress;
	private String role;
	private int phoneNumber;
	private String adress;
	
	// Appel au constructeur vide
	public void Employee () {	
	}
	
	// Précise que la colonne nommée "id" dans la bdd correspond à un id 
	@Id 
	@Column (name="id")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	// génération des getters et setters
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMailAdress() {
		return mailAdress;
	}

	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Employee [lastName=" + lastName + ", firstName=" + firstName + ", mailAdress=" + mailAdress + ", role="
				+ role + ", phoneNumber=" + phoneNumber + ", adress=" + adress + "]";
	}


	
	
	
	

}




