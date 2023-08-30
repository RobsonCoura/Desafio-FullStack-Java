package br.com.juridico.totvs.fullstack.Backend.service;

import br.com.juridico.totvs.fullstack.Backend.domain.PontoTuristico;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class PontoTuristicoServiceImpl implements PontoTuristicoService {
    List<PontoTuristico> listPontoTuristico = null;

    private final ComentarioService comentarioService;

    PontoTuristicoServiceImpl(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
        this.listPontoTuristico = new ArrayList<>();
        this.listPontoTuristico.add(new PontoTuristico(1L,
                1L,
                "BRASÍLIA",
                "PALÁCIO CENTRAL",
                "VERÃO"));
    }

    @Override
    public PontoTuristicoDTO create(PontoTuristicoCreateUpdateDTO pontoTuristicoCreateUpdateDTO) {
        PontoTuristico novoPontoTuristico = new PontoTuristico(
                this.getNewId(),
                pontoTuristicoCreateUpdateDTO.getPaisId(),
                pontoTuristicoCreateUpdateDTO.getCidade(),
                pontoTuristicoCreateUpdateDTO.getNome(),
                pontoTuristicoCreateUpdateDTO.getEstacaoVisita()
        );


        this.listPontoTuristico.add(novoPontoTuristico);

        return new PontoTuristicoDTO(novoPontoTuristico);
    }

    @Override
    public PontoTuristicoDTO update(Long id, PontoTuristicoCreateUpdateDTO pontoTuristicoCreateUpdateDTO) {

        PontoTuristico pontoTuristico = this.getPontoTuristicoById(id);

        int index = this.listPontoTuristico.indexOf(pontoTuristico);

        if (pontoTuristico == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        pontoTuristico.setPaisId(pontoTuristicoCreateUpdateDTO.getPaisId());
        pontoTuristico.setCidade(pontoTuristicoCreateUpdateDTO.getCidade());
        pontoTuristico.setNome(pontoTuristicoCreateUpdateDTO.getNome());
        pontoTuristico.setEstacaoVisita(pontoTuristicoCreateUpdateDTO.getEstacaoVisita());

        this.listPontoTuristico.set(index, pontoTuristico);
        return new PontoTuristicoDTO(pontoTuristico);
    }

    @Override
    public void delete(Long id) {
        PontoTuristico pontoTuristico = this.getPontoTuristicoById(id);
        this.listPontoTuristico.remove(pontoTuristico);
    }

    @Override
    public PontoTuristicoDTO getPontoTuristicobyId(Long id) {
        PontoTuristico pontoTuristico = this.getPontoTuristicoById(id);
        if (pontoTuristico == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        var pontoTuristicoDTO = new PontoTuristicoDTO(pontoTuristico);

        var listaComentarios = comentarioService.getComentarioByPontoTuriscoId(pontoTuristico.getId());

        pontoTuristicoDTO.setComentarios(listaComentarios);

        return pontoTuristicoDTO;
    }

    @Override
    public List<PontoTuristicoDTO> getPontoTuristicoByPaisId(Long paisId) {
        return this.listPontoTuristico.stream()
                .filter(x -> x.getPaisId().equals(paisId))
                .map(pontoTuristico -> new PontoTuristicoDTO(pontoTuristico))
                .collect(Collectors.toList());
    }

    @Override
    public List<PontoTuristicoDTO> getPontoTuristicoByEstacaoVisita(String estacaoVisita) {
        return this.listPontoTuristico.stream()
                .filter(x -> x.getEstacaoVisita().equals(estacaoVisita))
                .map(pontoTuristico -> new PontoTuristicoDTO(pontoTuristico))
                .collect(Collectors.toList());
    }

    @Override
    public List<PontoTuristicoDTO> getAllPontoTuristico() {
        var listaPontoTuristicoDTO = this.listPontoTuristico.stream()
                .map(pontoTuristico -> new PontoTuristicoDTO(pontoTuristico))
                .collect(Collectors.toList());

        listaPontoTuristicoDTO.stream()
                .forEach(p -> {
                    p.setComentarios(comentarioService.getComentarioByPontoTuriscoId(p.getId()));
                });

        return listaPontoTuristicoDTO;
    }

    private Long getNewId() {
        if (this.listPontoTuristico.size() > 0) {
            return this.listPontoTuristico.stream().max(Comparator
                            .comparingDouble(PontoTuristico::getId))
                    .get()
                    .getId() + 1;
        } else {
            return Long.valueOf(1);
        }
    }

    private PontoTuristico getPontoTuristicoById(Long id) {
        return this.listPontoTuristico.stream()
                .filter(x -> Objects.equals(x.getId(), id))
                .findFirst()
                .orElse(null);
    }

    private int getPontoTuristicoIndexById(Long id) {
        AtomicInteger index = new AtomicInteger();
        return this.listPontoTuristico.stream()
                .peek(p -> index.incrementAndGet())
                .anyMatch(x -> x.getId().equals(id)) ?
                index.get() - 1 : -1;
    }

}
