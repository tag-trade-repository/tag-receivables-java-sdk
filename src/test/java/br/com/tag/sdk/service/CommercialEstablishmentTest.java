package br.com.tag.sdk.service;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.BankAccount;
import br.com.tag.sdk.model.customer.CommercialEstablishment;
import br.com.tag.sdk.model.customer.CommercialEstablishmentRequest;
import br.com.tag.sdk.model.customer.CommercialEstablishmentUpdateInput;
import br.com.tag.sdk.model.customer.CommercialEstablishmentUpdateRequest;
import br.com.tag.sdk.model.enums.AccountBankAccountType;
import br.com.tag.sdk.model.enums.DocumentType;
import br.com.tag.sdk.model.request.Pagination;
import br.com.tag.sdk.service.customer.ICommercialEstablishmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Disabled
public class CommercialEstablishmentTest extends BaseTest {

    private ICommercialEstablishmentService comEstabService = null;

    @BeforeAll
    @Override
    public void setup() throws IOException, TagSDKException {
        super.setup();
        comEstabService = this.fac.getCommercialEstablishmentService();
    }

    @Test
    void insertCommercialEstablishmentTest() throws TagSDKException, IOException {
        List<String> paymentSchemes = new ArrayList<>();
        paymentSchemes.add("VCC");
        paymentSchemes.add("MCC");

        String cnpj = generateCNPJ(false);

        BankAccount bankAccount = new BankAccount(
                "1144",
                "13341",
                "X5",
                AccountBankAccountType.CC,
                "12345678", DocumentType.CNPJ,
                cnpj);

        CommercialEstablishment cmEstab = new CommercialEstablishment();
        cmEstab.setDocumentType(DocumentType.CNPJ);
        cmEstab.setDocumentNumber(cnpj);
        cmEstab.setPaymentSchemes(paymentSchemes);
        cmEstab.setBankAccount(bankAccount);

        List<CommercialEstablishment> commercialEstablishments = new ArrayList<>();
        commercialEstablishments.add(cmEstab);

        CommercialEstablishmentRequest cmEstabReq = new CommercialEstablishmentRequest();
        cmEstabReq.setCommercialEstablishments(commercialEstablishments);


        print(this.comEstabService.registerCommercialEstablishments(cmEstabReq));
    }

    @Test
    @Disabled
    void updateCommercialEstablishmentTest() throws TagSDKException, JsonProcessingException {
        List<String> paymentSchemes = new ArrayList<>();
        paymentSchemes.add("VCC");

        String cnpj = "77551254000122";

        BankAccount bankAccount = new BankAccount(
                "1144",
                "13341",
                "X5",
                AccountBankAccountType.CC,
                "12345678", DocumentType.CNPJ,
                cnpj);

        CommercialEstablishmentUpdateInput cmEstab = new CommercialEstablishmentUpdateInput();
        cmEstab.setPaymentSchemes(paymentSchemes);
        cmEstab.setBankAccount(bankAccount);
        cmEstab.setEnabled(false);

        CommercialEstablishmentUpdateRequest cmEstabReq = new CommercialEstablishmentUpdateRequest();
        cmEstabReq.setCommercialEstablishment(cmEstab);

        String json = objectMapper.writeValueAsString(cmEstabReq);

        print(this.comEstabService.updateCommercialEstablishments(cnpj, cmEstabReq));
    }

    @Test
    void listCommercialEstablishmentWithPaginationTest() throws TagSDKException {
        Pagination pag = new Pagination(1, 2);
        print(this.comEstabService.getCommercialEstablishmentsWithPagination(pag));
    }

    @Test
    void listCommercialEstablishmentWithDocumentNumberTest() throws TagSDKException {
        print(this.comEstabService.getCommercialEstablishmentsWithDocumentNumber("62661584000101"));
    }

}
