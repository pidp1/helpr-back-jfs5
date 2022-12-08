package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.dto.FuturoCandidatoDTO;
import org.soulcodeacademy.helpr.services.FuturoCandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FuturoCandidatoController {

    @Autowired
    private FuturoCandidatoService futuroCandidatoService;

    @GetMapping("/candidatos")
    public List<FuturoCandidato> listar() {
        return this.futuroCandidatoService.listar();
    }

    @GetMapping("/candidatos/setor")
    public List<FuturoCandidato> ListarSetor(@RequestParam String setor) {
        return this.futuroCandidatoService.ListarSetor(setor);
    }

    @GetMapping("/candidatos/email")
    public List<FuturoCandidato> ListarEmail(@RequestParam String email) {
        return this.futuroCandidatoService.ListarEmail(email);
    }

    @GetMapping("/candidatos/nome")
    public List<FuturoCandidato> listarNome(@RequestParam String nome) {
        return this.futuroCandidatoService.listarNome(nome);
    }

    @PostMapping("/candidatos")
    public FuturoCandidato salvar(@Valid @RequestBody FuturoCandidatoDTO dto) {
        return this.futuroCandidatoService.salvar(dto);
    }

    @DeleteMapping("/candidatos/{idFuturoCandidato}")
    public void deletar(@PathVariable Integer idFuturoCandidato) {
        this.futuroCandidatoService.deletar(idFuturoCandidato);
    }
}
