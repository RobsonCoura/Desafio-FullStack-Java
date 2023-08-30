package br.com.juridico.totvs.fullstack.Backend.service.dto;

import br.com.juridico.totvs.fullstack.Backend.domain.Comentario;
import br.com.juridico.totvs.fullstack.Backend.domain.PontoTuristico;

import java.util.List;

public class PontoTuristicoDTO {

    private Long id;

    private Long paisId;

    private String cidade;

    private String nome;

    private String estacaoVisita;

    private List<ComentarioDTO> comentarios;

    public PontoTuristicoDTO(Long id, Long paisId, String cidade, String nome, String estacaoVisita) {
        this.id = id;
        this.paisId = paisId;
        this.cidade = cidade;
        this.nome = nome;
        this.estacaoVisita = estacaoVisita;
    }

    public PontoTuristicoDTO(PontoTuristico pontoTuristico) {
        this.id = pontoTuristico.getId();
        this.paisId = pontoTuristico.getPaisId();
        this.cidade = pontoTuristico.getCidade();
        this.nome = pontoTuristico.getNome();
        this.estacaoVisita = pontoTuristico.getEstacaoVisita();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstacaoVisita() {
        return estacaoVisita;
    }

    public void setEstacaoVisita(String estacaoVisita) {
        this.estacaoVisita = estacaoVisita;
    }

    public List<ComentarioDTO> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
    }
}

