package br.com.tag.sdk.pipeline;

import java.util.ArrayList;
import java.util.List;

public class PipelineBuilder<T, TOut> {

    private final List<IFilter<T, TOut>> filters = new ArrayList<>();

    public PipelineBuilder<T, TOut> register(IFilter<T, TOut> filter) {
        this.filters.add(filter);
        return this;
    }

    public IFilter<T, TOut> build() {
        IFilter<T, TOut> root = this.filters.get(0);
        for (IFilter<T, TOut> filter : this.filters) {
            if (this.filters.indexOf(filter) != 0) {
                root.register(filter);
            }
        }
        return root;
    }

}
