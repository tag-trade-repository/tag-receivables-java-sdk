package br.com.tag.sdk.factories;

import br.com.tag.sdk.SDKOptions;
import br.com.tag.sdk.commands.RequestCommand;
import br.com.tag.sdk.commands.ResponseCommand;
import br.com.tag.sdk.pipeline.IFilter;
import br.com.tag.sdk.pipeline.LogMiddleware;
import br.com.tag.sdk.pipeline.PipelineBuilder;
import br.com.tag.sdk.pipeline.RequestMiddleware;

/***
 * Fábrica concreta para devolução de Pipelines
 * @author 7Comm
 * @version 1.0.0
 */
public class PipelineFactory<TIn, TOut> {

    public IFilter<RequestCommand<TIn>, ResponseCommand<TOut>> getPipeline(SDKOptions options, Class<TOut> classType) {
        return new PipelineBuilder<RequestCommand<TIn>, ResponseCommand<TOut>>()
                .register(new LogMiddleware<>())
                .register(new RequestMiddleware<>(options.getWebClient(), options, classType))
                .build();
    }

}
