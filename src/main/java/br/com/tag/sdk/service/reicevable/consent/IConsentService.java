package br.com.tag.sdk.service.reicevable.consent;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.enums.Profile;
import br.com.tag.sdk.model.receivable.consent.*;
import br.com.tag.sdk.model.response.BaseResponse;
import br.com.tag.sdk.service.IService;

public interface IConsentService extends IService {

    ConsentResponse insertConsents(ConsentRequest consentRequest, Profile profile) throws TagSDKException;
    BaseResponse rejectOptIn(ConsentRejectRequest optInRejInput, Profile profile) throws TagSDKException;
    BaseResponse patchOptOut(String key) throws TagSDKException;
    BaseResponse changeOptInValidityDate(String key, ConsentValidityChangeRequest optInVChange, Profile profile) throws TagSDKException;
    ConsentQueryResponse getOptInWithKey(String key) throws TagSDKException;
    ConsentQueryParameterizedResponse getOptInWithParams(ConsentQueryFilter consentQueryFilter) throws TagSDKException;

}
