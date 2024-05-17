package com.aditya.CRUD.UserMgmtSys.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userid;
	
	@NotEmpty(message = "Enter Valid Name *Cannot be Null or Empty ")
	@Column(name="First Name")
	String firstname;
	
	@NotEmpty(message = "Enter Valid Name *Cannot be Null or Empty ")
	@Column(name="Last Name")
	String l_name;
	
	@NotEmpty(message = "Password is required")
    @Size(min = 3, message = "Password must be at least 3 characters long")
    @Pattern(regexp = ".*[A-Z].*", message = "Password must contain at least one uppercase letter")
    @Pattern(regexp = ".*[a-z].*", message = "Password must contain at least one lowercase letter")
    @Pattern(regexp = ".*\\d.*", message = "Password must contain at least one digit")
    @Pattern(regexp = ".*[^a-zA-Z0-9].*", message = "Password must contain at least one special character")
	@Column(name="Password")
	String password;
	
	
	
	@NotEmpty(message = "Password is required")
    @Size(min = 3, message = "Password must be at least 3 characters long")
    @Pattern(regexp = ".*[A-Z].*", message = "Password must contain at least one uppercase letter")
    @Pattern(regexp = ".*[a-z].*", message = "Password must contain at least one lowercase letter")
    @Pattern(regexp = ".*\\d.*", message = "Password must contain at least one digit")
    @Pattern(regexp = ".*[^a-zA-Z0-9].*", message = "Password must contain at least one special character")
	@Column(name="Confirm Password")
	String con_password;
	
	@NotEmpty(message = "Enter Valid Name *Cannot be Null or Empty* ")
//	@Email
	@Pattern(regexp = "^(.+)@(.+)$" , message = "Enter Valid EmailId" )
	@Column(name="Email Id")
	String email;
	
	@NotNull(message = "Phone number is required")
    @Min(value = 1000000000L, message = "Phone number must be at least 10 digits")
    @Max(value = 9999999999L, message = "Phone number must be at most 10 digits")
	@Column(name="Phone Number")
	Long phno;

	public String getFirstname() {
		return firstname;
	}

	public User(int userid, String firstname, String l_name, String password, String con_password, String email, Long phno) {
		super();
		this.userid=userid;
		this.firstname = firstname;
		this.l_name = l_name;
		this.password = password;
		this.con_password = con_password;
		this.email = email;
		this.phno = phno;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCon_password() {
		return con_password;
	}

	public void setCon_password(String con_password) {
		this.con_password = con_password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	@Override
	public String toString() {
		return "User [iuserid=" + userid + ", firstname=" + firstname + ", l_name=" + l_name + ", password=" + password
				+ ", con_password=" + con_password + ", email=" + email + ", phno=" + phno + "]";
	}

	public User() {
		super();
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}



	
	
}
