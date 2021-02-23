package br.com.tag.sdk.http;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;

public class ResponseInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        ResponseBody body = response.body();
        String bodyString = body.string();

        MediaType contentType = body.contentType();

        if(bodyString.equals("")) {
            return response.newBuilder().body(ResponseBody.create("{}", contentType)).build();
        }

        return response.newBuilder().body(ResponseBody.create(bodyString, contentType)).build();
    }
}
