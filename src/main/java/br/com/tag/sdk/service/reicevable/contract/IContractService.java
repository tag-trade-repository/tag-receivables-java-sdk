package br.com.tag.sdk.service.reicevable.contract;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.receivable.contract.*;
import br.com.tag.sdk.model.request.Pagination;
import br.com.tag.sdk.service.IService;

public interface IContractService extends IService {
    ContractResponse insertContract(ContractRequest ctInput) throws TagSDKException;
    ContractPaginatedQueryResponse listContractsByReference(String reference, Pagination page) throws TagSDKException;
    ContractPaginatedQueryResponse listContractsByKey(String key) throws TagSDKException;
    ContractPaginatedQueryResponse listContractsByProcessKey(String processKey, Pagination page) throws TagSDKException;
    ContractPaginatedQueryResponse listContractsWithParams(ContractQueryFilter queryParams, Pagination page) throws TagSDKException;
    ContractHistoryResponse getContractHistoryWithKey(String key) throws TagSDKException;
}
