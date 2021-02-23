package br.com.tag.sdk.factories;

import br.com.tag.sdk.commands.RequestCommand;
import br.com.tag.sdk.commands.ResponseCommand;
import br.com.tag.sdk.pipeline.IFilter;

/***
 * Fábrica abstrata para devolução de Pipelines
 * @author 7Comm
 * @version 1.0.0
 */
public interface IPipelineFactory<TIn, TOut> {
    IFilter<RequestCommand<TIn>, ResponseCommand<TOut>> getPipeline();
}