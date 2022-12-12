package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Usuario;
import org.soulcodeacademy.helpr.domain.enums.Perfil;
import org.soulcodeacademy.helpr.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    // /usuarios/{email} (GET): Listar o usuário com o email indicado no Path Variable;
    @GetMapping("/usuarios/email/{emaill}")
    public Usuario getUsuario(@PathVariable String emaill) {
        return usuarioService.listarEmail(emaill);
    }

    @GetMapping("/usuarios/cpf/{cpff}")
    public Usuario getUsuarioCpf(@PathVariable String cpff) {
        return usuarioService.listarCpf(cpff);
    }

    // /usuarios/busca?nome=Renato
    @GetMapping("/usuarios/busca")
    public List<Usuario> Listar(@RequestParam String nome) {
        return this.usuarioService.findByNomeContaining(nome);
    }

    // retornar o perfil do usuario com base na busca pelo id indicado no parâmetro do endpoint
    @GetMapping("/usuario/{idUsuario}/perfil")
    public Perfil ListarId(@PathVariable Integer idUsuario){
        return this.usuarioService.listarPerfil(idUsuario);
    }
}

