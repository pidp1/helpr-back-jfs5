package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Usuario;
import org.soulcodeacademy.helpr.domain.dto.UsuarioDTO;
import org.soulcodeacademy.helpr.domain.enums.Perfil;
import org.soulcodeacademy.helpr.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    //O controller deve expôr os seguintes endpoints:
    // /usuarios/{email} (GET): Listar o usuário com o email indicado no Path Variable;
    // /usuarios/{cpf} (GET): Listar o usuário com o cpf indicado no Path Variable;
    // /usuarios/busca (GET): Listar os usuários com o termo de busca indicado no Request Param;
    // /usuarios/{id}/perfil (GET): Listar o perfil (enum) do usuário com base no id indicado.
