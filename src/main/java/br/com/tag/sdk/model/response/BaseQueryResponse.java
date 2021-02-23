package br.com.tag.sdk.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class BaseQueryResponse {

    @JsonProperty("queryKey")
    private String queryKey;

    @JsonProperty("queryDate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date queryDate;

    public BaseQueryResponse(String queryKey, Date queryDate) {
        this.queryKey = queryKey;
        this.queryDate = queryDate;
    }

    public BaseQueryResponse() {
    }

    public String getQueryKey() {
        return queryKey;
    }

    public void setQueryKey(String queryKey) {
        this.queryKey = queryKey;
    }

    public Date getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(Date queryDate) {
        this.queryDate = queryDate;
    }

}
