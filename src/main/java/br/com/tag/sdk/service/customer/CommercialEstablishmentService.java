package br.com.tag.sdk.service.customer;

import br.com.tag.sdk.Constants;
import br.com.tag.sdk.SDKOptions;
import br.com.tag.sdk.commands.RequestCommand;
import br.com.tag.sdk.commands.ResponseCommand;
import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.customer.CommercialEstablishmentPaginatedQueryResponse;
import br.com.tag.sdk.model.customer.CommercialEstablishmentRequest;
import br.com.tag.sdk.model.customer.CommercialEstablishmentResponse;
import br.com.tag.sdk.model.customer.CommercialEstablishmentUpdateRequest;
import br.com.tag.sdk.model.enums.Profile;
import br.com.tag.sdk.model.request.*;
import br.com.tag.sdk.model.response.BaseResponse;
import br.com.tag.sdk.service.BaseService;
import br.com.tag.sdk.utils.RequestUtils;

import java.util.HashMap;
import java.util.Map;

/***
 * @author 7Comm
 * @version 1.0.0
 */
public class CommercialEstablishmentService extends BaseService implements ICommercialEstablishmentService {

    public CommercialEstablishmentService(SDKOptions options) {
        super(options, Profile.ACQUIRER);
    }

    /***
     * Insere um estabelecimento comercial
     * @param cEstablishmentReq Estabelecimento Comercial
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/estabelecimento-comercial">Cadastro</a>
     * @throws TagSDKException
     */
    @Override
    public CommercialEstablishmentResponse registerCommercialEstablishments(CommercialEstablishmentRequest cEstablishmentReq) throws TagSDKException {
        RestRequest<CommercialEstablishmentRequest> rReq = new RestRequest<>();

        RequestOptions<CommercialEstablishmentRequest> restRequest = new RequestOptions<CommercialEstablishmentRequest>()
                .method(RequestMethod.POST)
                .uri(Constants.CommercialEstablishment.BASE_PATH)
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .header("Accept", MediaType.APPLICATION_JSON.toString())
                .body(cEstablishmentReq, MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<CommercialEstablishmentRequest> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<CommercialEstablishmentResponse> resp = this.
                <CommercialEstablishmentRequest, CommercialEstablishmentResponse>getPipeline(CommercialEstablishmentResponse.class)
                .execute(context);
        return resp.getResponse();
    }

    /***
     * Atualiza um estabelecimento comercial
     * @param cEstablishmentReq Estabelecimento Comercial
     * @param docNumber Número do documento
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/altera%C3%A7%C3%A3o-de-ec">Alteração</a>
     * @throws TagSDKException
     */
    @Override
    public BaseResponse updateCommercialEstablishments(String docNumber, CommercialEstablishmentUpdateRequest cEstablishmentReq) throws TagSDKException {
        RestRequest<CommercialEstablishmentUpdateRequest> rReq = new RestRequest<>();

        String uri = String.format(Constants.CommercialEstablishment.BASE_PATH_DOCUMENT_NUMBER, docNumber);

        RequestOptions<CommercialEstablishmentUpdateRequest> restRequest = new RequestOptions<CommercialEstablishmentUpdateRequest>()
                .method(RequestMethod.PATCH)
                .uri(uri)
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .header("Accept", MediaType.APPLICATION_JSON.toString())
                .body(cEstablishmentReq, MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<CommercialEstablishmentUpdateRequest> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<BaseResponse> resp = this.
                <CommercialEstablishmentUpdateRequest, BaseResponse>getPipeline(BaseResponse.class).execute(context);
        return resp.getResponse();
    }

    /***
     * Lista estabelecimentos comerciais
     * @param pagination Objeto de paginação
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-ec-por-par%C3%A2metros-perpage-e-page">Consulta por Paginação</a>
     * @throws TagSDKException
     */
    @Override
    public CommercialEstablishmentPaginatedQueryResponse getCommercialEstablishmentsWithPagination(Pagination pagination) throws TagSDKException {
        RestRequest<Void> rReq = new RestRequest<>();

        Map<String, String> params = new HashMap<>();
        params.put("perPage", String.valueOf(pagination.getLimit()));
        params.put("currentPage", String.valueOf(pagination.getPage()));

        RequestOptions<Void> restRequest = new RequestOptions<Void>()
                .method(RequestMethod.GET)
                .uri(RequestUtils.getQueryParams(Constants.CommercialEstablishment.BASE_PATH, params))
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .header("Accept", MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<Void> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<CommercialEstablishmentPaginatedQueryResponse> resp = this.
                <Void, CommercialEstablishmentPaginatedQueryResponse>getPipeline(CommercialEstablishmentPaginatedQueryResponse.class).execute(context);
        return resp.getResponse();
    }

    /***
     * Lista um estabelecimento comercial pelo número do documento
     * @param documentNumber Número do Documento
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-ec-por-documentnumber">Consulta por DocumentNumber</a>
     * @throws TagSDKException
     */
    @Override
    public CommercialEstablishmentResponse getCommercialEstablishmentsWithDocumentNumber(String documentNumber) throws TagSDKException {
        RestRequest<Void> rReq = new RestRequest<>();

        String uri = String.format(Constants.CommercialEstablishment.BASE_PATH_DOCUMENT_NUMBER, documentNumber);

        RequestOptions<Void> restRequest = new RequestOptions<Void>()
                .method(RequestMethod.GET)
                .uri(uri)
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .header("Accept", MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<Void> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<CommercialEstablishmentResponse> resp = this.
                <Void, CommercialEstablishmentResponse>getPipeline(CommercialEstablishmentResponse.class).execute(context);
        return resp.getResponse();
    }

}
