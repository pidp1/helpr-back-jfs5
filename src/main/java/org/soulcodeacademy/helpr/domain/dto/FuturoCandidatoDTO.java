package org.soulcodeacademy.helpr.domain.dto;

import javax.validation.constraints.NotBlank;

public class FuturoCandidatoDTO {

    @NotBlank(message = "O campo Nome Completo é obrigatório.")
    private String nome;

    @NotBlank(message = "O campo Email é obrigatório.")
    private String email;

    @NotBlank(message = "O campo Descrição de Habilidade é orbigatório.")
    private String descricaoHabilidade;

    @NotBlank(message = "O campo Setor é obrigatório.")
    private String setor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricaoHabilidade() {
        return descricaoHabilidade;
    }

    public void setDescricaoHabilidade(String descricaoHabilidade) {
        this.descricaoHabilidade = descricaoHabilidade;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
