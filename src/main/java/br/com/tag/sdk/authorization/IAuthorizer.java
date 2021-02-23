package br.com.tag.sdk.authorization;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.enums.Profile;

/***
 * Interface para implementação de autorizadores
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/autenticacao">Autenticação</a>
 */
public interface IAuthorizer {
    String getToken(boolean refresh, Profile profile) throws TagSDKException;
}