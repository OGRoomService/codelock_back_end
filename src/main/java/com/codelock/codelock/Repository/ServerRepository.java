package com.codelock.codelock.Repository;

import com.codelock.codelock.Model.Server;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server, Long> {
    
}
