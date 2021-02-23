package br.com.tag.sdk.http;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.errors.ResponseError;
import br.com.tag.sdk.model.request.HttpStatus;
import br.com.tag.sdk.model.request.RequestOptions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.Objects;

/***
 * Classe que implementa lógica de HttpClient com OkHttp
 * @author 7Comm
 * @version 1.0.0
 */
public class HttpClientOkHttp implements HttpClient {

    private final OkHttpClient client;
    private final String baseUrl;
    private final ObjectMapper mapper;

    public HttpClientOkHttp(String baseUrl) {
        this.client  = new OkHttpClient.Builder()
                .addInterceptor(new ResponseInterceptor())
                .build();
        this.baseUrl = baseUrl;
        this.mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @Override
    public <TIn, TOut> TOut doRequest(RequestOptions<TIn> req, Class<TOut> responseClass) throws TagSDKException {
        Request.Builder requestBuilder = new Request.Builder();
        this.putUrl(req, requestBuilder);
        this.putHeaders(req, requestBuilder);
        this.putMethod(req, requestBuilder);

        Request request = requestBuilder.build();

        Integer respCode = null;

        try (Response resp = client.newCall(request).execute()) {
            String rawResponse = Objects.requireNonNull(resp.body()).string();
            if (resp.code() > 299 || resp.code() < 200) {
                respCode = resp.code();
                ResponseError err = this.mapper.readValue(rawResponse, ResponseError.class);
                throw new TagSDKException(err, HttpStatus.valueOf(resp.code()));
            }
            if (responseClass.equals(String.class)) {
                return (TOut) rawResponse;
            } else {
                return this.mapper.readValue(rawResponse, responseClass);
            }
        } catch (IOException ex) {
            HttpStatus resp = respCode != null ? HttpStatus.valueOf(respCode) : HttpStatus.BAD_REQUEST;
            throw new TagSDKException(ex.getMessage(), resp);
        }
    }

    private <TIn> void putUrl(RequestOptions<TIn> req, Request.Builder builder) {
        StringBuilder uriBuilder = new StringBuilder();
        uriBuilder.append(baseUrl);
        if (!baseUrl.endsWith("/") && !req.getUri().startsWith("/")) {
            uriBuilder.append("/");
        }
        uriBuilder.append(req.getUri());
        builder.url(uriBuilder.toString());
    }

    private <TIn> void putHeaders(RequestOptions<TIn> req, Request.Builder builder) {
        req.getHeaders().forEach(builder::addHeader);
    }

    private <TIn> void putMethod(RequestOptions<TIn> req, Request.Builder builder) throws TagSDKException {
        builder.method(req.getMethod().name().toUpperCase(), this.parseBody(req));
    }

    private <TIn> RequestBody parseBody(RequestOptions<TIn> req) throws TagSDKException {
        if (req.getBody() != null && req.getBodyType() != null) {
            MediaType type = MediaType.get(req.getBodyType());
            String parsedBody = null;
            try {
                parsedBody = this.mapper.writeValueAsString(req.getBody());
                return RequestBody.create(parsedBody, type);
            } catch (JsonProcessingException ex) {
                throw new TagSDKException(ex.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }
        return null;
    }
}
