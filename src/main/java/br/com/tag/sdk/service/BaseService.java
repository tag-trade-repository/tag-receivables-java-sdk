package br.com.tag.sdk.service;

import br.com.tag.sdk.SDKOptions;
import br.com.tag.sdk.commands.RequestCommand;
import br.com.tag.sdk.commands.ResponseCommand;
import br.com.tag.sdk.factories.PipelineFactory;
import br.com.tag.sdk.model.enums.Profile;
import br.com.tag.sdk.pipeline.IFilter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/***
 * @author 7Comm
 * @version 1.0.0
 */
public abstract class BaseService {

    private SDKOptions options;
    protected Set<Profile> profiles;

    public BaseService(SDKOptions options, Profile... profiles) {
        this.options = options;
        this.profiles = new HashSet<>();
        Arrays.stream(profiles).iterator().forEachRemaining(item -> this.profiles.add(item));
    }

    public SDKOptions getOptions() {
        return options;
    }

    public void setOptions(SDKOptions options) {
        this.options = options;
    }

    public <TIn, TOut> IFilter<RequestCommand<TIn>, ResponseCommand<TOut>> getPipeline(Class<TOut> returnClassType) {
        return new PipelineFactory<TIn, TOut>().getPipeline(this.options, returnClassType);
    }

}
