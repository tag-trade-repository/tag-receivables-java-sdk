package br.com.tag.sdk.service.reicevable.register;

import br.com.tag.sdk.Constants;
import br.com.tag.sdk.SDKOptions;
import br.com.tag.sdk.commands.RequestCommand;
import br.com.tag.sdk.commands.ResponseCommand;
import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.enums.Profile;
import br.com.tag.sdk.model.receivable.register.ReceivableRequest;
import br.com.tag.sdk.model.receivable.register.ReceivableResponse;
import br.com.tag.sdk.model.request.MediaType;
import br.com.tag.sdk.model.request.RequestMethod;
import br.com.tag.sdk.model.request.RequestOptions;
import br.com.tag.sdk.model.request.RestRequest;
import br.com.tag.sdk.service.BaseService;

/***
 * @author 7Comm
 * @version 1.0.0
 */
public class ReceivableService extends BaseService implements IReceivableService {

    public ReceivableService(SDKOptions options) {
        super(options, Profile.ACQUIRER);
    }

    /***
     * Insere uma ou mais unidades de recebíveis
     * @param receivableInput Dados adicionais do processamento e Conjunto de Unidades de Recebíveis
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/registro">Registro e Atualização de Ativos Financeiros</a>
     * @throws TagSDKException
     */
    public ReceivableResponse registerReceivable(ReceivableRequest receivableInput) throws TagSDKException {
        RestRequest<ReceivableRequest> rReq = new RestRequest<>();

        RequestOptions<ReceivableRequest> restRequest = new RequestOptions<ReceivableRequest>()
                .method(RequestMethod.POST)
                .uri(Constants.Receivable.BASE_PATH)
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .header("Accept", MediaType.APPLICATION_JSON.toString())
                .body(receivableInput, MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<ReceivableRequest> context = new RequestCommand<>(rReq, profiles);
        
        ResponseCommand<ReceivableResponse> resp = this.
                <ReceivableRequest, ReceivableResponse>getPipeline(ReceivableResponse.class).execute(context);
        return resp.getResponse();
    }

}
