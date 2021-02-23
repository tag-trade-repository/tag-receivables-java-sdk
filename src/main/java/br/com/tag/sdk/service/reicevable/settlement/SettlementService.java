package br.com.tag.sdk.service.reicevable.settlement;

import br.com.tag.sdk.Constants;
import br.com.tag.sdk.SDKOptions;
import br.com.tag.sdk.commands.RequestCommand;
import br.com.tag.sdk.commands.ResponseCommand;
import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.enums.Profile;
import br.com.tag.sdk.model.receivable.settlement.*;
import br.com.tag.sdk.model.request.*;
import br.com.tag.sdk.model.response.BaseResponse;
import br.com.tag.sdk.pipeline.IFilter;
import br.com.tag.sdk.service.BaseService;
import br.com.tag.sdk.utils.RequestUtils;

import java.util.HashMap;
import java.util.Map;

/***
 * @author 7Comm
 * @version 1.0.0
 */
public class SettlementService extends BaseService implements ISettlementService {

    public SettlementService(SDKOptions options) {
        super(options, Profile.ACQUIRER);
    }

    /***
     * Cria uma ou mais liquidações
     * @param receivableSettlementInput Conjunto de uma ou mais Liquidações.
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/informe-de-liquidacao">Informe de Liquidação</a>
     * @throws TagSDKException
     */
    public SettlementResponse reportSettlement(SettlementRequest receivableSettlementInput) throws TagSDKException {

        RestRequest<SettlementRequest> rReq = new RestRequest<>();

        RequestOptions<SettlementRequest> request = new RequestOptions<SettlementRequest>()
                .method(RequestMethod.PATCH)
                .uri(Constants.Settlement.BASE_PATH)
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .header("Accept", MediaType.APPLICATION_JSON.toString())
                .body(receivableSettlementInput, MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(request);

        RequestCommand<SettlementRequest> context = new RequestCommand<>(rReq, profiles);
        context.setModel(receivableSettlementInput);

        IFilter<RequestCommand<SettlementRequest>, ResponseCommand<SettlementResponse>> paymentSchemePipeline =
                this.getPipeline(SettlementResponse.class);

        ResponseCommand<SettlementResponse> resp = paymentSchemePipeline.execute(context);

        return resp.getResponse();
    }

    /***
     * Rejeita uma ou mais liquidações
     * @param receivableSettlementInput Informe de Rejeição
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/informe-de-rejeicao-de-liquidacao">Informe de Rejeição da Liquidação</a>
     * @throws TagSDKException
     */
    @Override
    public BaseResponse rejectSettlement(SettlementRejectRequest receivableSettlementInput) throws TagSDKException {

        RestRequest<SettlementRejectRequest> rReq = new RestRequest<>();

        RequestOptions<SettlementRejectRequest> request = new RequestOptions<SettlementRejectRequest>()
                .method(RequestMethod.PATCH)
                .uri(Constants.Settlement.BASE_PATH_REJECT)
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .header("Accept", MediaType.APPLICATION_JSON.toString())
                .body(receivableSettlementInput, MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(request);

        RequestCommand<SettlementRejectRequest> context = new RequestCommand<>(rReq, profiles);

        IFilter<RequestCommand<SettlementRejectRequest>, ResponseCommand<BaseResponse>> paymentSchemePipeline =
                this.getPipeline(BaseResponse.class);

        ResponseCommand<BaseResponse> resp = paymentSchemePipeline.execute(context);

        return resp.getResponse();
    }

    /***
     * Consulta uma liquição por chave
     * @param value Chave de Identificação da liquidação
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-liquidacao-por-chave">Consulta - Chave</a>
     * @throws TagSDKException
     */
    @Override
    public SettlementQueryResponse getSettlementByKey(String value) throws TagSDKException {
        RestRequest<Void> rReq = new RestRequest<>();

        RequestOptions<Void> request = new RequestOptions<Void>()
                .method(RequestMethod.GET)
                .uri(String.format("%s/%s", Constants.Settlement.BASE_PATH_KEY, value))
                .header("Accept", MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(request);

        RequestCommand<Void> context = new RequestCommand<>(rReq, profiles);

        IFilter<RequestCommand<Void>, ResponseCommand<SettlementQueryResponse>> paymentSchemePipeline =
                this.getPipeline(SettlementQueryResponse.class);

        ResponseCommand<SettlementQueryResponse> resp = paymentSchemePipeline.execute(context);

        return resp.getResponse();
    }

    /***
     * Consulta uma ou mais liquições por ProcessKey
     * @param processKey Chave da solicitação de processamento
     * @param pagination Objeto de páginação
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-liquidacao-por-processkey">Consulta - ProcessKey</a>
     * @throws TagSDKException
     */
    @Override
    public SettlementPaginatedQueryResponse getSettlementByProcessKey(String processKey, Pagination pagination) throws TagSDKException {
        Map<String, String> params = new HashMap<>();
        params.put("processkey", processKey);
        params.put("perPage", pagination.getLimit().toString());
        params.put("page", pagination.getPage().toString());
        return getSettlement(Constants.Settlement.BASE_PATH_PROCESS_KEY, params);
    }

    /***
     * Consulta uma ou mais liquições por Referência
     * @param reference Chave única externa do informe da Liquidação
     * @param pagination Objeto de páginação
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-liquidacao-por-referencia">Consulta - Referência</a>
     * @throws TagSDKException
     */
    @Override
    public SettlementPaginatedQueryResponse getSettlementByReference(String reference, Pagination pagination) throws TagSDKException {
        Map<String, String> params = new HashMap<>();
        params.put("reference", reference);
        params.put("perPage", pagination.getLimit().toString());
        params.put("page", pagination.getPage().toString());
        return getSettlement(Constants.Settlement.BASE_PATH_REFERENCE, params);
    }

    /***
     * Consulta uma ou mais liquições utilizando parâmetros
     * @param inputs Parâmetros que serão utilizados para filtar os resultados
     * @param pagination Objeto de páginação
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-liquidacao-por-referencia">Consulta - Parâmetros</a>
     * @throws TagSDKException
     */
    @Override
    public SettlementPaginatedQueryResponse getSettlementWithParams(SettlementQueryFilter inputs, Pagination pagination) throws TagSDKException {
        RestRequest<Void> rReq = new RestRequest<>();

        String datePattern = "yyyy-MM-dd";

        Map<String, String> params = new HashMap<>();
        params.put("startSettlementDate", RequestUtils.dateParseAndFormat(inputs.getStartSettlementDate(), datePattern));
        params.put("endSettlementDate", RequestUtils.dateParseAndFormat(inputs.getEndSettlementDate(), datePattern));
        params.put("paymentScheme", inputs.getPaymentScheme());
        params.put("assetHolder", inputs.getAssetHolder());
        params.put("perPage", pagination.getLimit().toString());
        params.put("page", pagination.getPage().toString());

        String completeUrl = RequestUtils.getQueryParams(Constants.Settlement.BASE_PATH, params);

        RequestOptions<Void> request = new RequestOptions<Void>()
                .method(RequestMethod.GET)
                .uri(completeUrl)
                .header("Accept", MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(request);

        RequestCommand<Void> context = new RequestCommand<>(rReq, profiles);

        IFilter<RequestCommand<Void>, ResponseCommand<SettlementPaginatedQueryResponse>> paymentSchemePipeline =
                this.getPipeline(SettlementPaginatedQueryResponse.class);

        ResponseCommand<SettlementPaginatedQueryResponse> resp = paymentSchemePipeline.execute(context);

        return resp.getResponse();
    }

    private SettlementPaginatedQueryResponse getSettlement(String baseUri, Map<String, String> params) throws TagSDKException {
        RestRequest<Void> rReq = new RestRequest<>();

        String uri = RequestUtils.getQueryParams(baseUri, params);

        RequestOptions<Void> request = new RequestOptions<Void>()
                .method(RequestMethod.GET)
                .uri(uri)
                .header("Accept", MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(request);

        RequestCommand<Void> context = new RequestCommand<>(rReq, profiles);

        IFilter<RequestCommand<Void>, ResponseCommand<SettlementPaginatedQueryResponse>> paymentSchemePipeline =
                this.getPipeline(SettlementPaginatedQueryResponse.class);

        ResponseCommand<SettlementPaginatedQueryResponse> resp = paymentSchemePipeline.execute(context);

        return resp.getResponse();
    }

}
