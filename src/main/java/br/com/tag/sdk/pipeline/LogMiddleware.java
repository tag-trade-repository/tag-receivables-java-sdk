package br.com.tag.sdk.pipeline;

import br.com.tag.sdk.commands.RequestCommand;
import br.com.tag.sdk.commands.ResponseCommand;
import br.com.tag.sdk.exceptions.TagSDKException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogMiddleware<T, T2> extends Filter<RequestCommand<T>, ResponseCommand<T2>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogMiddleware.class);

    @Override
    public ResponseCommand<T2> execute(RequestCommand<T> context, Step step) throws TagSDKException {
        LOGGER.info("INICIANDO REQUEST");
        return (ResponseCommand<T2>) step.processNextStep(context);
    }

}
