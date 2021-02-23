package br.com.tag.sdk.service.reicevable.reconciliation;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.receivable.reconciliation.*;
import br.com.tag.sdk.service.IService;

public interface IReconciliationService extends IService {

    ReconciliationResponse insertConciliation(ReconciliationRequest reconciliationInput) throws TagSDKException;
    ReconciliationQueryResponse getReconciliationWithKey(String reconciliationKey) throws TagSDKException;
    ReconciliationConfirmationResponse confirmReconciliation(String reconciliationKey,ReconciliationConfirmationRequest recConfirmationInput) throws TagSDKException;

}
