package questao;

import advogando.bem.domain.exceptions.DomainException;
import advogando.bem.domain.questao.Questao;
import advogando.bem.domain.validation.ValidationHandler;
import advogando.bem.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestaoTest {

    @Test
    public void givenValidParametes_whenInstantiateANewQuestao_thenInstantiateANewQuestao() {
        final var enunciado = "Quem é o campeão?";

        final var questao = Questao.newQuestao(enunciado);

        Assertions.assertDoesNotThrow(() -> questao.validate(new ThrowsValidationHandler()));

        Assertions.assertNotNull(questao.getId());
        Assertions.assertEquals(enunciado, questao.getEnunciado());
        Assertions.assertNotNull(questao.getCreatedAt());
        Assertions.assertNotNull(questao.getUpdatedAt());
        Assertions.assertNull(questao.getDeletedAt());
        Assertions.assertTrue(questao.isActive());
    }

    @Test
    public void givenInvalidParametes_whenInstantiateANewQuestao_thenThrowAnDomainError() {
        final var enunciado = "";

        Assertions.assertThrows(DomainException.class, () -> Questao.newQuestao(enunciado));
    }

    @Test
    public void givenNullEnunciado_whenInstantiateANewQuestao_thenThrowAnDomainError() {
        final String enunciado = null;

        Assertions.assertThrows(DomainException.class, () -> Questao.newQuestao(enunciado));
    }

    @Test
    public void givenShortEnunciado_whenInstantiateANewQuestao_thenThrowAnDomainError() {
        final String enunciado = "qwe";

        Assertions.assertThrows(DomainException.class, () -> Questao.newQuestao(enunciado));
    }

    @Test
    public void givenValidParametersAndActive_whenCallUpdate_thenReturnQuestaoUpdated() {
        final var enunciado = "Quem é o campeão?";
        final var enunciadoUpdated = "Quem é o brabo?";
        final var isActive = true;
        final var questao = Questao.newQuestao(enunciado);


        final var questaoUpdated = questao.update(enunciadoUpdated, isActive);
        Assertions.assertNotNull(questao.getId());
        Assertions.assertEquals(enunciadoUpdated, questao.getEnunciado());
        Assertions.assertNotNull(questao.getCreatedAt());
        Assertions.assertNotNull(questao.getUpdatedAt());
        Assertions.assertNull(questao.getDeletedAt());
        Assertions.assertTrue(questao.isActive());
    }

    @Test
    public void givenValidParametersAndDeactive_whenCallUpdate_thenReturnQuestaoUpdated() {
        final var enunciado = "Quem é o campeão?";
        final var isActive = false;
        final var questao = Questao.newQuestao(enunciado);


        final var questaoUpdated = questao.update(enunciado, isActive);
        Assertions.assertNotNull(questao.getId());
        Assertions.assertEquals(enunciado, questao.getEnunciado());
        Assertions.assertNotNull(questao.getCreatedAt());
        Assertions.assertNotNull(questao.getUpdatedAt());
        Assertions.assertNotNull(questao.getDeletedAt());
        Assertions.assertFalse(questao.isActive());
    }
    @Test
    public void givenValidParameters_whenCallUpdateWithInvalidParams_thenReturnQuestaoUpdated() {
        final var enunciado = "Enunciado valido";
        final var isActive = true;
        final var enunciadoInvalido = "";
        final var questao = Questao.newQuestao(enunciado);

        Assertions.assertThrows(DomainException.class, () -> questao.update(enunciadoInvalido, isActive));
    }

}
