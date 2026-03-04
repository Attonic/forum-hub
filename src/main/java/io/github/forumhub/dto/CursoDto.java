package io.github.forumhub.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CursoDto(
        Long id,

        @NotBlank(message = "O nome do curso é obrigatório")
        String nome,

        @NotBlank(message = "A categoria é obrigatória")
        String categoria
) {
}