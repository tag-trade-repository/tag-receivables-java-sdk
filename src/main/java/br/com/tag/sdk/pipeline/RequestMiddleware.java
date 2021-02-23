package br.com.tag.sdk.pipeline;

import br.com.tag.sdk.SDKOptions;
import br.com.tag.sdk.commands.RequestCommand;
import br.com.tag.sdk.commands.ResponseCommand;
import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.http.HttpClient;
import br.com.tag.sdk.model.enums.Profile;
import br.com.tag.sdk.model.request.HttpStatus;
import br.com.tag.sdk.model.request.RequestOptions;
import br.com.tag.sdk.model.request.RestRequest;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;

import java.util.Set;
import java.util.concurrent.Callable;

public class RequestMiddleware<T, T2> extends Filter<RequestCommand<T>, ResponseCommand<T2>> {

    private final HttpClient restClient;
    private final Class<T2> returnClassType;
    protected SDKOptions options;

    public RequestMiddleware(HttpClient restClient, SDKOptions options, Class<T2> returnClassType) {
        this.options = options;
        this.restClient = restClient;
        this.returnClassType = returnClassType;
    }

    @Override
    public ResponseCommand<T2> execute(RequestCommand<T> context, Step step) throws TagSDKException {
        RestRequest<T> request = context.getRestRequest();
        Set<Profile> profiles = context.getProfile();

        RequestOptions<T> reqOptions = request.getRestRequest();

        Callable<T2> callable = Retry.decorateCallable(buildRetry(profiles), () -> {
            String token = this.updateToken(false, profiles);
            reqOptions.header("Authorization", "Bearer " + token);
            return restClient.doRequest(reqOptions, returnClassType);
        });

        try {
            T2 response = callable.call();

            ResponseCommand<T2> responseCommand = new ResponseCommand<>();

            responseCommand.setResponse(response);

            return responseCommand;
        } catch (Exception ex) {
            throw (TagSDKException) ex;
        }
    }

    private String updateToken(boolean refresh, Set<Profile> profiles) throws TagSDKException {
        Profile profile = profiles
                .stream()
                .filter(item -> options.getCredential(item) != null)
                .findAny()
                .orElseThrow(() -> new TagSDKException("Credenciais inválidas.", HttpStatus.UNAUTHORIZED));
        return this.options.getAuthorizer().getToken(refresh, profile);
    }

    private Retry buildRetry(Set<Profile> profiles) {
        RetryConfig config = RetryConfig
                .custom()
                .maxAttempts(1)
                .retryOnException(err -> err instanceof TagSDKException && ((TagSDKException) err).getStatus() == HttpStatus.UNAUTHORIZED)
                .build();
        RetryRegistry registry = RetryRegistry.of(config);
        Retry retry = registry.retry("UnauthorizedRetry");

        retry.getEventPublisher().onRetry(event -> {
            try {
                this.updateToken(true, profiles);
            } catch (TagSDKException e) {
                e.printStackTrace();
            }
        });
        return retry;
    }

}
