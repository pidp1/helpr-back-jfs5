package org.soulcodeacademy.helpr.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class DependenteDTO {

    @NotBlank(message = "O nome do dependente é obrigatório!")
    private String nome;

    @NotNull(message = "A idade do dependente é obrigatória!")
    private Integer idade;

    @NotNull(message = "O idFuncionario é obrigatório!")
    private Integer idFuncionario;


    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getIdFuncionario() {
        return getIdFuncionario();
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }


}




