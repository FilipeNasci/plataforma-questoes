package advogando.bem.domain.Pagination;

import java.util.List;

public record Pagination<T>(int currentPage, int perPage, long total, List<T> items) {
}
