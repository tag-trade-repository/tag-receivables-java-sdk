package br.com.tag.sdk.service;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.enums.DocumentType;
import br.com.tag.sdk.model.receivable.advancement.AdvancedReceivable;
import br.com.tag.sdk.model.receivable.advancement.Advancement;
import br.com.tag.sdk.model.receivable.advancement.AdvancementRequest;
import br.com.tag.sdk.model.response.BaseResponse;
import br.com.tag.sdk.service.reicevable.advancement.IAdvancementService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Disabled
class AdvancementTest extends BaseTest {

    private IAdvancementService adService = null;

    @BeforeAll
    @Override
    public void setup() throws IOException, TagSDKException {
        super.setup();
        adService = this.fac.getAdvancementService();
    }

    @Test
    void insertAdvancementVanillaTest() throws TagSDKException, JsonProcessingException {

        AdvancedReceivable adReceivable = new AdvancedReceivable();
        adReceivable.setAdvancedAmount(BigDecimal.valueOf(100).setScale(2));
        adReceivable.setPaymentScheme("VCC");
        adReceivable.setSettlementObligationDate(Date.from(Instant.now()));

        List<AdvancedReceivable> adReceivables = new ArrayList<>();
        adReceivables.add(adReceivable);

        Advancement adItem = new Advancement();
        adItem.setAssetHolderDocumentType(DocumentType.CNPJ);
        adItem.setAssetHolder("74190072000185");
        adItem.setOperationValue(BigDecimal.valueOf(200).setScale(2));
        adItem.setOperationExpectedSettlementDate(Date.from(Instant.now()));
        adItem.setReference("RF_01");
        adItem.setAdvancedReceivables(adReceivables);

        List<Advancement> adItems = new ArrayList<>();
        adItems.add(adItem);

        AdvancementRequest adInput = new AdvancementRequest();
        adInput.setAdvancements(adItems);

        String item = objectMapper.writeValueAsString(adInput);

        BaseResponse resp = this.adService.insertAdvancements(adInput);

        print(resp);

        assertNotNull(resp);
    }

}