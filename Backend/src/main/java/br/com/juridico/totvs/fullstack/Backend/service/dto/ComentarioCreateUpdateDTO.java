package br.com.juridico.totvs.fullstack.Backend.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ComentarioCreateUpdateDTO {

    private Long pontoTuristicoId;

    private String descricao;

    private String nomeDoAutor;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataDaCriacao;

    public ComentarioCreateUpdateDTO() {
    }

    public Long getPontoTuristicoId() {
        return pontoTuristicoId;
    }

    public void setPontoTuristicoId(Long pontoTuristicoId) {
        this.pontoTuristicoId = pontoTuristicoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeDoAutor() {
        return nomeDoAutor;
    }

    public void setNomeDoAutor(String nomeDoAutor) {
        this.nomeDoAutor = nomeDoAutor;
    }

    public LocalDateTime getDataDaCriacao() {
        return dataDaCriacao;
    }

    public void setDataDaCriacao(LocalDateTime dataDaCriacao) {
        this.dataDaCriacao = dataDaCriacao;
    }
}
