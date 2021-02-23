package br.com.tag.sdk;

import br.com.tag.sdk.service.IService;
import br.com.tag.sdk.service.customer.ICommercialEstablishmentService;
import br.com.tag.sdk.service.reicevable.advancement.IAdvancementService;
import br.com.tag.sdk.service.reicevable.consent.IConsentService;
import br.com.tag.sdk.service.reicevable.contract.IContractService;
import br.com.tag.sdk.service.reicevable.notification.INotificationService;
import br.com.tag.sdk.service.reicevable.position.IPositionService;
import br.com.tag.sdk.service.reicevable.reconciliation.IReconciliationService;
import br.com.tag.sdk.service.reicevable.register.IReceivableService;
import br.com.tag.sdk.service.reicevable.settlement.ISettlementService;
import br.com.tag.sdk.service.reicevable.transaction.ITransactionService;

import java.util.Map;

public class TagServiceCollection {

    private final Map<String, IService> services;

    public TagServiceCollection(Map<String, IService> services) {
        this.services = services;
    }

    public ICommercialEstablishmentService getCommercialEstablishmentService() {
        return (ICommercialEstablishmentService) this.services.get(Constants.Services.COMMERCIAL_ESTABLISHMENT_SERVICE);
    }

    public IAdvancementService getAdvancementService() {
        return (IAdvancementService) this.services.get(Constants.Services.ADVANCEMENT_SERVICE);
    }

    public IConsentService getConsentService() {
        return (IConsentService) this.services.get(Constants.Services.CONSENT_SERVICE);
    }

    public IContractService getContractService() {
        return (IContractService) this.services.get(Constants.Services.CONTRACT_SERVICE);
    }

    public INotificationService getNotificationService() {
        return (INotificationService) this.services.get(Constants.Services.NOTIFICATION_SERVICE);
    }

    public IPositionService getPositionService() {
        return (IPositionService) this.services.get(Constants.Services.POSITION_SERVICE);
    }

    public IReconciliationService getReconciliationService() {
        return (IReconciliationService) this.services.get(Constants.Services.RECONCILIATION_SERVICE);
    }

    public IReceivableService getReceivableService() {
        return (IReceivableService) this.services.get(Constants.Services.RECEIVABLE_SERVICE);
    }

    public ISettlementService getSettlementService() {
        return (ISettlementService) this.services.get(Constants.Services.SETTLEMENT_SERVICE);
    }

    public ITransactionService getTransactionService() {
        return (ITransactionService) this.services.get(Constants.Services.TRANSACTION_SERVICE);
    }

}
