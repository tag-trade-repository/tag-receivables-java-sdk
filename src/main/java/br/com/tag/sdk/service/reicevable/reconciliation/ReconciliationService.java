package br.com.tag.sdk.service.reicevable.reconciliation;

import br.com.tag.sdk.Constants;
import br.com.tag.sdk.SDKOptions;
import br.com.tag.sdk.commands.RequestCommand;
import br.com.tag.sdk.commands.ResponseCommand;
import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.enums.Profile;
import br.com.tag.sdk.model.receivable.reconciliation.*;
import br.com.tag.sdk.model.request.MediaType;
import br.com.tag.sdk.model.request.RequestMethod;
import br.com.tag.sdk.model.request.RequestOptions;
import br.com.tag.sdk.model.request.RestRequest;
import br.com.tag.sdk.service.BaseService;

/***
 * @author 7Comm
 * @version 1.0.0
 */
public class ReconciliationService extends BaseService implements IReconciliationService {

    public ReconciliationService(SDKOptions options) {
        super(options, Profile.ACQUIRER);
    }

    /***
     * Insere uma conciliação
     * @param reconciliationInput Informações da conciliação
     * @see <a href="https://integration.nonprod.taginfraestrutura.com.br/receivable/reconciliation">Conciliação</a>
     * @throws TagSDKException
     */
    @Override
    public ReconciliationResponse insertConciliation(ReconciliationRequest reconciliationInput) throws TagSDKException {
        RestRequest<ReconciliationRequest> rReq = new RestRequest<>();

        RequestOptions<ReconciliationRequest> restRequest = new RequestOptions<ReconciliationRequest>()
                .method(RequestMethod.POST)
                .uri(Constants.Reconciliation.BASE_PATH)
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .header("Accept", MediaType.APPLICATION_JSON.toString())
                .body(reconciliationInput, MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<ReconciliationRequest> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<ReconciliationResponse> resp = this.
                <ReconciliationRequest, ReconciliationResponse>getPipeline(ReconciliationResponse.class).execute(context);
        return resp.getResponse();
    }

    /***
     * Consulta uma conciliação por chave
     * @param reconciliationKey Chave de identificação da conciliação
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-processo-de-conciliacao">Conciliação</a>
     * @throws TagSDKException
     */
    @Override
    public ReconciliationQueryResponse getReconciliationWithKey(String reconciliationKey) throws TagSDKException {
        RestRequest<Void> rReq = new RestRequest<>();

        String uri = String.format(Constants.Reconciliation.BASE_PATH_KEY, reconciliationKey);

        RequestOptions<Void> restRequest = new RequestOptions<Void>()
                .method(RequestMethod.GET)
                .uri(uri)
                .header("Accept", MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<Void> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<ReconciliationQueryResponse> resp = this.
                <Void, ReconciliationQueryResponse>getPipeline(ReconciliationQueryResponse.class).execute(context);
        return resp.getResponse();
    }

    /***
     * Confirma uma conciliação
     * @param reconciliationKey Chave de identificação da conciliação
     * @param recConfirmationInput Objeto de conciliação
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/confirmacao-da-conciliacao">Confirmação</a>
     * @throws TagSDKException
     */
    @Override
    public ReconciliationConfirmationResponse confirmReconciliation(String reconciliationKey,
                                                                    ReconciliationConfirmationRequest recConfirmationInput) throws TagSDKException {
        RestRequest<ReconciliationConfirmationRequest> rReq = new RestRequest<>();

        String uri = String.format(Constants.Reconciliation.BASE_PATH_KEY, reconciliationKey);

        RequestOptions<ReconciliationConfirmationRequest> restRequest = new RequestOptions<ReconciliationConfirmationRequest>()
                .method(RequestMethod.PATCH)
                .uri(uri)
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .header("Accept", MediaType.APPLICATION_JSON.toString())
                .body(recConfirmationInput, MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<ReconciliationConfirmationRequest> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<ReconciliationConfirmationResponse> resp = this.
                <ReconciliationConfirmationRequest, ReconciliationConfirmationResponse>getPipeline(ReconciliationConfirmationResponse.class).execute(context);
        return resp.getResponse();
    }

}
