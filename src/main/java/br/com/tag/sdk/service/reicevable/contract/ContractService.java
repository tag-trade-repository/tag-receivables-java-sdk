package br.com.tag.sdk.service.reicevable.contract;

import br.com.tag.sdk.Constants;
import br.com.tag.sdk.SDKOptions;
import br.com.tag.sdk.commands.RequestCommand;
import br.com.tag.sdk.commands.ResponseCommand;
import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.enums.Profile;
import br.com.tag.sdk.model.receivable.contract.*;
import br.com.tag.sdk.model.request.*;
import br.com.tag.sdk.service.BaseService;
import br.com.tag.sdk.utils.RequestUtils;

import java.util.HashMap;
import java.util.Map;

/***
 * @author 7Comm
 * @version 1.0.0
 */
public class ContractService extends BaseService implements IContractService {

    public ContractService(SDKOptions options) {
        super(options, Profile.CREDITOR);
    }

    /***
     * Ônus e Gravames ou Alteração de Titularidade
     * @param ctInput Dados de contrato
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/garantia-ou-troca-de-titularidade">Ônus e Gravames ou Alteração de Titularidade</a>
     * @throws TagSDKException
     */
    @Override
    public ContractResponse insertContract(ContractRequest ctInput) throws TagSDKException {
        RestRequest<ContractRequest> rReq = new RestRequest<>();

        RequestOptions<ContractRequest> restRequest = new RequestOptions<ContractRequest>()
                .method(RequestMethod.POST)
                .uri(Constants.Endorsement.Contract.BASE_PATH)
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .header("Accept", MediaType.APPLICATION_JSON.toString())
                .body(ctInput, MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<ContractRequest> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<ContractResponse> resp = this.
                <ContractRequest, ContractResponse>getPipeline(ContractResponse.class).execute(context);
        return resp.getResponse();
    }

    /***
     * Consulta de contratos por chave externa da averbação
     * @param reference Chave única externa da averbação
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-garantia-ou-troca-de-titularidade-por-referencia">Consulta - Referência</a>
     * @throws TagSDKException
     */
    @Override
    public ContractPaginatedQueryResponse listContractsByReference(String reference, Pagination page) throws TagSDKException {
        RestRequest<Void> rReq = new RestRequest<>();

        Map<String, String> params = new HashMap<>();
        params.put("perPage", page.getLimit().toString());
        params.put("page", page.getPage().toString());

        String url = String.format(Constants.Endorsement.Contract.BASE_PATH_REFERENCE + "/%s", reference);

        String uri = RequestUtils.getQueryParams(url, params);

        RequestOptions<Void> restRequest = new RequestOptions<Void>()
                .method(RequestMethod.GET)
                .uri(uri)
                .header("Accept", MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<Void> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<ContractPaginatedQueryResponse> resp = this.
                <Void, ContractPaginatedQueryResponse>getPipeline(ContractPaginatedQueryResponse.class).execute(context);
        return resp.getResponse();
    }

    /***
     * Consulta de contratos por chave de identificação
     * @param key Chave de identificação
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-garantia-troca-de-titularidade-por-key">Consulta - Chave</a>
     * @throws TagSDKException
     */
    @Override
    public ContractPaginatedQueryResponse listContractsByKey(String key) throws TagSDKException {
        RestRequest<Void> rReq = new RestRequest<>();

        String uri = new StringBuilder()
                .append(Constants.Endorsement.Contract.BASE_PATH_KEY)
                .append("/")
                .append(key)
                .toString();

        RequestOptions<Void> restRequest = new RequestOptions<Void>()
                .method(RequestMethod.GET)
                .uri(uri)
                .header("Accept", MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<Void> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<ContractPaginatedQueryResponse> resp = this.
                <Void, ContractPaginatedQueryResponse>getPipeline(ContractPaginatedQueryResponse.class).execute(context);
        return resp.getResponse();
    }

    /***
     *  Consulta de contratos por chave de processamento
     * @param processKey Chave de processamento
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-garantia-ou-troca-de-titularidade-por-processkey">Consulta - ProcessKey</a>
     * @throws TagSDKException
     */
    @Override
    public ContractPaginatedQueryResponse listContractsByProcessKey(String processKey, Pagination page) throws TagSDKException {
        RestRequest<Void> rReq = new RestRequest<>();

        Map<String, String> params = new HashMap<>();
        params.put("perPage", page.getLimit().toString());
        params.put("page", page.getPage().toString());

        String url = String.format(Constants.Endorsement.Contract.BASE_PATH_PROCESS_KEY + "/%s", processKey);

        String uri = RequestUtils.getQueryParams(url, params);

        RequestOptions<Void> restRequest = new RequestOptions<Void>()
                .method(RequestMethod.GET)
                .uri(uri)
                .header("Accept", MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<Void> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<ContractPaginatedQueryResponse> resp = this.
                <Void, ContractPaginatedQueryResponse>getPipeline(ContractPaginatedQueryResponse.class).execute(context);
        return resp.getResponse();
    }

    /***
     * Consulta de contratos por parametros
     * @param queryParams Chave de processamento
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-garantia-ou-troca-de-titularidade-por-parametros">Consulta - Parâmetros</a>
     * @throws TagSDKException
     */
    @Override
    public ContractPaginatedQueryResponse listContractsWithParams(ContractQueryFilter queryParams, Pagination page) throws TagSDKException {
        RestRequest<Void> rReq = new RestRequest<>();

        String datePattern = "yyyy-MM-dd";

        Map<String, String> params = new HashMap<>();
        params.put("startContractDueDate", RequestUtils.dateParseAndFormat(queryParams.getStartContractDueDate(), datePattern));
        params.put("endContractDueDate", RequestUtils.dateParseAndFormat(queryParams.getEndContractDueDate(), datePattern));
        params.put("assetHolder", queryParams.getAssetHolder());
        params.put("startSignatureDate", RequestUtils.dateParseAndFormat(queryParams.getStartSignatureDate(), datePattern));
        params.put("endSignatureDate", RequestUtils.dateParseAndFormat(queryParams.getEndSignatureDate(), datePattern));
        params.put("startCreatedAt", RequestUtils.dateParseAndFormat(queryParams.getStartCreatedAt(), datePattern));
        params.put("endCreatedAt", RequestUtils.dateParseAndFormat(queryParams.getEndCreatedAt(), datePattern));
        params.put("perPage", page.getLimit().toString());
        params.put("page", page.getPage().toString());

        String completeUrl = RequestUtils.getQueryParams(Constants.Endorsement.Contract.BASE_PATH, params);

        RequestOptions<Void> restRequest = new RequestOptions<Void>()
                .method(RequestMethod.GET)
                .uri(completeUrl)
                .header("Accept", MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<Void> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<ContractPaginatedQueryResponse> resp = this.
                <Void, ContractPaginatedQueryResponse>getPipeline(ContractPaginatedQueryResponse.class).execute(context);
        return resp.getResponse();
    }

    /***
     * Consulta do histórico de contratos pela chave
     * @param key Chave para consulta de histórico
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-historico-de-garantia-ou-troca-de-titularidade">Consulta - ProcessKey</a>
     * @throws TagSDKException
     */
    @Override
    public ContractHistoryResponse getContractHistoryWithKey(String key) throws TagSDKException {
        RestRequest<Void> rReq = new RestRequest<>();

        String completeUrl = String.format("%s/%s", Constants.Endorsement.Contract.BASE_PATH_HISTORY, key);

        RequestOptions<Void> request = new RequestOptions<Void>()
                .method(RequestMethod.GET)
                .uri(completeUrl)
                .header("Accept", MediaType.APPLICATION_JSON.toString());


        rReq.setRestRequest(request);

        RequestCommand<Void> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<ContractHistoryResponse> resp = this.
                <Void, ContractHistoryResponse>getPipeline(ContractHistoryResponse.class).execute(context);
        return resp.getResponse();
    }

}
