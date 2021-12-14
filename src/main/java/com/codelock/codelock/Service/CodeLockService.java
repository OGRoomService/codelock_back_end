package com.codelock.codelock.Service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.codelock.codelock.Model.CodeLock;
import com.codelock.codelock.Model.Server;
import com.codelock.codelock.Repository.CodeLockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeLockService {
    @Autowired
    CodeLockRepository codelockRepository;

    public List<CodeLock> findAll() {
        return codelockRepository.findAll();
    }

    public CodeLock findbyId(long id) {
        return codelockRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public CodeLock createCodeLock(Server server) {
        CodeLock codelock = new CodeLock(server);
        save(codelock);
        return codelock;
    }
    
    public CodeLock save(CodeLock codelock) {
        return codelockRepository.save(codelock);
    }
}
