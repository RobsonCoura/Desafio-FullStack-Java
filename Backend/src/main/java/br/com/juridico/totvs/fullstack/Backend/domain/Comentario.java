package br.com.juridico.totvs.fullstack.Backend.domain;

import br.com.juridico.totvs.fullstack.Backend.service.dto.ComentarioDTO;

import java.time.LocalDateTime;

public class Comentario {

    private Long id;

    private Long pontoTuristicoId;

    private String descricao;

    private String nomeDoAutor;

    private LocalDateTime dataDaCriacao;

    public Comentario(Long id, Long pontoTuristicoId, String descricao, String nomeDoAutor, LocalDateTime dataDaCriacao) {
        this.id = id;
        this.pontoTuristicoId = pontoTuristicoId;
        this.descricao = descricao;
        this.nomeDoAutor = nomeDoAutor;
        this.dataDaCriacao = dataDaCriacao;
    }

    public Comentario(ComentarioDTO comentarioDTO) {
        this.id = comentarioDTO.getId();
        this.pontoTuristicoId = comentarioDTO.getPontoTuristicoId();
        this.descricao = comentarioDTO.getDescricao();
        this.nomeDoAutor = comentarioDTO.getNomeDoAutor();
        this.dataDaCriacao = comentarioDTO.getDataDaCriacao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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