package br.com.tag.sdk.factories;

import br.com.tag.sdk.SDKOptions;
import br.com.tag.sdk.authorization.DefaultAuthorizer;
import br.com.tag.sdk.authorization.IAuthorizer;

/***
 * Fábrica concreta para devolução de Autorizadores
 * @author 7Comm
 * @version 1.0.0
 */
public class AuthorizerFactory implements IAuthorizerFactory {

    @Override
    public IAuthorizer getAuthorizer(SDKOptions options) {
        return new DefaultAuthorizer(options);
    }

}
