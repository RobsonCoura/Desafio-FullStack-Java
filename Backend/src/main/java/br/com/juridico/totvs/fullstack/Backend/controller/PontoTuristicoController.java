package br.com.juridico.totvs.fullstack.Backend.controller;

import br.com.juridico.totvs.fullstack.Backend.service.PontoTuristicoService;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController()
@RequestMapping("/pontoturistico")
public class PontoTuristicoController {
    private final PontoTuristicoService pontoTuristicoService;

    public PontoTuristicoController(PontoTuristicoService pontoTuristicoService) {
        this.pontoTuristicoService = pontoTuristicoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar um ponto turístico.")
    public PontoTuristicoDTO create(@RequestBody PontoTuristicoCreateUpdateDTO pontoTuristicoCreateUpdateDTO) {
        return this.pontoTuristicoService.create(pontoTuristicoCreateUpdateDTO);
    }

    @GetMapping
    @Operation(summary = "Buscar uma lista de países.")
    public List<PontoTuristicoDTO> getAll() {
        return this.pontoTuristicoService.getAllPontoTuristico();
    }

    @GetMapping("{paisId}/pais")
    @Operation(summary = "Faz uma busca de ponto turístico por filtro de {paisId}.")
    public List<PontoTuristicoDTO> getPontoTuristicoByPais(@PathVariable Long paisId) {
        return this.pontoTuristicoService.getPontoTuristicoByPaisId(paisId);
    }

    @GetMapping("{estacaoVisita}/estacaovisita")
    @Operation(summary = "Faz uma busca de ponto turístico por filtro de estação visita.")
    public List<PontoTuristicoDTO> getPontoTuristicoByEstacaoVisita(@PathVariable String estacaoVisita) {
        return this.pontoTuristicoService.getPontoTuristicoByEstacaoVisita(estacaoVisita);
    }

    @GetMapping("{idPontoTuristico}")
    @Operation(summary = "Faz uma busca de ponto turístico por {id} específico.")
    public PontoTuristicoDTO getPontoTuristicoById(@PathVariable Long idPontoTuristico) {
        return this.pontoTuristicoService.getPontoTuristicobyId(idPontoTuristico);
    }

    @DeleteMapping("{idPontoTuristico}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Exclui um ponto turístico inserindo um {id} específico.")
    public void delete(@PathVariable Long idPontoTuristico) {
        this.pontoTuristicoService.delete(idPontoTuristico);
    }

    @PutMapping("{idPontoTuristico}")
    @Operation(summary = "Atualiza um ponto turístico inserindo um {id} específico.")
    public PontoTuristicoDTO update(@PathVariable Long idPontoTuristico,
                                    @RequestBody PontoTuristicoCreateUpdateDTO pontoTuristicoCreateUpdateDTO) {
        return this.pontoTuristicoService.update(idPontoTuristico, pontoTuristicoCreateUpdateDTO);
    }
}
