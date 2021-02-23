package br.com.tag.sdk.model.request;

/***
 * Classe com os parâmetros de paginação
 * @author 7Comm
 * @version 1.0.0
 */
public class Pagination {

    private Integer limit;
    private Integer page;

    public Pagination() {
    }

    public Pagination(int page, int limit) {
        this.limit = limit;
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

}
