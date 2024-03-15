package advogando.bem.domain.questao;

import advogando.bem.domain.Pagination.Pagination;

import java.util.Optional;
import java.util.UUID;

public interface QuestaoGateway {

    Questao create(Questao questao);
    Questao deleteById(UUID questaoId);
    Optional<Questao> findById(Questao questao);
    Questao update(Questao questao);
    Pagination<Questao> findAll(QuestaoSearchQuery query);
}
