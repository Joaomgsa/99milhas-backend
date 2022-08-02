package br.com.milhas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.milhas.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
	
	public Optional<UserModel> findByLogin(String Login);

}
