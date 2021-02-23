package br.com.tag.sdk.service;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.BankAccount;
import br.com.tag.sdk.model.enums.AccountBankAccountType;
import br.com.tag.sdk.model.enums.DocumentType;
import br.com.tag.sdk.model.receivable.settlement.*;
import br.com.tag.sdk.model.request.Pagination;
import br.com.tag.sdk.model.response.BaseResponse;
import br.com.tag.sdk.service.reicevable.settlement.ISettlementService;
import br.com.tag.sdk.service.reicevable.settlement.SettlementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Disabled
class SettlementTest extends BaseTest {

    private ISettlementService receivableSettlementService = null;

    @BeforeAll
    @Override
    public void setup() throws IOException, TagSDKException {
        super.setup();
        receivableSettlementService = new SettlementService(this.options);
    }

    @Test
    void callSettlementVanillaTest() throws TagSDKException {

        BankAccount bankAccount = new BankAccount(
                "1144",
                "13341",
                "X5",
                AccountBankAccountType.CC,
                "12345678",
                DocumentType.CNPJ,
                "51914361000184");

        Settlement receivableSettlementItem = new Settlement(
                "ST-01",
                DocumentType.CNPJ,
                "51914361000184",
                Date.from(Instant.now()),
                BigDecimal.valueOf(500).setScale(2),
                Date.from(Instant.now()),
                "VCC",
                bankAccount);

        List<Settlement> settlements = new ArrayList<>();
        settlements.add(receivableSettlementItem);

        SettlementRequest receivableSettlementInput = new SettlementRequest();
        receivableSettlementInput.setSettlements(settlements);

        SettlementResponse receivableSettlementOutput = receivableSettlementService.reportSettlement(receivableSettlementInput);

        print(receivableSettlementOutput);

        Assertions.assertNotNull(receivableSettlementOutput.getProcessKey());
        Assertions.assertNotNull(receivableSettlementOutput.getCreatedAt());
    }

    @Test
    void rejectSettlementVanillaTest() throws TagSDKException {
        SettlementReject receivableSettlementItem = new SettlementReject();
        receivableSettlementItem.setKey("df78ff30-1825-4922-b26f-856f28652c1e");
        receivableSettlementItem.setReasonDetails("Liquidacao nao executada.");

        List<SettlementReject> settlements = new ArrayList<>();
        settlements.add(receivableSettlementItem);

        SettlementRejectRequest receivableSettlementInput = new SettlementRejectRequest(settlements);

        BaseResponse receivableSettlementOutput = receivableSettlementService.rejectSettlement(receivableSettlementInput);

        print(receivableSettlementOutput);

        Assertions.assertNotNull(receivableSettlementOutput.getProcessKey());
        Assertions.assertNotNull(receivableSettlementOutput.getCreatedAt());
    }

    @Test
    void queryByKey() throws TagSDKException {
        SettlementQueryResponse response = receivableSettlementService.getSettlementByKey("df78ff30-1825-4922-b26f-856f28652c1e");

        print(response);

        Assertions.assertNotNull(response);
    }

    @Test
    void queryByProcessKey() throws TagSDKException {
        Pagination pag = new Pagination(1, 100);
        SettlementPaginatedQueryResponse response = receivableSettlementService.getSettlementByProcessKey("dad71f6e-3de6-4dcd-bb54-abe08d944ae8", pag);

        print(response);
        Assertions.assertNotNull(response);
    }

    @Test
    void queryByReference() throws TagSDKException {
        Pagination pag = new Pagination(1, 100);
        SettlementPaginatedQueryResponse response = receivableSettlementService.getSettlementByReference("L_1875", pag);

        print(response);
        Assertions.assertNotNull(response);
    }

    @Test
    void callSettlementWithParamsVanillaTest() throws TagSDKException {
        SettlementQueryFilter settlementParams = new SettlementQueryFilter();
        settlementParams.setStartSettlementDate(Date.valueOf("2020-01-19"));
        settlementParams.setEndSettlementDate(Date.from(Instant.now()));
        settlementParams.setPaymentScheme("VCC");
        settlementParams.setAssetHolder("51914361000184");

        Pagination pag = new Pagination(1, 100);

        SettlementPaginatedQueryResponse response = this.receivableSettlementService.getSettlementWithParams(settlementParams, pag);

        print(response);
        Assertions.assertNotNull(response);
    }

}