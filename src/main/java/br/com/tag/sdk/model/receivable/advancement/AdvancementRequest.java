package br.com.tag.sdk.model.receivable.advancement;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/***
 * Classe de requisição para alteracao da data de expectativa de liquidacao da antecipação pós-contratada
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/alteracao-da-data-de-expectativa-de-liquidacao">Antecipação Pós-Contratada</a>
 */
public class AdvancementRequest {

    @JsonProperty("advancements")
    private List<Advancement> advancements = new ArrayList<>();

    public AdvancementRequest(List<Advancement> advancements) {
        this.advancements = advancements;
    }

    public AdvancementRequest() {

    }

    public List<Advancement> getAdvancements() {
        return advancements;
    }

    public void setAdvancements(List<Advancement> advancements) {
        this.advancements = advancements;
    }

}
