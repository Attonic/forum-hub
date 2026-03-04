package io.github.forumhub.service;

import io.github.forumhub.dto.TopicoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface TopicoService {


    Page<TopicoDto> buscarTodos(Pageable pageable);

    TopicoDto buscarPorId(Long id);

    TopicoDto salvar(TopicoDto topicoDto);

    TopicoDto atualizar(TopicoDto topicoDto, Long id);


}
