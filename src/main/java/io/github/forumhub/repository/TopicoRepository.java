package io.github.forumhub.repository;

import io.github.forumhub.model.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByTituloAndMensagemAndIdNot(String titulo, String mensagem, Long id);
    
}
