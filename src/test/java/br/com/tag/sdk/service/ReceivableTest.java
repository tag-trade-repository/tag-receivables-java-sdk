package br.com.tag.sdk.service;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.BankAccount;
import br.com.tag.sdk.model.enums.AccountBankAccountType;
import br.com.tag.sdk.model.enums.DocumentType;
import br.com.tag.sdk.model.receivable.register.Receivable;
import br.com.tag.sdk.model.receivable.register.ReceivableRequest;
import br.com.tag.sdk.model.receivable.register.ReceivableSettlement;
import br.com.tag.sdk.service.reicevable.register.IReceivableService;
import br.com.tag.sdk.service.reicevable.register.ReceivableService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Disabled
public class ReceivableTest extends BaseTest {

    private IReceivableService tService = null;

    @BeforeAll
    @Override
    public void setup() throws IOException, TagSDKException {
        super.setup();
        tService = new ReceivableService(this.options);
    }

    @Test
    void insertReceivableTest() throws TagSDKException, ParseException {

        BankAccount bAccount = new BankAccount(
                "4322",
                "00211",
                "X4",
                AccountBankAccountType.CC,
                "34100000",
                DocumentType.CPF,
                "34144310000100");

        ReceivableSettlement settlement = new ReceivableSettlement(
                "L_1875",
                DocumentType.CPF,
                "34144310000100",
                formatter.parse("2020-02-02"),
                formatter.parse("2021-11-01"),
                BigDecimal.valueOf(100.00),
                bAccount
        );

        List<ReceivableSettlement> settlements = new ArrayList<>();
        settlements.add(settlement);

        Receivable receivable = new Receivable(
                "UR_450",
                Date.from(Instant.now().plusSeconds(86400)),
                DocumentType.CPF,
                "34144310000100",
                "VCC",
                BigDecimal.valueOf(50000.00),
                BigDecimal.valueOf(0),
                bAccount,
                settlements);

        List<Receivable> receivables = new ArrayList<>();
        receivables.add(receivable);

        String processReference = "PR_550";
        ReceivableRequest rI = new ReceivableRequest(processReference, receivables);

        print(this.tService.registerReceivable(rI));
    }

}