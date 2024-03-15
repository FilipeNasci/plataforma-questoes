package advogando.bem.domain.questao;

import advogando.bem.domain.validation.Error;
import advogando.bem.domain.validation.ValidationHandler;
import advogando.bem.domain.validation.Validator;

public class QuestaoValidator extends Validator {

    private final int MIN_ENUNCIADO_LENGTH = 8;
    private final Questao questao;

    public QuestaoValidator(final Questao questao, final ValidationHandler handler) {
        super(handler);
        this.questao = questao;
    }
    @Override
    public void validate() {
        validateEnunciado();
    }

    private void validateEnunciado() {
        if (questao.getEnunciado() == null || questao.getEnunciado().trim().equals("") || questao.getEnunciado().trim().length() < MIN_ENUNCIADO_LENGTH) {
            this.validationHandler().append(new Error("Enunciado não pode ser vazio, nulo ou obter menmos de" + MIN_ENUNCIADO_LENGTH + "caracteres."));
        }
    }
}
