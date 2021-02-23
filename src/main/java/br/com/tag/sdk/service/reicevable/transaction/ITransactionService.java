package br.com.tag.sdk.service.reicevable.transaction;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.receivable.transaction.TransactionQueryResponse;
import br.com.tag.sdk.model.receivable.transaction.TransactionRequest;
import br.com.tag.sdk.model.response.BaseResponse;
import br.com.tag.sdk.service.IService;

public interface ITransactionService extends IService {

    TransactionQueryResponse getTransaction(String key) throws TagSDKException;
    BaseResponse createTransactedUnitsReceivables(TransactionRequest transactionUnits) throws TagSDKException;
    BaseResponse rectifyTransactedUnitsReceivables(TransactionRequest transactionUnits) throws TagSDKException;

}
