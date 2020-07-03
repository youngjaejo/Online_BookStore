package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dev.backend.model.*;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	public Role findByRole(String role);
}
