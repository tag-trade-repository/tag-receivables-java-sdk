package br.com.tag.sdk.pipeline;

import br.com.tag.sdk.exceptions.TagSDKException;

public abstract class Filter<TIn, TOut> implements IFilter<TIn, TOut> {

    private IFilter<TIn, TOut> next;

    @Override
    public void register(IFilter<TIn, TOut> filter) {
        if (next == null) {
            next = filter;
        } else {
            next.register(filter);
        }
    }

    public abstract TOut execute(TIn context, Step step) throws TagSDKException;

    @Override
    public TOut execute(TIn context) throws TagSDKException {
        return execute(context, step -> {
            return next == null ? null : this.next.execute(context);
        });
    }

}
