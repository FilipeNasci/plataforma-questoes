package advogando.bem.domain.questao;

import java.util.List;

public record QuestaoSearchQuery(int currentPage, int perPage, String terms, String sort, String direction) {
}
