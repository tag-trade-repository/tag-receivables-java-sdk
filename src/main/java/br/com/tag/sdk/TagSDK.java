package br.com.tag.sdk;

import br.com.tag.sdk.service.IService;
import br.com.tag.sdk.service.customer.CommercialEstablishmentService;
import br.com.tag.sdk.service.reicevable.advancement.AdvancementService;
import br.com.tag.sdk.service.reicevable.consent.ConsentService;
import br.com.tag.sdk.service.reicevable.contract.ContractService;
import br.com.tag.sdk.service.reicevable.notification.NotificationService;
import br.com.tag.sdk.service.reicevable.position.PositionService;
import br.com.tag.sdk.service.reicevable.register.ReceivableService;
import br.com.tag.sdk.service.reicevable.settlement.SettlementService;
import br.com.tag.sdk.service.reicevable.transaction.TransactionService;

import java.util.HashMap;
import java.util.Map;

public class TagSDK {

    private static TagServiceCollection factory = null;

    public static TagServiceCollection getServices(SDKOptions options) {
        if(factory == null) {
            Map<String, IService> services = new HashMap<>();
            registerServices(services, options);
            factory = new TagServiceCollection(services);
        }
        return factory;
    }

    private static void registerServices(Map<String, IService> services, SDKOptions options) {
        services.put(Constants.Services.SETTLEMENT_SERVICE, new SettlementService(options));
        services.put(Constants.Services.CONTRACT_SERVICE, new ContractService(options));
        services.put(Constants.Services.NOTIFICATION_SERVICE, new NotificationService(options));
        services.put(Constants.Services.RECEIVABLE_SERVICE, new ReceivableService(options));
        services.put(Constants.Services.CONSENT_SERVICE, new ConsentService(options));
        services.put(Constants.Services.POSITION_SERVICE, new PositionService(options));
        services.put(Constants.Services.RECONCILIATION_SERVICE, new ReceivableService(options));
        services.put(Constants.Services.ADVANCEMENT_SERVICE, new AdvancementService(options));
        services.put(Constants.Services.TRANSACTION_SERVICE, new TransactionService(options));
        services.put(Constants.Services.COMMERCIAL_ESTABLISHMENT_SERVICE, new CommercialEstablishmentService(options));
    }

}
