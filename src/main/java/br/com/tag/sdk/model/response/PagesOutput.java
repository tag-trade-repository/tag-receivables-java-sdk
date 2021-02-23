package br.com.tag.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PagesOutput {

    @JsonProperty("currentPage")
    private Integer currentPage;

    @JsonProperty("perPage")
    private Integer perPage;

    @JsonProperty("totalPages")
    private Integer totalPages;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

}
