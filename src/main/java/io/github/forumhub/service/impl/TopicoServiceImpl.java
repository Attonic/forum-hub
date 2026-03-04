package io.github.forumhub.service.impl;

import io.github.forumhub.dto.TopicoDto;
import io.github.forumhub.mapper.TopicoMapper;
import io.github.forumhub.model.entity.Topico;
import io.github.forumhub.repository.TopicoRepository;
import io.github.forumhub.service.TopicoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicoServiceImpl implements TopicoService {

    private final TopicoRepository topicoRepository;
    private final TopicoMapper topicoMapper;

    @Override
    public Page<TopicoDto> buscarTodos(Pageable pageable) {
        return topicoRepository.findAll(pageable)
                .map(topicoMapper::deEntiadeParaDto);
    }

    @Override
    public TopicoDto buscarPorId(Long id) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada."));

        return topicoMapper.deEntiadeParaDto(topico);
    }

    @Override
    public TopicoDto salvar(TopicoDto topicoDto) {
       if (topicoRepository.existsByTituloAndMensagemAndIdNot(topicoDto.titulo(), topicoDto.mensagem(), topicoDto.id())){
           throw new DataIntegrityViolationException("Já existe topico com o mesmo Titulo.");
       }

       Topico topico = topicoMapper.deDtoParaEntidade(topicoDto);
       Topico topicoSalvo = topicoRepository.save(topico);

       return topicoMapper.deEntiadeParaDto(topicoSalvo);

    }

    @Override
    public TopicoDto atualizar(TopicoDto topicoDto, Long id) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));

        topicoMapper.atualizarEntidadeDeUmDto(topicoDto, topico);

        var topicoNovo = topicoRepository.save(topico);
        return topicoMapper.deEntiadeParaDto(topico);
    }
}
