package br.com.tag.sdk.service.reicevable.register;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.receivable.register.ReceivableRequest;
import br.com.tag.sdk.model.receivable.register.ReceivableResponse;
import br.com.tag.sdk.service.IService;

public interface IReceivableService extends IService {

    ReceivableResponse registerReceivable(ReceivableRequest receivableInput) throws TagSDKException;

}
