package br.com.juridico.totvs.fullstack.Backend.service;

import br.com.juridico.totvs.fullstack.Backend.domain.PontoTuristico;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoDTO;

import java.util.List;

public interface PontoTuristicoService {
    List<PontoTuristico> listPontoTuristico = null;

    public PontoTuristicoDTO create(PontoTuristicoCreateUpdateDTO pontoTuristicoCreateUpdateDTO);

    public PontoTuristicoDTO update(Long id, PontoTuristicoCreateUpdateDTO pontoTuristicoCreateUpdateDTO);

    public void delete(Long id);

    public PontoTuristicoDTO getPontoTuristicobyId(Long id);

    public List<PontoTuristicoDTO> getPontoTuristicoByPaisId(Long paisId);

    public List<PontoTuristicoDTO> getPontoTuristicoByEstacaoVisita(String estacaoVisita);

    public List<PontoTuristicoDTO> getAllPontoTuristico();
}
