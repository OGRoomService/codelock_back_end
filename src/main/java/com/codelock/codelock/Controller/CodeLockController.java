package com.codelock.codelock.Controller;

import java.util.List;

import javax.validation.Valid;

import com.codelock.codelock.Model.CodeLock;
import com.codelock.codelock.Service.CodeLockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/codelock")
public class CodeLockController {
    @Autowired
    CodeLockService codelockService;

    @PostMapping("/update")
    public ResponseEntity<String> updateLock(@Valid @RequestBody CodeLock codelock) {
        return ResponseEntity.ok("CodeLock is valid");
    }

    @PostMapping("/updateMany")
    public ResponseEntity<String> updateLockMany(@Valid @RequestBody List<CodeLock> arrCodelocks) {
        return ResponseEntity.ok("CodeLock is valid");
    }

    @GetMapping("/{id}")
    public CodeLock findById(@PathVariable long id) {
        return codelockService.findbyId(id);
    }
}
