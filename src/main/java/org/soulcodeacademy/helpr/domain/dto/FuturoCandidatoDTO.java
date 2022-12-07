package org.soulcodeacademy.helpr.domain.dto;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FuturoCandidatoDTO {

    @NotNull(message="O campo Nome Completo é obrigatório.")
    private Integer idFuturoCandidato;

    @NotBlank(message = "O campo Nome Completo é obrigatório.")
    private String nome;

    @Email(message = "Email inválido")
    @NotBlank(message = "O campo Email é obrigatório.")
    private String email;

    @NotBlank(message = "O campo Descrição de Habilidade é orbigatório.")
    private String descricaoHabilidade;

    @NotBlank(message = "O campo Setor é obrigatório.")
    private String setor;

    public Integer getIdFuturoCandidato() {
        return idFuturoCandidato;
    }

    public void setIdFuturoCandidato(Integer idFuturoCandidato) {
        this.idFuturoCandidato = idFuturoCandidato;
    }

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
