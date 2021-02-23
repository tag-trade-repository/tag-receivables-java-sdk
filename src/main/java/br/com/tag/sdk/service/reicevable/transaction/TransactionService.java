package br.com.tag.sdk.service.reicevable.transaction;

import br.com.tag.sdk.Constants;
import br.com.tag.sdk.SDKOptions;
import br.com.tag.sdk.commands.RequestCommand;
import br.com.tag.sdk.commands.ResponseCommand;
import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.enums.Profile;
import br.com.tag.sdk.model.receivable.transaction.TransactionQueryResponse;
import br.com.tag.sdk.model.receivable.transaction.TransactionRequest;
import br.com.tag.sdk.model.request.MediaType;
import br.com.tag.sdk.model.request.RequestMethod;
import br.com.tag.sdk.model.request.RequestOptions;
import br.com.tag.sdk.model.request.RestRequest;
import br.com.tag.sdk.model.response.BaseResponse;
import br.com.tag.sdk.pipeline.IFilter;
import br.com.tag.sdk.service.BaseService;

/***
 * @author 7Comm
 * @version 1.0.0
 */
public class TransactionService extends BaseService implements ITransactionService {

    public TransactionService(SDKOptions options) {
        super(options, Profile.ACQUIRER);
    }

    /***
     * Lista transações de unidades recebíveis por chave
     * @param key Chave da transação
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-transacoes-de-unidades-de-recebiveis">Consulta de Transações de Unidades de Recebíveis</a>
     * @throws TagSDKException
     */
    @Override
    public TransactionQueryResponse getTransaction(String key) throws TagSDKException {
        RestRequest<TransactionQueryResponse> rReq = new RestRequest<>();

        String uri = String.format(Constants.Transaction.BASE_PATH_TRANSACTION_KEY, key);

        RequestOptions<TransactionQueryResponse> request = new RequestOptions<TransactionQueryResponse>()
                .method(RequestMethod.GET)
                .uri(uri)
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .header("Accept", MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(request);

        RequestCommand<TransactionQueryResponse> context = new RequestCommand<>(rReq, profiles);

        IFilter<RequestCommand<TransactionQueryResponse>, ResponseCommand<TransactionQueryResponse>> notificationInputPipeline =
                this.getPipeline(TransactionQueryResponse.class);

        ResponseCommand<TransactionQueryResponse> resp = notificationInputPipeline.execute(context);
        return resp.getResponse();
    }

    /***
     * Agrega transações à unidades recebíveis
     * @param transactionUnits Objeto com as unidades de recebíveis que transacionaram
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/transacoes-componentes-de-unidades-de-recebiveis">Transações Componentes de Unidades de Recebíveis</a>
     * @throws TagSDKException
     */
    @Override
    public BaseResponse createTransactedUnitsReceivables(TransactionRequest transactionUnits) throws TagSDKException {
        RestRequest<TransactionRequest> rReq = new RestRequest<>();

        String reqUrl = Constants.Transaction.BASE_PATH_TRANSACTION;

        RequestOptions<TransactionRequest> request = new RequestOptions<TransactionRequest>()
                .method(RequestMethod.POST)
                .uri(reqUrl)
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .header("Accept", MediaType.APPLICATION_JSON.toString())
                .body(transactionUnits, MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(request);

        RequestCommand<TransactionRequest> context = new RequestCommand<>(rReq, profiles);

        IFilter<RequestCommand<TransactionRequest>, ResponseCommand<BaseResponse>> notificationInputPipeline =
                this.getPipeline(BaseResponse.class);

        ResponseCommand<BaseResponse> resp = notificationInputPipeline.execute(context);
        return resp.getResponse();
    }

    /***
     * Retifica transações de unidades recebíveis
     * @param transactionUnits Objeto com as unidades de recebíveis que transacionaram
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/retificacao-das-transacoes-de-unidades-de-recebiveis">Retificação das Transações de Unidades de Recebíveis</a>
     * @throws TagSDKException
     */
    @Override
    public BaseResponse rectifyTransactedUnitsReceivables(TransactionRequest transactionUnits) throws TagSDKException {
        RestRequest<TransactionRequest> rReq = new RestRequest<>();

        String reqUrl = Constants.Transaction.BASE_PATH_TRANSACTION;

        RequestOptions<TransactionRequest> request = new RequestOptions<TransactionRequest>()
                .method(RequestMethod.PATCH)
                .uri(reqUrl)
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .header("Accept", MediaType.APPLICATION_JSON.toString())
                .body(transactionUnits, MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(request);

        RequestCommand<TransactionRequest> context = new RequestCommand<>(rReq, profiles);

        IFilter<RequestCommand<TransactionRequest>, ResponseCommand<BaseResponse>> notificationInputPipeline =
                this.getPipeline(BaseResponse.class);

        ResponseCommand<BaseResponse> resp = notificationInputPipeline.execute(context);
        return resp.getResponse();
    }

}
