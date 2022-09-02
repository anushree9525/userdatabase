package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthAPI
{

	@Autowired 
	AuthenticationManager authManager;
	
	@Autowired
	UsersRepository usersRepository;
	
    @Autowired 
    JWTTokenUtil jwtUtil;
    
    @ModelAttribute("Data")
    public AuthRequest authRequest() {
    	return new AuthRequest();
    }
    
    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
                    );
            
            Users users = (Users) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(users);
            AuthResponse response = new AuthResponse(users.getEmail(), accessToken);
            
            
            return ResponseEntity.ok().body(response);
            
            /*if(usersRepository.existsByPhoneNo(users.getPhoneNo())) {
    			return  ;
    		}*/
            
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
    }
	
    
    public String submitForm(@Valid @ModelAttribute("Data") AuthRequest authRequest, BindingResult bindingResult) {
    	if (bindingResult.hasErrors()) {
    		return "singUp Again";
    	}
    	return "Success";
    }

}
