package br.com.tag.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class BasePaginatedQueryResponse extends BaseQueryResponse {

    @JsonProperty("pages")
    private PagesOutput pages;

    public BasePaginatedQueryResponse(String queryKey,
                                      Date queryDate,
                                      PagesOutput pages) {
        super(queryKey, queryDate);
        this.pages = pages;
    }

    public BasePaginatedQueryResponse() {
    }

    public PagesOutput getPages() {
        return pages;
    }

    public void setPages(PagesOutput pages) {
        this.pages = pages;
    }

}
