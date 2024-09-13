package com.example.tutoria.controller;

import com.example.tutoria.request.LoginRequest;
import com.example.tutoria.request.UsuarioRequest;
import com.example.tutoria.response.UsuarioResponse;
import com.example.tutoria.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;
    @PostMapping("/create")
    public UsuarioResponse createUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        return usuarioService.create(usuarioRequest);
    }
    @PostMapping("/login")
    public String loginUsuario(@RequestBody LoginRequest loginRequest) {
        return usuarioService.login(loginRequest);
    }
}
