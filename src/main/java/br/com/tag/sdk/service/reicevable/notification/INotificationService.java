package br.com.tag.sdk.service.reicevable.notification;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.enums.Profile;
import br.com.tag.sdk.model.receivable.notification.*;
import br.com.tag.sdk.service.IService;

import java.util.Date;
import java.util.List;

public interface INotificationService extends IService {

    List<NotificationDefaultResponse<NotificationSettlement>> getSettlementNotification(Date date, Profile profile) throws TagSDKException;
    List<NotificationDefaultResponse<NotificationSettlementReject>> getSettlementRejectNotification(Date date, Profile profile) throws TagSDKException;
    List<NotificationDefaultResponse<NotificationAdvancement>> getAdvancementNotification(Date date, Profile profile) throws TagSDKException;
    List<NotificationDefaultResponse<NotificationContract>> getContractNotification(Date date, Profile profile) throws TagSDKException;
    List<NotificationDefaultResponse<NotificationConsentWrapper>> getConsentNotification(Date date, Profile profile) throws TagSDKException;
    List<NotificationDefaultResponse<NotificationContract>> getNotificationProcessKey(String pkey, Profile profile) throws TagSDKException;
    List<NotificationDefaultResponse<NotificationContract>> getNotificationKey(String key, Profile profile) throws TagSDKException;

}
