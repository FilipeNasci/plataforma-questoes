package advogando.bem.domain.alternativa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlternativaTest {

    @Test
    public void givenValidParameters_whenInstantiateANewAlternativa_thenInstantiateANewAlternativa() {
        final var resposta = "Eu sou o campeão.";
        final var correto = true;

        final var alternativa = Alternativa.newAlternativa(resposta, correto);
        Assertions.assertNotNull(alternativa.getId());
        Assertions.assertEquals(resposta, alternativa.getResposta());
        Assertions.assertEquals(correto, alternativa.isCorreto());
    }

//    @Test()
//    public void givenInvalidEmptyResposta_whenInstantiateANewAlternativa_thenThrowAnError() {
//        final var resposta = "";
//        final var correto = true;
//        final var expectedErrorMessage = "Resposta não deve ser vazia";
//        final var expectedErrorCount = 1;
//
//        final var alternativa = Alternativa.newAlternativa(resposta, correto);
//
//        final var actualException = Assertions.assertThrows(DomainException.class, () -> Alternativa.newAlternativa(resposta, correto));
//        Assertions.assertEquals(expetedErrorMessage, actualException.getErrors().get(0));
//        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
//    }
}
