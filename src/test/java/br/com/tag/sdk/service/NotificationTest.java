package br.com.tag.sdk.service;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.enums.Profile;
import br.com.tag.sdk.model.receivable.notification.*;
import br.com.tag.sdk.service.reicevable.notification.INotificationService;
import br.com.tag.sdk.service.reicevable.notification.NotificationService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Disabled
public class NotificationTest extends BaseTest {

    private INotificationService nS = null;
    private final Profile profile = Profile.CREDITOR;

    @BeforeAll
    @Override
    public void setup() throws IOException, TagSDKException {
        super.setup();
        nS = new NotificationService(this.options);
    }

    @Test
    void ListNotificationSettlementTest() throws ParseException, TagSDKException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-10");
        List<NotificationDefaultResponse<NotificationSettlement>> items = this.nS.getSettlementNotification(date, profile);
        print(items);
    }

    @Test
    void ListNotificationSettlementRejectTest() throws ParseException, TagSDKException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-10");
        List<NotificationDefaultResponse<NotificationSettlementReject>> items = this.nS.getSettlementRejectNotification(date, profile);
        print(items);
    }

    @Test
    @Disabled
    void ListNotificationAdvancementTest() throws ParseException, TagSDKException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01");
        List<NotificationDefaultResponse<NotificationAdvancement>> items = this.nS.getAdvancementNotification(date, profile);
        print(items);
    }

    @Test
    void ListContractNotificationTest() throws ParseException, TagSDKException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-09");
        List<NotificationDefaultResponse<NotificationContract>> items = this.nS.getContractNotification(date, profile);
        print(items);
    }

    @Test
    void ListNotificationConsentTest() throws ParseException, TagSDKException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-10");
        List<NotificationDefaultResponse<NotificationConsentWrapper>> items = this.nS.getConsentNotification(date, profile);
        print(items);
    }

    @Test
    void ListNotificationProcessKeyTest() throws TagSDKException {
        print(this.nS.getNotificationKey("2c76b0f6-513a-4c07-a17a-d37b9b6484f9", profile));
    }

    @Test
    void ListNotificationKeyTest() throws TagSDKException {
        print(this.nS.getNotificationProcessKey("826392f6-d199-4e2c-b557-f4ae3fb871b3", profile));
    }

}
