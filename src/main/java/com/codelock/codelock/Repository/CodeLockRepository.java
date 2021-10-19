package com.codelock.codelock.Repository;

import com.codelock.codelock.Model.CodeLock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeLockRepository extends JpaRepository<CodeLock, Long> {
    
}
