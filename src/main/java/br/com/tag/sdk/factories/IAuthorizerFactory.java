package br.com.tag.sdk.factories;

import br.com.tag.sdk.SDKOptions;
import br.com.tag.sdk.authorization.IAuthorizer;

/***
 * Fábrica abstrata para devolução de Autorizadores
 * @author 7Comm
 * @version 1.0.0
 */
public interface IAuthorizerFactory {
    IAuthorizer getAuthorizer(SDKOptions options);
}