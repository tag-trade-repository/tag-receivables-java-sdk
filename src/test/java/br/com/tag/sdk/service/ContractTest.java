package br.com.tag.sdk.service;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.BankAccount;
import br.com.tag.sdk.model.enums.*;
import br.com.tag.sdk.model.receivable.contract.*;
import br.com.tag.sdk.model.request.Pagination;
import br.com.tag.sdk.service.reicevable.contract.ContractService;
import br.com.tag.sdk.service.reicevable.contract.IContractService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Disabled
class ContractTest extends BaseTest {

    private IContractService cService = null;

    @BeforeAll
    @Override
    public void setup() throws IOException, TagSDKException {
        super.setup();
        cService = new ContractService(this.options);
    }

    @Test
    void insertContract() throws IOException, TagSDKException {

        BankAccount bankAccount = new BankAccount(
                "1144",
                "13341",
                "X5",
                AccountBankAccountType.CC,
                "12345678", DocumentType.CNPJ,
                "39624514000153");

        ContractSpecification ctEspecification = new ContractSpecification();
        ctEspecification.setExpectedSettlementDate(Date.from(Instant.now()));
        ctEspecification.setOriginalAssetHolderDocumentType(DocumentType.CNPJ);
        ctEspecification.setOriginalAssetHolder("39624514000153");
        ctEspecification.setReceivableDebtor("74190072000185");
        ctEspecification.setPaymentScheme("VCC");
        ctEspecification.setEffectValue(BigDecimal.valueOf(5).setScale(2));

        List<ContractSpecification> ctEspecifications = new ArrayList<>();
        ctEspecifications.add(ctEspecification);

        Contract ctItem = new Contract();
        ctItem.setReference("CT_01");
        ctItem.setContractDueDate(Date.from(Instant.now()));
        ctItem.setAssetHolderDocumentType(DocumentType.CNPJ);
        ctItem.setAssetHolder("39624514000153");
        ctItem.setContractUniqueIdentifier("CT_01");
        ctItem.setSignatureDate(Date.from(Instant.now()));
        ctItem.setEffectType(EffectType.WARRANTY);
        ctItem.setWarrantyType(WarrantyType.FIDUCIARY);
        ctItem.setWarrantyAmount(BigDecimal.valueOf(100).setScale(2));
        ctItem.setBalanceDue(BigDecimal.valueOf(100).setScale(2));
        ctItem.setDivisionMethod(DivisionMethodType.FIXED_AMOUNT);
        ctItem.setEffectStrategy(EffectStrategy.SPECIFIC);
        ctItem.setPercentageValue(BigDecimal.valueOf(10));
        ctItem.setBankAccount(bankAccount);
        ctItem.setContractSpecifications(ctEspecifications);

        List<Contract> ctItems = new ArrayList<>();
        ctItems.add(ctItem);

        ContractRequest contractInput = new ContractRequest();
        contractInput.setContracts(ctItems);

        String jsonRequest = objectMapper.writeValueAsString(contractInput);

        ContractRequest des = objectMapper.readValue(jsonRequest, ContractRequest.class);

        String jsonRequest2 = objectMapper.writeValueAsString(des);

        print(this.cService.insertContract(contractInput));
    }

    @Test
    void listContractsByReference() throws TagSDKException, IOException {

        Pagination page = new Pagination(1,10);

        ContractPaginatedQueryResponse result = cService.listContractsByReference("CT_01", page);

        print(result);

        assertNotNull(result);
    }

    @Test
    void listContractsByKey() throws TagSDKException, IOException {

        ContractPaginatedQueryResponse result = cService.listContractsByKey("dda6c698-705d-49b5-a84c-c0a2d605b77c");

        print(result);

        assertNotNull(result);
    }

    @Test
    void listContractsByProcessKey() throws TagSDKException, IOException {

        Pagination page = new Pagination(1,10);

        ContractPaginatedQueryResponse result = cService.listContractsByProcessKey("7c4f2552-4dcf-4320-a460-8fd6fd8ff09b", page);

        print(result);

        assertNotNull(result);
    }

    @Test
    void listContractsWithParams() throws TagSDKException, IOException, ParseException {

        ContractQueryFilter cInput = new ContractQueryFilter();
        cInput.setStartContractDueDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01"));
        cInput.setEndContractDueDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-31"));
        cInput.setAssetHolder("61821451000184");

        Pagination page = new Pagination();

        page.setPage(1);
        page.setLimit(10);

        ContractPaginatedQueryResponse result = cService.listContractsWithParams(cInput, page);

        print(result);

        assertNotNull(result);
    }

    @Test
    @Disabled
    void getContractHistoryTest() throws TagSDKException, IOException {
        print(cService.getContractHistoryWithKey("dda6c698-705d-49b5-a84c-c0a2d605b77c"));
    }

}
