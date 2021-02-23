package br.com.tag.sdk.service.customer;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.customer.CommercialEstablishmentPaginatedQueryResponse;
import br.com.tag.sdk.model.customer.CommercialEstablishmentRequest;
import br.com.tag.sdk.model.customer.CommercialEstablishmentResponse;
import br.com.tag.sdk.model.customer.CommercialEstablishmentUpdateRequest;
import br.com.tag.sdk.model.request.Pagination;
import br.com.tag.sdk.model.response.BaseResponse;
import br.com.tag.sdk.service.IService;

public interface ICommercialEstablishmentService extends IService {

    CommercialEstablishmentResponse registerCommercialEstablishments(CommercialEstablishmentRequest cEstablishmentReq) throws TagSDKException;
    BaseResponse updateCommercialEstablishments(String docNumber, CommercialEstablishmentUpdateRequest cEstablishmentReq) throws TagSDKException;
    CommercialEstablishmentPaginatedQueryResponse getCommercialEstablishmentsWithPagination(Pagination pagination) throws TagSDKException;
    CommercialEstablishmentResponse getCommercialEstablishmentsWithDocumentNumber(String documentNumber) throws TagSDKException;

}
