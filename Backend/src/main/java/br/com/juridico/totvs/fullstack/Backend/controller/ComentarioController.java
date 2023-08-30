package br.com.juridico.totvs.fullstack.Backend.controller;

import br.com.juridico.totvs.fullstack.Backend.service.ComentarioService;
import br.com.juridico.totvs.fullstack.Backend.service.dto.ComentarioCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.ComentarioDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController()
@RequestMapping("/comentario")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar um comentário.")
    public ComentarioDTO create(@RequestBody ComentarioCreateUpdateDTO comentarioCreateUpdateDTO) {
        return this.comentarioService.create(comentarioCreateUpdateDTO);
    }

    @GetMapping
    @Operation(summary = "Buscar uma lista de comentários.")
    public List<ComentarioDTO> getAll() {
        return this.comentarioService.getAllComentario();
    }

    @GetMapping("{pontoTuristicoId}/pontoTuristico")
    @Operation(summary = "Faz uma busca de comentários por filtro de ponto turístico.")
    public List<ComentarioDTO> getComentarioByPontoTuristico(@PathVariable Long pontoTuristicoId) {
        return this.comentarioService.getComentarioByPontoTuriscoId(pontoTuristicoId);
    }

    @GetMapping("{idComentario}")
    @Operation(summary = "Faz uma busca de comentário por {id} específico.")
    public ComentarioDTO getComentarioById(@PathVariable Long idComentario) {
        return this.comentarioService.getComentariobyId(idComentario);
    }

    @DeleteMapping("{idComentario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Exclui um comentário inserindo um {id} específico.")
    public void delete(@PathVariable Long idComentario) {
        this.comentarioService.delete(idComentario);
    }

    @PutMapping("{idComentario}")
    @Operation(summary = "Atualiza um país inserindo um {id} específico.")
    public ComentarioDTO update(@PathVariable Long idComentario,
                                @RequestBody ComentarioCreateUpdateDTO comentarioCreateUpdateDTO) {
        return this.comentarioService.update(idComentario, comentarioCreateUpdateDTO);
    }
}