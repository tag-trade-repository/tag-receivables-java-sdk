package br.com.tag.sdk.service.reicevable.advancement;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.receivable.advancement.AdvancementRequest;
import br.com.tag.sdk.model.response.BaseResponse;
import br.com.tag.sdk.service.IService;

public interface IAdvancementService extends IService {
    BaseResponse insertAdvancements(AdvancementRequest advInput) throws TagSDKException;
}
