package advogando.bem.domain.alternativa;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.util.UUID;

public class Alternativa {
    private UUID id;
    private String resposta;
    private boolean correto = false;

    private Alternativa(final String resposta, final boolean correto) {
        this.id = UUID.randomUUID();
        this.resposta = resposta;
        this.correto = correto;
        this.validate();
    }

    public static Alternativa newAlternativa(String resposta, boolean correto) {
        return new Alternativa(resposta, correto);
    }

    private void validate(){
        if (this.resposta.trim().equals("") || this.resposta == null) {
            throw new Error("Alternativa não pode ser vazia");
        }
    }

    public UUID getId() {
        return id;
    }

    public String getResposta() {
        return resposta;
    }

    public boolean isCorreto() {
        return correto;
    }
}