package io.github.forumhub.controller;

import io.github.forumhub.dto.TopicoDto;
import io.github.forumhub.service.TopicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/topicos")
@RestController
@RequiredArgsConstructor
public class TopicoController {

    private final TopicoService topicoService;

    @GetMapping
    public ResponseEntity<Page<TopicoDto>> buscarTodos(
            @PageableDefault(size = 10, sort = "titulo")
            Pageable pageable
            ){
        var topicos = topicoService.buscarTodos(pageable);
        return ResponseEntity.ok().body(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDto> buscarPorId(@PathVariable("id") Long id){
        var topico = topicoService.buscarPorId(id);
        return ResponseEntity.ok().body(topico);
    }

    @PostMapping
    public ResponseEntity<TopicoDto> salvar(
            @RequestBody
            @Validated
            TopicoDto topicoDto
    ){
        var topicoSalvo = topicoService.salvar(topicoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(topicoSalvo);
    }

    @PutMapping("/id")
    public ResponseEntity<TopicoDto> atualizar(
            @PathVariable() Long id,
            @RequestBody
            @Validated
            TopicoDto topicoDto
    ){
        var topicoSalvo = topicoService.atualizar(topicoDto, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(topicoSalvo);
    }
}
