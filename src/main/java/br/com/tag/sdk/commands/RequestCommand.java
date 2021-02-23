package br.com.tag.sdk.commands;

import br.com.tag.sdk.model.enums.Profile;
import br.com.tag.sdk.model.request.RestRequest;

import java.util.HashSet;
import java.util.Set;

/***
 * Classe de comando para dar semantica e encapsular as requisições para chamadas de API
 * @author 7Comm
 * @version 1.0.0
 */
public class RequestCommand<TModel> {

    private RestRequest<TModel> restRequest;
    private final Set<Profile> profile;
    private TModel model = null;

    public RequestCommand(
            RestRequest<TModel> restRequest,
            Profile profile
    ) {
        this.profile = new HashSet<>();
        this.profile.add(profile);
        this.restRequest = restRequest;
    }

    public RequestCommand(
            RestRequest<TModel> restRequest,
            Set<Profile> profile
    ) {
        this.profile = profile;
        this.restRequest = restRequest;
    }

    public RestRequest<TModel> getRestRequest() {
        return restRequest;
    }

    public void setRestRequest(RestRequest<TModel> restRequest) {
        this.restRequest = restRequest;
    }

    public TModel getModel() {
        return model;
    }

    public void setModel(TModel model) {
        this.model = model;
    }

    public Profile getProfile(Profile prof) {
        return profile.stream().filter(prof::equals).findAny().orElse(null);
    }

    public Set<Profile> getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile.add(profile);
    }
}
