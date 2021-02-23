package br.com.tag.sdk.model.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/***
 * Classe que encapsula a requisição para cadastro de estabelecimentos comerciais
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/estabelecimento-comercial"></a>
 */
public class CommercialEstablishmentRequest {

    @JsonProperty("commercialEstablishments")
    private List<CommercialEstablishment> commercialEstablishments = new ArrayList<>();

    public CommercialEstablishmentRequest(List<CommercialEstablishment> commercialEstablishments) {
        this.commercialEstablishments = commercialEstablishments;
    }

    public CommercialEstablishmentRequest() {
    }

    public List<CommercialEstablishment> getCommercialEstablishments() {
        return commercialEstablishments;
    }

    public void setCommercialEstablishments(List<CommercialEstablishment> commercialEstablishments) {
        this.commercialEstablishments = commercialEstablishments;
    }

}
