package br.com.tag.sdk.service.reicevable.consent;

import br.com.tag.sdk.Constants;
import br.com.tag.sdk.SDKOptions;
import br.com.tag.sdk.commands.RequestCommand;
import br.com.tag.sdk.commands.ResponseCommand;
import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.enums.Profile;
import br.com.tag.sdk.model.receivable.consent.*;
import br.com.tag.sdk.model.request.MediaType;
import br.com.tag.sdk.model.request.RequestMethod;
import br.com.tag.sdk.model.request.RequestOptions;
import br.com.tag.sdk.model.request.RestRequest;
import br.com.tag.sdk.model.response.BaseResponse;
import br.com.tag.sdk.service.BaseService;
import br.com.tag.sdk.utils.RequestUtils;

import java.util.HashMap;
import java.util.Map;

/***
 * @author 7Comm
 * @version 1.0.0
 */
public class ConsentService extends BaseService implements IConsentService {

    public ConsentService(SDKOptions options) {
        super(options, Profile.CREDITOR);
    }

    /***
     * Cadastra um ou mais Opt Ins
     * @param consentRequest Opt Ins a serem cadastrados.
     * @param profile Perfil que irá inserir os Opt Ins
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/opt-in">Opt In</a>
     * @throws TagSDKException
     */
    @Override
    public ConsentResponse insertConsents(ConsentRequest consentRequest, Profile profile) throws TagSDKException {
        RestRequest<ConsentRequest> rReq = new RestRequest<>();

        RequestOptions<ConsentRequest> restRequest = new RequestOptions<ConsentRequest>()
                .method(RequestMethod.POST)
                .uri(Constants.Consent.BASE_PATH_OPT_IN)
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .header("Accept", MediaType.APPLICATION_JSON.toString())
                .body(consentRequest, MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<ConsentRequest> context = new RequestCommand<>(rReq, profile);

        ResponseCommand<ConsentResponse> resp = this.
                <ConsentRequest, ConsentResponse>getPipeline(ConsentResponse.class).execute(context);
        return resp.getResponse();
    }

    /***
     * Rejeita um ou mais Opt Ins
     * @param optInRejInput Opt Ins a serem cadastrados.
     * @param profile Perfil que irá rejeitar os Opt Ins
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/rejei%C3%A7%C3%A3o-opt-in">Rejeição Opt In</a>
     * @throws TagSDKException
     */
    @Override
    public BaseResponse rejectOptIn(ConsentRejectRequest optInRejInput, Profile profile) throws TagSDKException {
        RestRequest<ConsentRejectRequest> rReq = new RestRequest<>();

        RequestOptions<ConsentRejectRequest> restRequest = new RequestOptions<ConsentRejectRequest>()
                .method(RequestMethod.POST)
                .uri(Constants.Consent.BASE_PATH_OPT_IN_REJECT)
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .header("Accept", MediaType.APPLICATION_JSON.toString())
                .body(optInRejInput, MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<ConsentRejectRequest> context = new RequestCommand<>(rReq, profile);

        ResponseCommand<BaseResponse> resp = this.
                <ConsentRejectRequest, BaseResponse>getPipeline(BaseResponse.class).execute(context);
        return resp.getResponse();
    }

    /***
     * Altera um OptOut
     * @param key Chave de identificação de uma Opt In
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/opt-out">Opt Out</a>
     * @throws TagSDKException
     */
    @Override
    public BaseResponse patchOptOut(String key) throws TagSDKException {
        RestRequest<String> rReq = new RestRequest<>();

        String uri = String.format(Constants.Consent.BASE_PATH_OPT_OUT, key);

        String emptyBody = "";

        RequestOptions<String> restRequest = new RequestOptions<String>()
                .method(RequestMethod.PATCH)
                .uri(uri)
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .header("Accept", MediaType.APPLICATION_JSON.toString())
                .body(emptyBody, MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<String> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<BaseResponse> resp = this.
                <String, BaseResponse>getPipeline(BaseResponse.class).execute(context);
        return resp.getResponse();
    }

    /***
     * Altera a data de vigência de um Opt In
     * @param key Chave de identificação de uma Opt In
     * @param optInVChange Objeto contendo as novas datas
     * @param profile Perfil que irá alterar os Opt Ins
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/altera%C3%A7%C3%A3o-de-data-de-vig%C3%AAncia">Alteração de Data de Vigência</a>
     * @throws TagSDKException
     */
    @Override
    public BaseResponse changeOptInValidityDate(String key, ConsentValidityChangeRequest optInVChange, Profile profile) throws TagSDKException {
        RestRequest<ConsentValidityChangeRequest> rReq = new RestRequest<>();

        String uri = String.format(Constants.Consent.BASE_PATH_OPT_IN_CHANGE_VALIDITY, key);

        RequestOptions<ConsentValidityChangeRequest> restRequest = new RequestOptions<ConsentValidityChangeRequest>()
                .method(RequestMethod.PATCH)
                .uri(uri)
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .header("Accept", MediaType.APPLICATION_JSON.toString())
                .body(optInVChange, MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<ConsentValidityChangeRequest> context = new RequestCommand<>(rReq, profile);

        ResponseCommand<BaseResponse> resp = this.
                <ConsentValidityChangeRequest, BaseResponse>getPipeline(BaseResponse.class).execute(context);
        return resp.getResponse();
    }

    /***
     * Consulta um OptIn por chave
     * @param key Chave do Opt In
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-opt-in-por-key">Consulta - Key</a>
     * @throws TagSDKException
     */
    @Override
    public ConsentQueryResponse getOptInWithKey(String key) throws TagSDKException {
        RestRequest<Void> rReq = new RestRequest<>();

        String uri = String.format(Constants.Consent.BASE_PATH_OPT_IN_KEY, key);


        RequestOptions<Void> restRequest = new RequestOptions<Void>()
                .method(RequestMethod.GET)
                .uri(uri)
                .header("Accept", MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<Void> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<ConsentQueryResponse> resp = this.
                <Void, ConsentQueryResponse>getPipeline(ConsentQueryResponse.class).execute(context);
        return resp.getResponse();
    }

    /***
     * Consulta um OptIn filtrando por parâmetros
     * @param consentQueryFilter Filtro
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-opt-in-por-par%C3%A2metros">Consulta - Parâmetros</a>
     * @throws TagSDKException
     */
    @Override
    public ConsentQueryParameterizedResponse getOptInWithParams(ConsentQueryFilter consentQueryFilter) throws TagSDKException {
        RestRequest<Void> rReq = new RestRequest<>();

        String datePattern = "yyyy-MM-dd";

        Map<String, String> params = new HashMap<>();
        params.put("assetHolder", consentQueryFilter.getAssetHolder());
        params.put("beneficiary", consentQueryFilter.getBeneficiary());
        params.put("acquirer", consentQueryFilter.getAcquirer());
        params.put("paymentScheme", consentQueryFilter.getPaymentScheme());
        params.put("initialDate", RequestUtils.dateParseAndFormat(consentQueryFilter.getInitialDate(), datePattern));
        params.put("finalDate", RequestUtils.dateParseAndFormat(consentQueryFilter.getFinalDate(), datePattern));

        String uri = RequestUtils.getQueryParams(Constants.Consent.BASE_PATH_OPT_IN_PARAMS, params);

        RequestOptions<Void> restRequest = new RequestOptions<Void>()
                .method(RequestMethod.GET)
                .uri(uri)
                .header("Accept", MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<Void> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<ConsentQueryParameterizedResponse> resp = this.
                <Void, ConsentQueryParameterizedResponse>getPipeline(ConsentQueryParameterizedResponse.class).execute(context);
        return resp.getResponse();
    }

}
