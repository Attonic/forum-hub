package io.github.forumhub.mapper;

import io.github.forumhub.dto.TopicoDto;
import io.github.forumhub.model.entity.Topico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TopicoMapper {

    Topico deDtoParaEntidade(TopicoDto topicoDto);

    TopicoDto deEntiadeParaDto(Topico topico);

    @Mapping(target = "id", ignore = true)
    void atualizarEntidadeDeUmDto(TopicoDto dto, @MappingTarget Topico topicoExistente);


}
