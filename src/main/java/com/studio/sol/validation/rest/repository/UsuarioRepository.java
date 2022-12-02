package com.studio.sol.validation.rest.repository;

import com.studio.sol.validation.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<User, Long> {

}
