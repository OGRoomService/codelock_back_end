package com.codelock.codelock.Service;

import javax.websocket.server.ServerEndpoint;

import com.codelock.codelock.Model.Server;
import com.codelock.codelock.Repository.ServerRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServerService {
    private final ServerRepository serverRepo;

    public Server getServerById(Long id) {
        try {
            return serverRepo.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    public Server createServer() {
        Server server = new Server();

        save(server);
        return server;
    }

    public Server save(Server server) {
        serverRepo.save(server);
        return server;
    }
}
