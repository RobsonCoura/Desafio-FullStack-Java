package br.com.juridico.totvs.fullstack.Backend.service.dto;

public class PontoTuristicoCreateUpdateDTO {

    private Long paisId;

    private String cidade;

    private String nome;

    private String estacaoVisita;

    public PontoTuristicoCreateUpdateDTO() {
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
