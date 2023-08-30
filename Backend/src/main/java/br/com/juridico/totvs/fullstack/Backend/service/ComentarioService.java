package br.com.juridico.totvs.fullstack.Backend.service;

import br.com.juridico.totvs.fullstack.Backend.domain.Comentario;
import br.com.juridico.totvs.fullstack.Backend.service.dto.ComentarioCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.ComentarioDTO;

import java.util.List;

public interface ComentarioService {

    List<Comentario> listComentario = null;

    public ComentarioDTO create(ComentarioCreateUpdateDTO comentarioCreateUpdateDTO);

    public ComentarioDTO update(Long id, ComentarioCreateUpdateDTO comentarioCreateUpdateDTO);

    public void delete(Long id);

    public ComentarioDTO getComentariobyId(Long id);

    public List<ComentarioDTO> getComentarioByPontoTuriscoId(Long pontoTuriscoId);

    public List<ComentarioDTO> getAllComentario();
}
