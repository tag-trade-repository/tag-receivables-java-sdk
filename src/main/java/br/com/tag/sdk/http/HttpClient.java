package br.com.tag.sdk.http;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.request.RequestOptions;

/***
 * Interface base para a implementação de Clients Https
 * @author 7Comm
 * @version 1.0.0
 */
public interface HttpClient {
    <TIn, TOut> TOut doRequest(RequestOptions<TIn> req, Class<TOut> responseClass) throws TagSDKException;
}
