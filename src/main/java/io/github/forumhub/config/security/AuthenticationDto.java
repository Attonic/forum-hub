package io.github.forumhub.config.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AuthenticationDto(

        @NotNull
        String nome,

        @NotNull
        String senha
) {
}
