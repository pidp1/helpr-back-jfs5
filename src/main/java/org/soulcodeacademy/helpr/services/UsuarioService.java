package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Usuario;
import org.soulcodeacademy.helpr.domain.enums.Perfil;
import org.soulcodeacademy.helpr.repositories.UsuarioRepository;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    // buscando o usuario pelo id, caso não retorne o usuario será lançado uma exceção
    public Usuario getUsuario(Integer idUsuario) {
        return this.usuarioRepository.findById(idUsuario)
                .orElseThrow(()-> new RecursoNaoEncontradoError("O Usuario não foi encontrado!"));
    }

    public List<Usuario> listar() {

        return usuarioRepository.findAll();
    }

    public Usuario listarEmail(String email) {
        return this.usuarioRepository.findByEmail(email)
                .orElseThrow(()-> new RecursoNaoEncontradoError("O Email não foi encontrado!"));
    }

    public Usuario listarCpf(String cpf) {

        return this.usuarioRepository.findByCpf(cpf)
                .orElseThrow(()-> new RecursoNaoEncontradoError("O Cpf não foi encontrado!"));
    }


    public List<Usuario> listarNome(String nome) {
        // armazenando a lista de usuario dentro da variavel usuario
        List<Usuario> usuarios = this.usuarioRepository.findByNome(nome);
        // verificando se não possui nenhum usuario dentro da lista c esse nome
        if (usuarios.isEmpty()) {
            throw new RecursoNaoEncontradoError("Nenhum usuario encontrado com esse nome");
        } else {
            // retornando a lista com usuarios encontrados
            return usuarios;
        }
    }

    public List<Usuario> findByNomeContaining(String buscar){
        List<Usuario> usuarios = this.usuarioRepository.findByNomeContaining(buscar);
        if (usuarios.isEmpty()){
            throw new RecursoNaoEncontradoError("Nenhum usuario encontrado com esse nome");
        } else {
            return usuarios;
        }
    }

    public Perfil listarPerfil(Integer idUsuario) {
        // buscando o usuario pelo id e armazenando na variavel usuario encontrado
        Usuario usuarioEncontrado = this.getUsuario(idUsuario);
        // armazenando o perfil do usuario encontrado na variavel perfil encontrado
        Usuario perfilEncontrado = this.listarEmail(usuarioEncontrado.getEmail());
        // extraido o perfil do perfil encontrado
        return perfilEncontrado.getPerfil();
    }
}

