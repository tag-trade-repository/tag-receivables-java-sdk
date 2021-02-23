package br.com.tag.sdk.pipeline;

import br.com.tag.sdk.exceptions.TagSDKException;

public interface IFilter<TIn, TOut> {

    void register(IFilter<TIn, TOut> filter);

    TOut execute(TIn context) throws TagSDKException;

}
