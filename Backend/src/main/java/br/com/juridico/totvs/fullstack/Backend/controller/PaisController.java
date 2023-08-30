package br.com.juridico.totvs.fullstack.Backend.controller;

import br.com.juridico.totvs.fullstack.Backend.service.PaisService;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PaisCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PaisDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController()
@RequestMapping("/pais")
public class PaisController {
    private final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar um país.")
    public PaisDTO create(@RequestBody PaisCreateUpdateDTO paisCreateUpdateDTO) {
        return this.paisService.create(paisCreateUpdateDTO);
    }

    @GetMapping
    @Operation(summary = "Buscar uma lista de países.")
    public List<PaisDTO> getAll() {
        return this.paisService.getAllPais();
    }

    @GetMapping("{continente}/continente")
    @Operation(summary = "Faz uma busca de países por filtro de continente.")
    public List<PaisDTO> getPaisByContinente(@PathVariable String continente) {
        return this.paisService.getPaisByContinente(continente);
    }

    @GetMapping("{idPais}")
    @Operation(summary = "Faz uma busca de país por {id} específico.")
    public PaisDTO getPaisById(@PathVariable Long idPais) {
        return this.paisService.getPaisbyId(idPais);
    }

    @DeleteMapping("{idPais}")
    @Operation(summary = "Exclui um país inserindo um {id} específico.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long idPais) {
        this.paisService.delete(idPais);
    }

    @PutMapping("{idPais}")
    @Operation(summary = "Atualiza um país inserindo um {id} específico.")
    public PaisDTO update(@PathVariable Long idPais,
                          @RequestBody PaisCreateUpdateDTO paisCreateUpdateDTO) {
        return this.paisService.update(idPais, paisCreateUpdateDTO);
    }
}
