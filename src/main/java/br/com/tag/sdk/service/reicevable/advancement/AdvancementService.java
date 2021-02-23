package br.com.tag.sdk.service.reicevable.advancement;

import br.com.tag.sdk.Constants;
import br.com.tag.sdk.SDKOptions;
import br.com.tag.sdk.commands.RequestCommand;
import br.com.tag.sdk.commands.ResponseCommand;
import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.enums.Profile;
import br.com.tag.sdk.model.receivable.advancement.AdvancementRequest;
import br.com.tag.sdk.model.request.MediaType;
import br.com.tag.sdk.model.request.RequestMethod;
import br.com.tag.sdk.model.request.RequestOptions;
import br.com.tag.sdk.model.request.RestRequest;
import br.com.tag.sdk.model.response.BaseResponse;
import br.com.tag.sdk.service.BaseService;

/***
 * @author 7Comm
 * @version 1.0.0
 */
public class AdvancementService extends BaseService implements IAdvancementService {

    public AdvancementService(SDKOptions options) {
        super(options, Profile.ACQUIRER);
    }

    /***
     * Antecipação Pós-Contratada
     * @param advInput Antecipações
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/alteracao-da-data-de-expectativa-de-liquidacao">Antecipação Pós-Contratada</a>
     * @throws TagSDKException
     */
    @Override
    public BaseResponse insertAdvancements(AdvancementRequest advInput) throws TagSDKException {
        RestRequest<AdvancementRequest> rReq = new RestRequest<>();

        RequestOptions<AdvancementRequest> restRequest = new RequestOptions<AdvancementRequest>()
                .method(RequestMethod.POST)
                .uri(Constants.Endorsement.Advancement.BASE_PATH)
                .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                .header("Accept", MediaType.APPLICATION_JSON.toString())
                .body(advInput, MediaType.APPLICATION_JSON.toString());

        rReq.setRestRequest(restRequest);

        RequestCommand<AdvancementRequest> context = new RequestCommand<>(rReq, profiles);

        ResponseCommand<BaseResponse> resp = this.
                <AdvancementRequest, BaseResponse>getPipeline(BaseResponse.class).execute(context);
        return resp.getResponse();
    }

}
