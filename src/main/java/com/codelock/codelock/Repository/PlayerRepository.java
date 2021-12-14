package com.codelock.codelock.Repository;

import com.codelock.codelock.Model.Player;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    
}
