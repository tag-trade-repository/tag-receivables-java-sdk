package br.com.tag.sdk.service.reicevable.settlement;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.receivable.settlement.*;
import br.com.tag.sdk.model.request.Pagination;
import br.com.tag.sdk.model.response.BaseResponse;
import br.com.tag.sdk.service.IService;

public interface ISettlementService extends IService {

    SettlementResponse reportSettlement(SettlementRequest receivableSettlementInput) throws TagSDKException;
    BaseResponse rejectSettlement(SettlementRejectRequest receivableSettlementInput) throws TagSDKException;
    SettlementQueryResponse getSettlementByKey(String value) throws TagSDKException;
    SettlementPaginatedQueryResponse getSettlementByProcessKey(String processKey, Pagination pagination) throws TagSDKException;
    SettlementPaginatedQueryResponse getSettlementByReference(String reference, Pagination pagination) throws TagSDKException;
    SettlementPaginatedQueryResponse getSettlementWithParams(SettlementQueryFilter inputs, Pagination pagination) throws TagSDKException;

}
