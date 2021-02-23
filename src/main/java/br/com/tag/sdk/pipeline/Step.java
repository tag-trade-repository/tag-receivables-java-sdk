package br.com.tag.sdk.pipeline;

import br.com.tag.sdk.exceptions.TagSDKException;

public interface Step<TIn, TOut> {

    TOut processNextStep(TIn context) throws TagSDKException;

}
