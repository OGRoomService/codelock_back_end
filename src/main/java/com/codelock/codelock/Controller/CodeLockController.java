package com.codelock.codelock.Controller;

import java.util.List;

import javax.validation.Valid;

import com.codelock.codelock.Model.CodeLock;
import com.codelock.codelock.Model.Player;
import com.codelock.codelock.Model.Server;
import com.codelock.codelock.Repository.CodeLockRepository;
import com.codelock.codelock.Repository.PlayerRepository;
import com.codelock.codelock.Repository.ServerRepository;
import com.codelock.codelock.Service.CodeLockService;
import com.codelock.codelock.Service.ServerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/codelock")
@RequiredArgsConstructor
public class CodeLockController {
    private final CodeLockService codelockService;
    private final ServerService serverService;
    private final CodeLockRepository codelockRepo;
    private final ServerRepository serverRepo;
    private final PlayerRepository playerRepo;

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        Server server = serverService.getServerById(1L);

        if (server == null) {
            server = serverService.createServer();
        }

        codelockService.createCodeLock(server);

        return ResponseEntity.ok("CodeLock is valid");
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateLock(@Valid @RequestBody CodeLock codelock) {
        return ResponseEntity.ok("CodeLock is valid");
    }

    @PostMapping("/updateMany")
    public ResponseEntity<?> updateLockMany(@Valid @RequestBody List<CodeLock> arrCodelocks) {
        return ResponseEntity.ok("CodeLock is valid");
    }

    @GetMapping("/{id}")
    public CodeLock findById(@PathVariable long id) {
        return codelockService.findbyId(id);
    }

    private void testAddData() {
        System.out.println("Testing adding data...");

        Server server = serverRepo.findById(1L).get();
        //Server server = new Server();
        //Player player = new Player(server);
        //CodeLock codelock = new CodeLock(server);

        serverRepo.save(server);
        //playerRepo.save(player);
        //codelockRepo.save(codelock);
    }
}
