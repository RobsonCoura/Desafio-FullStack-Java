package br.com.juridico.totvs.fullstack.Backend.domain;

import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoDTO;

public class PontoTuristico {

    private Long id;

    private Long paisId;

    private String cidade;

    private String nome;

    private String estacaoVisita;

    public PontoTuristico(Long id, Long paisId, String cidade, String nome, String estacaoVisita) {
        this.id = id;
        this.paisId = paisId;
        this.cidade = cidade;
        this.nome = nome;
        this.estacaoVisita = estacaoVisita;
    }

    public PontoTuristico(PontoTuristicoDTO pontoTuristicoDTO) {
        this.id = pontoTuristicoDTO.getId();
        this.paisId = pontoTuristicoDTO.getPaisId();
        this.cidade = pontoTuristicoDTO.getCidade();
        this.nome = pontoTuristicoDTO.getNome();
        this.estacaoVisita = pontoTuristicoDTO.getEstacaoVisita();
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
}
