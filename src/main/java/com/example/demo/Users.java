package com.example.demo;
 
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "Details")
public class Users implements UserDetails
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
	@NotNull @Length(min = 3, max = 50, message = "Firstname should not be null")
	private String firstName;
	
	@Column(nullable = false, length = 50)
	@NotNull @Length(min = 3, max = 50, message = "Lastname should not be null")
	private String lastName;
	
	@Column
	private int age;
	
	@Column
	private String occupation;
	
	
	@Column 
	private String phoneNo;
	
	
	@Column(nullable = false, unique = true, length = 50)
	private String email;
	
	@Column(nullable = false, length = 64)
	private String password;
	
	
	@Column
	private String role;
	
	
	public Users() {}
	
	public Users(String email, String password)
	{
		this.email = email;
		this.password = password;
	}
	
	public long getId() 
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	
	
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	
	
	public String getOccupation()
	{
		return occupation;
	}
	public void setOccupation(String occupation) 
	{
		this.occupation = occupation;
	}
	
	
	public String getPhoneNo() 
	{
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) 
	{
		this.phoneNo = phoneNo;
	}
	
	
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getrole()
	{
		return role;
	}
	public void setrole(String role) 
	{
		this.role = role;
	}
	

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
 
    @Override
    public String getUsername() 
    {
        return this.email;
    }
 
    @Override
    public boolean isAccountNonExpired() 
    {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }
 
    @Override
    public boolean isEnabled() 
    {
        return true;
    }
    
    public String getPhoneNumber()
	{
		return phoneNo;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNo = phoneNumber;
	}
}
