package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Dependente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.DependenteDTO;
import org.soulcodeacademy.helpr.repositories.DependenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DependenteService {

    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private FuncionarioService funcionarioService;

    // Listar todos os dependentes (GET)
    public List<Dependente> listar() {
        return this.dependenteRepository.findAll();
    }

    // Listar um pelo ID (GET)
    public Dependente getDependente(Integer idDependente) {
        Optional<Dependente> dependente = this.dependenteRepository.findById(idDependente);

        if (dependente.isEmpty()) {
            throw new RuntimeException("O dependente não foi encontrado");
        } else {
            return dependente.get(); // Vai retornar o valor da entidade dependente encontrada
        }
    }

    // Salvar um novo dependente (POST)
    public Dependente salvar(DependenteDTO dto) {
        // Verificando se o dependente existe mesmo
        Funcionario empregado = this.funcionarioService.getFuncionario(dto.getIdFuncionario());
        Dependente dependente = new Dependente(null, dto.getNome(), dto.getIdade());
        dependente.setResponsavel(empregado);
        Dependente salvo = this.dependenteRepository.save(dependente);
        return salvo;
    }

    // Atualizar um dependente (PUT)
    public Dependente atualizar(Integer idDependente, DependenteDTO dto) {
        // Busca o dependente com o idDependente
        Dependente dependenteAtual = this.getDependente(idDependente);
        // Busca os dados do empregado "dono" do dependente a ser alterado
        Funcionario responsavel = this.funcionarioService.getFuncionario(dto.getIdFuncionario());

        dependenteAtual.setNome(dto.getNome());
        dependenteAtual.setIdade(dto.getIdade());
        dependenteAtual.setResponsavel(responsavel);

        Dependente atualizado = this.dependenteRepository.save(dependenteAtual);
        return atualizado;
    }

    // Deletar um dependente
    public void deletar(Integer idDependente) {
        Dependente dependente = this.getDependente(idDependente);
        this.dependenteRepository.delete(dependente);
    }


}