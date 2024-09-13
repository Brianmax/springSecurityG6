package com.example.tutoria.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {
    private String email;
    private String password;
    private String role;
}
