package br.com.tag.sdk.service.reicevable.notification;

import br.com.tag.sdk.Constants;
import br.com.tag.sdk.SDKOptions;
import br.com.tag.sdk.commands.RequestCommand;
import br.com.tag.sdk.commands.ResponseCommand;
import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.enums.EventType;
import br.com.tag.sdk.model.enums.Profile;
import br.com.tag.sdk.model.receivable.notification.*;
import br.com.tag.sdk.model.request.*;
import br.com.tag.sdk.service.BaseService;
import br.com.tag.sdk.utils.RequestUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * @author 7Comm
 * @version 1.0.0
 */
public class NotificationService extends BaseService implements INotificationService {

    private final ObjectMapper mapper = new ObjectMapper();

    public NotificationService(SDKOptions options) {
        super(options, Profile.ACQUIRER, Profile.CREDITOR);
    }

    /***
     * Consulta notificações de liquidação
     * @param profile Perfil que irá consultar as notificações
     * @param date Data em que as notificações foram enviadas.
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-de-liquida%C3%A7%C3%A3o">Liquidação</a>
     * @throws TagSDKException
     */
    @Override
    public List<NotificationDefaultResponse<NotificationSettlement>> getSettlementNotification(Date date, Profile profile) throws TagSDKException {
        try {
            RestRequest<Void> rReq = new RestRequest<>();

            Map<String, String> queryParams = new HashMap<>();
            queryParams.put("notificationType", EventType.SETTLEMENT.getValue());
            queryParams.put("date", RequestUtils.dateParseAndFormat(date, "yyyy-MM-dd"));

            String uri = RequestUtils.getQueryParams(Constants.Notification.BASE_PATH, queryParams);

            RequestOptions<Void> request = new RequestOptions<Void>()
                    .method(RequestMethod.GET)
                    .uri(uri)
                    .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                    .header("Accept", MediaType.APPLICATION_JSON.toString());

            rReq.setRestRequest(request);

            RequestCommand<Void> context = new RequestCommand<>(rReq, profile);

            ResponseCommand<String> resp = this.
                    <Void, String>getPipeline(String.class).execute(context);

            List<NotificationDefaultResponse<NotificationSettlement>> parsedReturn = mapper.readValue(resp.getResponse(), new TypeReference<List<NotificationDefaultResponse<NotificationSettlement>>>() {
            });

            return parsedReturn;
        }catch (Exception ex){
            throw new TagSDKException(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /***
     * Consulta notificações de rejeição de liquidação
     * @param profile Perfil que irá consultar as notificações
     * @param date Data em que as notificações foram enviadas.
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-de-rejei%C3%A7%C3%A3o-de-liquida%C3%A7%C3%A3o">Rejeição de Liquidação</a>
     * @throws TagSDKException
     */
    @Override
    public List<NotificationDefaultResponse<NotificationSettlementReject>> getSettlementRejectNotification(Date date, Profile profile) throws TagSDKException {
        try {
            RestRequest<Void> rReq = new RestRequest<>();

            Map<String, String> queryParams = new HashMap<>();
            queryParams.put("notificationType", EventType.SETTLEMENTREJECT.getValue());
            queryParams.put("date", RequestUtils.dateParseAndFormat(date, "yyyy-MM-dd"));

            String uri = RequestUtils.getQueryParams(Constants.Notification.BASE_PATH, queryParams);

            RequestOptions<Void> request = new RequestOptions<Void>()
                    .method(RequestMethod.GET)
                    .uri(uri)
                    .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                    .header("Accept", MediaType.APPLICATION_JSON.toString());

            rReq.setRestRequest(request);

            RequestCommand<Void> context = new RequestCommand<>(rReq, profile);

            ResponseCommand<String> resp = this.
                    <Void, String>getPipeline(String.class).execute(context);

            List<NotificationDefaultResponse<NotificationSettlementReject>> parsedReturn = mapper.readValue(resp.getResponse(), new TypeReference<List<NotificationDefaultResponse<NotificationSettlementReject>>>() {
            });

            return parsedReturn;
        }catch (Exception ex) {
            throw new TagSDKException(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /***
     * Consulta notificações de antecipação
     * @param profile Perfil que irá consultar as notificações
     * @param date Data em que as notificações foram enviadas.
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-de-antecipa%C3%A7%C3%A3o-p%C3%B3s-contratada">Antecipação Pós Contratada</a>
     * @throws TagSDKException
     */
    @Override
    public List<NotificationDefaultResponse<NotificationAdvancement>> getAdvancementNotification(Date date, Profile profile) throws TagSDKException {
          try {
            RestRequest<Void> rReq = new RestRequest<>();

            Map<String, String> queryParams = new HashMap<>();
            queryParams.put("notificationType", EventType.ADVANCEMNT.getValue());
            queryParams.put("date", RequestUtils.dateParseAndFormat(date, "yyyy-MM-dd"));

            String uri = RequestUtils.getQueryParams(Constants.Notification.BASE_PATH, queryParams);

            RequestOptions<Void> request = new RequestOptions<Void>()
                    .method(RequestMethod.GET)
                    .uri(uri)
                    .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                    .header("Accept", MediaType.APPLICATION_JSON.toString());

            rReq.setRestRequest(request);

            RequestCommand<Void> context = new RequestCommand<>(rReq, profile);

            ResponseCommand<String> resp = this.
                    <Void, String>getPipeline(String.class).execute(context);

            List<NotificationDefaultResponse<NotificationAdvancement>> parsedReturn = mapper.readValue(resp.getResponse(), new TypeReference<List<NotificationDefaultResponse<NotificationAdvancement>>>() {
            });

            return parsedReturn;
        }catch (Exception ex) {
            throw new TagSDKException(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /***
     * Consulta notificações de contrato
     * @param profile Perfil que irá consultar as notificações
     * @param date Data em que as notificações foram enviadas.
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-de-contrato">Ônus e Gravames ou Alteração de Titularidade</a>
     * @throws TagSDKException
     */
    @Override
    public List<NotificationDefaultResponse<NotificationContract>> getContractNotification(Date date, Profile profile) throws TagSDKException {
        try {
            RestRequest<Void> rReq = new RestRequest<>();

            Map<String, String> queryParams = new HashMap<>();
            queryParams.put("notificationType", EventType.CONTRACT.getValue());
            queryParams.put("date", RequestUtils.dateParseAndFormat(date, "yyyy-MM-dd"));

            String uri = RequestUtils.getQueryParams(Constants.Notification.BASE_PATH, queryParams);

            RequestOptions<Void> request = new RequestOptions<Void>()
                    .method(RequestMethod.GET)
                    .uri(uri)
                    .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                    .header("Accept", MediaType.APPLICATION_JSON.toString());

            rReq.setRestRequest(request);

            RequestCommand<Void> context = new RequestCommand<>(rReq, profile);

            ResponseCommand<String> resp = this.
                    <Void, String>getPipeline(String.class).execute(context);

            List<NotificationDefaultResponse<NotificationContract>> parsedReturn = mapper.readValue(resp.getResponse(), new TypeReference<List<NotificationDefaultResponse<NotificationContract>>>() {
            });

            return parsedReturn;
        }catch (Exception ex) {
            throw new TagSDKException(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /***
     * Consulta notificações de consentimento
     * @param profile Perfil que irá consultar as notificações
     * @param date Data em que as notificações foram enviadas.
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/notificacao-de-opt-in">Opt In</a>
     * @throws TagSDKException
     */
    @Override
    public List<NotificationDefaultResponse<NotificationConsentWrapper>> getConsentNotification(Date date, Profile profile) throws TagSDKException {
        try {
            RestRequest<Void> rReq = new RestRequest<>();

            Map<String, String> queryParams = new HashMap<>();
            queryParams.put("notificationType", EventType.CONSENT.getValue());
            queryParams.put("date", RequestUtils.dateParseAndFormat(date, "yyyy-MM-dd"));

            String uri = RequestUtils.getQueryParams(Constants.Notification.BASE_PATH, queryParams);

            RequestOptions<Void> request = new RequestOptions<Void>()
                    .method(RequestMethod.GET)
                    .uri(uri)
                    .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                    .header("Accept", MediaType.APPLICATION_JSON.toString());

            rReq.setRestRequest(request);

            RequestCommand<Void> context = new RequestCommand<>(rReq, profile);

            ResponseCommand<String> resp = this.
                    <Void, String>getPipeline(String.class).execute(context);

            List<NotificationDefaultResponse<NotificationConsentWrapper>> parsedReturn = mapper.readValue(resp.getResponse(), new TypeReference<List<NotificationDefaultResponse<NotificationConsentWrapper>>>() {
            });

            return parsedReturn;
        }catch (Exception ex) {
            throw new TagSDKException(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /***
     * Consulta notificações por chave de processamento
     * @param profile Perfil que irá consultar as notificações
     * @param pkey Chave de processamento para consulta
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-por-processkey">Por Processkey</a>
     * @throws TagSDKException
     */
    @Override
    public List<NotificationDefaultResponse<NotificationContract>> getNotificationProcessKey(String pkey, Profile profile) throws TagSDKException {
        try {
            RestRequest<Void> rReq = new RestRequest<>();

            RequestOptions<Void> request = new RequestOptions<Void>()
                    .method(RequestMethod.GET)
                    .uri(String.format(Constants.Notification.BASE_PATH_PROCESS_KEY, pkey))
                    .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                    .header("Accept", MediaType.APPLICATION_JSON.toString());

            rReq.setRestRequest(request);

            RequestCommand<Void> context = new RequestCommand<>(rReq, profile);

            ResponseCommand<String> resp = this.
                    <Void, String>getPipeline(String.class).execute(context);

            List<NotificationDefaultResponse<NotificationContract>> parsedReturn = mapper.readValue(resp.getResponse(), new TypeReference<List<NotificationDefaultResponse<NotificationContract>>>() {
            });

            return parsedReturn;
        }catch (Exception ex) {
            throw new TagSDKException(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /***
     * Consulta notificações por chave
     * @param profile Perfil que irá consultar as notificações
     * @param key Chave de identificação para consulta
     * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-por-key">Por key</a>
     * @throws TagSDKException
     */
    @Override
    public List<NotificationDefaultResponse<NotificationContract>> getNotificationKey(String key, Profile profile) throws TagSDKException {
        try {
            RestRequest<Void> rReq = new RestRequest<>();

            RequestOptions<Void> request = new RequestOptions<Void>()
                    .method(RequestMethod.GET)
                    .uri(String.format(Constants.Notification.BASE_PATH_KEY, key))
                    .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                    .header("Accept", MediaType.APPLICATION_JSON.toString());

            rReq.setRestRequest(request);

            RequestCommand<Void> context = new RequestCommand<>(rReq, profile);

            ResponseCommand<String> resp = this.
                    <Void, String>getPipeline(String.class).execute(context);

            List<NotificationDefaultResponse<NotificationContract>> parsedReturn = mapper.readValue(resp.getResponse(), new TypeReference<List<NotificationDefaultResponse<NotificationContract>>>() {
            });

            return parsedReturn;
        }catch (Exception ex) {
            throw new TagSDKException(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
