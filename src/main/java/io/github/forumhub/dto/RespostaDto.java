package io.github.forumhub.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record RespostaDto(
        Long id,

        @NotBlank(message = "A mensagem da resposta é obrigatória")
        String mensagem,

        @NotNull(message = "O ID do tópico é obrigatório")
        Long topicoId,

        LocalDateTime dataCriacao,

        @NotNull(message = "O ID do autor é obrigatório")
        Long autorId,

        Boolean solucao
) {
}