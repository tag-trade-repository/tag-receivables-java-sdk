package br.com.tag.sdk.model.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Classe que encapsula a requisição de atualização de estabelecimentos comerciais
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/altera%C3%A7%C3%A3o-de-ec"></a>
 */

public class CommercialEstablishmentUpdateRequest {

    @JsonProperty("commercialEstablishments")
    private CommercialEstablishmentUpdateInput commercialEstablishment;

    public CommercialEstablishmentUpdateRequest(CommercialEstablishmentUpdateInput commercialEstablishment) {
        this.commercialEstablishment = commercialEstablishment;
    }

    public CommercialEstablishmentUpdateRequest() {

    }

    public CommercialEstablishmentUpdateInput getCommercialEstablishment() {
        return commercialEstablishment;
    }

    public void setCommercialEstablishment(CommercialEstablishmentUpdateInput commercialEstablishment) {
        this.commercialEstablishment = commercialEstablishment;
    }

}
