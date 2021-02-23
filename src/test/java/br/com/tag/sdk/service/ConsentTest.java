package br.com.tag.sdk.service;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.enums.Profile;
import br.com.tag.sdk.model.receivable.consent.*;
import br.com.tag.sdk.service.reicevable.consent.ConsentService;
import br.com.tag.sdk.service.reicevable.consent.IConsentService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Disabled
public class ConsentTest extends BaseTest {

    private IConsentService cService = null;
    private final Profile profile = Profile.ACQUIRER;

    @BeforeAll
    @Override
    public void setup() throws IOException, TagSDKException {
        super.setup();
        cService = new ConsentService(this.options);
    }

    @Test
    public void insertOptInsTest() throws TagSDKException {
        List<Consent> optIns = new ArrayList<>();

        Consent optIn = new Consent();
        optIn.setBeneficiary("63878277000131");
        optIn.setPaymentScheme("VCC");
        optIn.setAcquirer("58094131000165");
        optIn.setAssetHolder("86501627000141");
        optIn.setSignatureDate(Date.from(Instant.now()));
        optIn.setStartDate(Date.from(Instant.now()));
        optIn.setEndDate(Date.from(Instant.now()));

        optIns.add(optIn);

        ConsentRequest consentRequest = new ConsentRequest();
        consentRequest.setOptIns(optIns);

        print(cService.insertConsents(consentRequest, profile));
    }

    @Test
    public void rejectOptInsTest() throws TagSDKException {

        List<ConsentReject> optIns = new ArrayList<>();

        ConsentRejectRequest optRejInput = new ConsentRejectRequest();

        ConsentReject optRejItem = new ConsentReject();
        optRejItem.setReason("carlão");
        optRejItem.setKey("4e00e0e0-74e0-4997-8f01-e3f546d1e791");

        optIns.add(optRejItem);

        optRejInput.setOptIns(optIns);

        print(cService.rejectOptIn(optRejInput, profile));
    }

    @Test
    public void patchOptOutTest() throws TagSDKException {
        print(cService.patchOptOut("98487a34-cf87-4f78-8f85-eebf50354c6b"));
    }

    @Test
    public void optInChangeValidity() throws TagSDKException, ParseException {
        ConsentValidityChangeRequest optInVChangeInput = new ConsentValidityChangeRequest();
        optInVChangeInput.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-16"));
        optInVChangeInput.setEndDate(Date.from(Instant.now()));
        print(cService.changeOptInValidityDate("98487a34-cf87-4f78-8f85-eebf50354c6b", optInVChangeInput, profile));
    }

    @Test
    public void getOptInWithKey() throws TagSDKException {
        print(cService.getOptInWithKey("98487a34-cf87-4f78-8f85-eebf50354c6b"));
    }

    @Test
    public void getOptInWithParams() throws TagSDKException, ParseException {
        ConsentQueryFilter consentQueryFilter = new ConsentQueryFilter();
        consentQueryFilter.setAcquirer("58094131000165");
        consentQueryFilter.setBeneficiary("63878277000131");
        consentQueryFilter.setPaymentScheme("VCC");
        consentQueryFilter.setInitialDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-17"));
        consentQueryFilter.setFinalDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-17"));
        consentQueryFilter.setAssetHolder("86501627000141");

        print(cService.getOptInWithParams(consentQueryFilter));
    }

}
