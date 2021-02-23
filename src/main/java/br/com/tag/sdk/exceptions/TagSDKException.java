package br.com.tag.sdk.exceptions;

import br.com.tag.sdk.model.errors.ResponseError;
import br.com.tag.sdk.model.request.HttpStatus;

/***
 * Classe de Exceptions customizadas da SDK
 * @author 7Comm
 * @version 1.0.0
 */
public class TagSDKException extends Exception {

    private static final long serialVersionUID = 1L;
    private HttpStatus status;
    private ResponseError error;

    public TagSDKException(HttpStatus status) {
        super(generateMessage(null, status));
        this.status = status;
    }

    public TagSDKException(ResponseError error) {
        super(generateMessage(error, null));
        this.error = error;
    }

    public TagSDKException(ResponseError error, HttpStatus status) {
        super(generateMessage(error, status));
        this.error = error;
        this.status = status;
    }

    public TagSDKException(String msg, ResponseError error, HttpStatus status) {
        super(msg);
        this.error = error;
        this.status = status;
    }

    public TagSDKException(String msg, HttpStatus status) {
        super(msg);
        this.status = status;
    }

    private static String generateMessage(ResponseError error, HttpStatus status) {
        StringBuffer bf = new StringBuffer();
        bf.append("\n");
        if (error != null) {
            bf.append(error.toString())
                    .append("\n");
        }
        if (status != null) {
            bf.append(status.toString())
                    .append("\n");
        }
        return bf.toString();
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public ResponseError getError() {
        return error;
    }

    public void setError(ResponseError error) {
        this.error = error;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
