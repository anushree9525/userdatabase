package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>
{
	Optional<Users> findByEmail(String email);
	Optional<Users> findByPhoneNo(String phoneNo);
	Optional<Users> findById(Long Id);
	
	static Users findByidIgnoreCase(String Id) 
	{
		return null;
	}

	boolean existsByPhoneNo(String phoneNo);
	boolean existsById(Long id);
	
	
	
}
