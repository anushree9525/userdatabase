package com.example.demo;

import java.net.URI;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;

import javax.validation.Valid;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller 
{
	//@Autowired 
	//private EmailService emailService;

	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	JWTTokenUtil jwtUtil;
	
	@Autowired 
	AuthenticationManager authManager;
	
	
	@GetMapping(value="/register")
	public List<Users> getUsers()
	{
		Collection userPrincipal1 = (Collection) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
	    Users userPrincipal = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(userPrincipal.getEmail() + "userprincipal Data");
		
		return (List<Users>) usersRepository.findAll();
	}
	
	
	@PostMapping(value="/adduser")
	public String  saveUser(@RequestBody Users users)
	{
		if(usersRepository.existsByPhoneNo(users.getPhoneNo()))
		{
			return "PhoneNo already Exist";
		}
		
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String password = passwordEncoder.encode(users.getPassword());
    	
    	Users newUser = new Users();
    	
    	newUser.setrole(users.getrole());
    	newUser.setFirstName(users.getFirstName());
		newUser.setLastName(users.getLastName());
		newUser.setOccupation(users.getOccupation());
		newUser.setAge(users.getAge());
		newUser.setPhoneNo(users.getPhoneNo());
		newUser.setPassword(password);
		newUser.setEmail(users.getEmail());
		
		usersRepository.save(newUser);
		return "Data saved in Database";
	}
	
	
	public ResponseEntity<Users> create(@RequestBody @Valid Users users)
	{
        Users savedUsers = usersRepository.save(users);
        URI usersURI = URI.create("/users/" + savedUsers.getId());
        return ResponseEntity.created(usersURI).body(savedUsers);
    }
	
    @PutMapping(value = "update/{id}")
	public String updateUsers(@PathVariable long id, @RequestBody Users users)
    {
    	
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String password = passwordEncoder.encode(users.getPassword());
		
		Users updatedUser = usersRepository.findById(id).get();
		
		updatedUser.setrole(users.getrole());
		updatedUser.setFirstName(users.getFirstName());
		updatedUser.setLastName(users.getLastName());
		updatedUser.setAge(users.getAge());
		updatedUser.setOccupation(users.getOccupation());
		updatedUser.setEmail(users.getEmail());
		updatedUser.setPassword(password);
		updatedUser.setPhoneNo(users.getPhoneNo());
		
		usersRepository.save(updatedUser);
		return "Updated User info successfully...";
	}
    
    
    /*@PostMapping("/sendMail")
    public String
    sendMail(@RequestBody EmailDetails details)
    {
        String status= emailService.sendMail(details);
        return status;
    }*/
 
    
    
}
    
    
    
    
    
    
    
    
