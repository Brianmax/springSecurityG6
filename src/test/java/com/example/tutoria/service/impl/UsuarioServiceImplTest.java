package com.example.tutoria.service.impl;

import com.example.tutoria.entity.Role;
import com.example.tutoria.entity.Usuario;
import com.example.tutoria.repository.RoleRepository;
import com.example.tutoria.repository.UsuarioRepository;
import com.example.tutoria.request.UsuarioRequest;
import com.example.tutoria.response.UsuarioResponse;
import com.example.tutoria.service.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;

import java.awt.image.RasterOp;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioServiceImplTest {
    @Mock
    UsuarioRepository usuarioRepository;
    @Mock
    RoleRepository roleRepository;
    AuthenticationManager authenticationManager;
    JwtService jwtService;
    UserDetailsServiceImpl userDetailsService;

    @InjectMocks
    UsuarioServiceImpl usuarioService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        usuarioService = new UsuarioServiceImpl(usuarioRepository,
                authenticationManager,
                jwtService,
                userDetailsService,
                roleRepository);
    }

    @Test
    void create() {
        // respuesta
        UsuarioResponse usuarioResponse =
                new UsuarioResponse("ejemplo@gmail.com", "ADMIN");
        // input
        UsuarioRequest usuarioRequest = new UsuarioRequest(
                "ejemplo@gmail.com",
                "password",
                "ADMIN");


        // optional role
        Optional<Role> roleOptional = Optional.of(new Role(1, "ADMIN"));
        Usuario usuario = new Usuario(
                1,
                "ejemplo@gmail.com",
                "password",
                new Role(1, "ADMIN")
        );
        Mockito.when(usuarioRepository.findByEmail(Mockito.anyString())).thenReturn(Optional.empty());
        Mockito.when(roleRepository.findByNameRole(Mockito.anyString())).thenReturn(roleOptional);
        Mockito.when(usuarioRepository.save(Mockito.any(Usuario.class))).thenReturn(usuario);

        UsuarioResponse respuestaTest = usuarioService.create(usuarioRequest);

        assertNotNull(respuestaTest);
        assertEquals(respuestaTest.getEmail(), usuarioResponse.getEmail());
        assertEquals(respuestaTest.getRole(), usuarioResponse.getRole());
    }
    @Test
    void createWithFail() {
        // input
        UsuarioRequest usuarioRequest = new UsuarioRequest(
                "ejemplo@gmail.com",
                "password",
                "ADMIN");
        Optional<Role> roleOptional = Optional.of(new Role(1, "ADMIN"));
        Mockito.when(usuarioRepository.findByEmail(Mockito.anyString())).thenReturn(Optional.of(new Usuario(
                1,
                "ejemplo@gmail.com",
                "password",
                new Role(1, "ADMIN"))));

        Mockito.when(roleRepository.findByNameRole(Mockito.anyString())).thenReturn(roleOptional);

        UsuarioResponse usuarioResponse = usuarioService.create(usuarioRequest);

        assertNull(usuarioResponse);

    }
    @Test
    void login() {
    }
}