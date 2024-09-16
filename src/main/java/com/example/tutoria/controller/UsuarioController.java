package com.example.tutoria.controller;

import com.example.tutoria.request.LoginRequest;
import com.example.tutoria.request.UsuarioRequest;
import com.example.tutoria.response.UsuarioResponse;
import com.example.tutoria.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/create")
    public UsuarioResponse createUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        return usuarioService.create(usuarioRequest);
    }
    @PostMapping("/login")
    public String loginUsuario(@RequestBody LoginRequest loginRequest) {
        return usuarioService.login(loginRequest);
    }
    @GetMapping("/find")
    public UsuarioResponse findByEmail(@RequestParam String email) {
        return usuarioService.findByEmail(email);
    }
}
