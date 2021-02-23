package br.com.tag.sdk.model.customer;

import br.com.tag.sdk.model.response.BaseResponse;
import br.com.tag.sdk.model.response.PagesOutput;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * Classe que encapsula a resposta da consulta por paginação de estabelecimentos comerciais
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-ec-por-par%C3%A2metros-perpage-e-page"></a>
 */

public class CommercialEstablishmentPaginatedQueryResponse extends BaseResponse {

    @JsonProperty("commercialEstablishments")
    private List<CommercialEstablishmentQueryOutput> commercialEstablishments = new ArrayList<>();

    @JsonProperty("pages")
    private PagesOutput pages;

    public CommercialEstablishmentPaginatedQueryResponse(
            String processKey,
            Date createdAt,
            List<CommercialEstablishmentQueryOutput> commercialEstablishments,
            PagesOutput pages) {
        super(processKey, createdAt);
        this.commercialEstablishments = commercialEstablishments;
        this.pages = pages;
    }

    public CommercialEstablishmentPaginatedQueryResponse() {
    }


    public List<CommercialEstablishmentQueryOutput> getCommercialEstablishments() {
        return commercialEstablishments;
    }

    public void setCommercialEstablishments(List<CommercialEstablishmentQueryOutput> commercialEstablishments) {
        this.commercialEstablishments = commercialEstablishments;
    }

    public PagesOutput getPages() {
        return pages;
    }

    public void setPages(PagesOutput pages) {
        this.pages = pages;
    }

}
