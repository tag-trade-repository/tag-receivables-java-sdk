package br.com.tag.sdk.model.customer;

import br.com.tag.sdk.model.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * Classe que encapsula a resposta de cadastro de estabelecimentos comerciais
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/estabelecimento-comercial"></a>
 */
public class CommercialEstablishmentResponse extends BaseResponse {

    @JsonProperty("commercialEstablishments")
    private List<CommercialEstablishmentOutput> commercialEstablishments = new ArrayList<>();

    public CommercialEstablishmentResponse(List<CommercialEstablishmentOutput> commercialEstablishments, String processKey, Date createdAt) {
        super(processKey, createdAt);
        this.commercialEstablishments = commercialEstablishments;
    }

    public CommercialEstablishmentResponse() {

    }

    public List<CommercialEstablishmentOutput> getCommercialEstablishments() {
        return commercialEstablishments;
    }

    public void setCommercialEstablishments(List<CommercialEstablishmentOutput> commercialEstablishments) {
        this.commercialEstablishments = commercialEstablishments;
    }

}
