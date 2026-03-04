package io.github.forumhub.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record TopicoDto(
        Long id,

        @NotBlank(message = "O título não pode estar em branco")
        String titulo,

        @NotBlank(message = "A mensagem não pode estar em branco")
        String mensagem,

        LocalDateTime dataCriacao,

        String status,

        @NotNull(message = "O ID do autor é obrigatório")
        Long autorId,

        @NotNull(message = "O ID do curso é obrigatório")
        Long cursoId
) {
}