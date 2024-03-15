package advogando.bem.domain.questao;

import advogando.bem.domain.Entity;
import advogando.bem.domain.validation.ValidationHandler;
import advogando.bem.domain.validation.handler.ThrowsValidationHandler;

import java.time.Instant;
import java.util.UUID;

public class Questao extends Entity {

    private String enunciado;
    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;
    private Questao(String enunciado, Instant createdAt, Instant updatedAt, Instant deletedAt) {
        super(UUID.randomUUID());
        this.enunciado = enunciado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.active = true;
        this.validate(new ThrowsValidationHandler());
    }

    public static Questao newQuestao(String enunciado) {
        final var now = Instant.now();
        return new Questao(enunciado, now, now, null);
    }

    public Questao update(String enunciado, boolean isActive) {
        this.enunciado = enunciado;
        if (isActive) {
            this.activate();
        } else {
            this.deactivate();
        }
        this.updatedAt = Instant.now();
        this.validate(new ThrowsValidationHandler());
        return this;
    }

    public Questao activate() {
        this.deletedAt = null;
        this.active = true;
        this.updatedAt = Instant.now();
        return this;
    }

    public Questao deactivate() {
        if (this.deletedAt == null) {
            this.deletedAt = Instant.now();
        }
        this.active = false;
        this.updatedAt = Instant.now();
        return this;
    }

    @Override
    public void validate(ValidationHandler handler) {
        new QuestaoValidator(this, handler).validate();
    }

    public String getEnunciado() {
        return enunciado;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public boolean isActive() {
        return active;
    }
}
