package org.soulcodeacademy.helpr.services;


import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.dto.FuncionarioDTO;
import org.soulcodeacademy.helpr.domain.dto.FuturoCandidatoDTO;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.soulcodeacademy.helpr.repositories.FuturoCandidatoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FuturoCandidatoService {

    @Autowired
    public FuturoCandidatoRepository futuroCandidatoRepository;

    public List<FuturoCandidato> listar() {

        return this.futuroCandidatoRepository.findAll();
    }

    public FuturoCandidato getFuturoCandidato(Integer idFuturoCandidato) {
        Optional<FuturoCandidato> futuroCandidato = this.futuroCandidatoRepository.findById(idFuturoCandidato);

        if (futuroCandidato.isEmpty()) {
            throw new RecursoNaoEncontradoError("O candidato não foi encontrado.");
        }
        else{
            return futuroCandidato.get();
        }
    }

    public FuturoCandidato salvar(FuturoCandidatoDTO dto) {
        FuturoCandidato novoCandidato = new FuturoCandidato(null, dto.getNome(), dto.getEmail(), dto.getDescricaoHabilidade(), dto.getSetor());
        return this.futuroCandidatoRepository.save(novoCandidato);
    }

    public void deletar(Integer idFuturoCandidato) {
        FuturoCandidato futuroCandidato = this.getFuturoCandidato(idFuturoCandidato);
        this.futuroCandidatoRepository.delete(futuroCandidato);
    }

    public List<FuturoCandidato> listarNome(String nome) {
        return this.futuroCandidatoRepository.findByNome(nome);
    }

    public List<FuturoCandidato> ListarEmail(String email) {
        return this.futuroCandidatoRepository.findByEmail(email);
    }

    public List<FuturoCandidato> ListarSetor(String setor) {
        return this.futuroCandidatoRepository.findBySetor(setor);
    }
}