package br.com.tag.sdk.model.errors;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/***
 * Classe que encapsula objeto de erro retornado pelas APIs da TAG
 * @author 7Comm
 * @version 1.0.0
 */
public class ResponseError {

    @JsonAlias({"errors", "error"})
    private List<String> errors = new ArrayList<>();

    @JsonAlias({"processKey", "processkey"})
    private UUID processKey;

    @JsonAlias({"createdAt", "createdDate"})
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date createdAt;

    public ResponseError(List<String> errors, UUID processKey, Date createdAt) {
        this.errors = errors;
        this.processKey = processKey;
        this.createdAt = createdAt;
    }

    public ResponseError() {
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public UUID getProcessKey() {
        return processKey;
    }

    public void setProcessKey(UUID processKey) {
        this.processKey = processKey;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        StringBuffer bf = new StringBuffer();
        bf.append("\n");

        if (!errors.isEmpty()) {
            for (String error : errors) {
                bf.append(error)
                        .append("\n");
            }
        }
        if (this.processKey != null) {
            bf.append(this.processKey)
                    .append("\n");
        }
        if (this.createdAt != null) {
            bf.append(this.createdAt.toString())
                    .append("\n");
        }
        return bf.toString();
    }

}
