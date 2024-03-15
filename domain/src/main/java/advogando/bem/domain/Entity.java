package advogando.bem.domain;

import advogando.bem.domain.validation.ValidationHandler;

import java.util.Objects;

public abstract class Entity<UUID> {

    protected final UUID id;

    protected Entity(final UUID id) {
        Objects.requireNonNull(id, "id should not be null");
        this.id = id;
    }

    protected abstract void validate(ValidationHandler handler);

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity<?> entity = (Entity<?>) o;
        return Objects.equals(getId(), entity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
