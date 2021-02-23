package br.com.tag.sdk.service;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.receivable.reconciliation.*;
import br.com.tag.sdk.service.reicevable.reconciliation.IReconciliationService;
import br.com.tag.sdk.service.reicevable.reconciliation.ReconciliationService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Disabled
class ReconciliationTest extends BaseTest {

    private IReconciliationService rService = null;

    @BeforeAll
    @Override
    public void setup() throws IOException, TagSDKException {
        super.setup();
        rService = new ReconciliationService(this.options);
    }

    @Test
    void insertReconciliation() throws TagSDKException {
        ReconciliationRequest rInput = new ReconciliationRequest();
        rInput.setReconciliationDate(Date.from(Instant.now()));

        ReconciliationResponse response = rService.insertConciliation(new ReconciliationRequest(Date.from(Instant.now())));

        print(response);

        assertNotNull(response);
    }

    @Test
    void getReconciliationWithKey() throws TagSDKException {
        ReconciliationQueryResponse response = rService.getReconciliationWithKey("42ea18fd-a5d9-4bf9-a9c9-bc0515edb615");
        print(response);
        assertNotNull(response);
    }

    @Test
    void confirmReconciliation() throws TagSDKException {

        ReconciliationRequest rInput = new ReconciliationRequest();
        rInput.setReconciliationDate(Date.from(Instant.now()));

        ReconciliationResponse response = rService.insertConciliation(new ReconciliationRequest(Date.from(Instant.now())));

        ReconciliationConfirmationResponse confResp = rService.confirmReconciliation(response.getReconciliationKey(),
                new ReconciliationConfirmationRequest(response.getReconciliationKey()));
        print(confResp);

        assertNotNull(confResp);
    }

}
