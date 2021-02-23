package br.com.tag.sdk.service.reicevable.position;

import br.com.tag.sdk.Constants;
import br.com.tag.sdk.SDKOptions;
import br.com.tag.sdk.commands.RequestCommand;
import br.com.tag.sdk.commands.ResponseCommand;
import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.enums.Profile;
import br.com.tag.sdk.model.receivable.position.PositionExpectationQueryResponse;
import br.com.tag.sdk.model.receivable.position.PositionQueryFilter;
import br.com.tag.sdk.model.receivable.position.PositionReceivablesQueryResponse;
import br.com.tag.sdk.model.request.MediaType;
import br.com.tag.sdk.model.request.RequestMethod;
import br.com.tag.sdk.model.request.RequestOptions;
import br.com.tag.sdk.model.request.RestRequest;
import br.com.tag.sdk.service.BaseService;
import br.com.tag.sdk.utils.RequestUtils;

import java.util.HashMap;
import java.util.Map;

/***
 * @author 7Comm
 * @version 1.0.0
 */
public class PositionService extends BaseService implements IPositionService {

    public PositionService(SDKOptions options) {
        super(options, Profile.ACQUIRER);
    }

    /***
     * Consulta posições de agenda por chave
     * @param key Chave da Unidade de Recebíveis
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-por-key">Consulta - Key</a>
     * @throws TagSDKException
     */
    @Override
    public PositionReceivablesQueryResponse getPositionsWithKey(String key) throws TagSDKException {
        return this.getPosition(Constants.Position.BASE_PATH_KEY, key);
    }

    /***
     * Consulta posições de agenda por referência
     * @param reference Chave única externa na Unidade de Recebíveis
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-por-reference">Consulta - Referência</a>
     * @throws TagSDKException
     */
    @Override
    public PositionReceivablesQueryResponse getPositionsWithReference(String reference) throws TagSDKException {
        return this.getPosition(Constants.Position.BASE_PATH_REFERENCE, reference);
    }

    /***
     * Consulta posições de agenda por chave de processamento
     * @param processReference Chave de processamento do lote de Unidade de Recebíveis
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-por-process-reference">Consulta - ProcessReference</a>
     * @throws TagSDKException
     */
    @Override
    public PositionReceivablesQueryResponse getPositionsWithProcessReference(String processReference) throws TagSDKException {
        return this.getPosition(Constants.Position.BASE_PATH_PROCESS_REFERENCE, processReference);
    }

    /***
     * Consulta posições de agenda pelo originador do ativo
     * @param originalAssetHolder Originador dos Ativos a serem consultados
     * @param paramsObj Filtro a ser aplicado na consulta
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-originador">Consulta - Originador</a>
     * @throws TagSDKException
     */
    @Override
    public PositionReceivablesQueryResponse getPositionsWithOriginalAssetHolder(String originalAssetHolder, PositionQueryFilter paramsObj) throws TagSDKException {
        RestRequest<Void> rReq = new RestRequest<>();

        String datePattern = "yyyy-MM-dd";

        Map<String, String> params = new HashMap<>();
        params.put("initialExpectedSettlementDate", RequestUtils.dateParseAndFormat(paramsObj.getInitialExpectedSettlementDate(), datePattern));
        params.put("finalExpectedSettlementDate", RequestUtils.dateParseAndFormat(paramsObj.getFinalExpectedSettlementDate(), datePattern));
        params.put("paymentScheme", paramsObj.getPaymentScheme());

        String urlWithPath = String.format(Constants.Position.BASE_PATH_ORIGINAL_ASSET_HOLDER, originalAssetHolder);
        String completeUrl = RequestUtils.getQueryParams(urlWithPath, params);

        RequestOptions<Void> request = new RequestOptions<Void>()
                .method(RequestMethod.GET)
                .uri(completeUrl)
                .header("Accept", MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(request);

        RequestCommand<Void> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<PositionReceivablesQueryResponse> resp = this.
                <Void, PositionReceivablesQueryResponse>getPipeline(PositionReceivablesQueryResponse.class).execute(context);
        return resp.getResponse();
    }

    /***
     * Consulta posições de agenda pelo titular do ativo
     * @param assetHolder Titular dos Ativos a serem consultados
     * @param paramsObj Filtro a ser aplicado na consulta
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-titular">Consulta - Titular</a>
     * @throws TagSDKException
     */
    @Override
    public PositionExpectationQueryResponse getPositionsWithAssetHolder(String assetHolder, PositionQueryFilter paramsObj) throws TagSDKException {
        RestRequest<Void> rReq = new RestRequest<>();

        String datePattern = "yyyy-MM-dd";

        Map<String, String> params = new HashMap<>();
        params.put("initialExpectedSettlementDate", RequestUtils.dateParseAndFormat(paramsObj.getInitialExpectedSettlementDate(), datePattern));
        params.put("finalExpectedSettlementDate", RequestUtils.dateParseAndFormat(paramsObj.getFinalExpectedSettlementDate(), datePattern));
        params.put("paymentScheme", paramsObj.getPaymentScheme());

        String urlWithPath = String.format(Constants.Position.BASE_PATH_ASSET_HOLDER, assetHolder);
        String completeUrl = RequestUtils.getQueryParams(urlWithPath, params);

        RequestOptions<Void> request = new RequestOptions<Void>()
                .method(RequestMethod.GET)
                .uri(completeUrl)
                .header("Accept", MediaType.APPLICATION_JSON.toString());


        rReq.setRestRequest(request);

        RequestCommand<Void> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<PositionExpectationQueryResponse> resp = this.
                <Void, PositionExpectationQueryResponse>getPipeline(PositionExpectationQueryResponse.class).execute(context);
        return resp.getResponse();
    }

    private PositionReceivablesQueryResponse getPosition(String specificPath, String pathParam) throws TagSDKException {
        RestRequest<Void> rReq = new RestRequest<>();

        String completeReqUrl = String.format(specificPath, pathParam);

        RequestOptions<Void> restRequest = new RequestOptions<Void>()
                .method(RequestMethod.GET)
                .uri(completeReqUrl)
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .header("Accept", MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<Void> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<PositionReceivablesQueryResponse> resp = this.
                <Void, PositionReceivablesQueryResponse>getPipeline(PositionReceivablesQueryResponse.class).execute(context);
        return resp.getResponse();
    }

}
