package br.com.tag.sdk.service;

import br.com.tag.sdk.SDKOptions;
import br.com.tag.sdk.TagSDK;
import br.com.tag.sdk.TagServiceCollection;
import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.authentication.TokenRequest;
import br.com.tag.sdk.model.enums.Profile;
import br.com.tag.sdk.model.request.HttpStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected TagServiceCollection fac = null;
    protected SDKOptions options = null;
    protected ObjectMapper objectMapper = new ObjectMapper();
    protected SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private Properties properties;

    public void setup() throws IOException, TagSDKException {
        loadProperties();
        initializeSDK();
    }

    private void loadProperties() throws IOException {
        properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("/application.properties"));
    }

    private void initializeSDK() {
        options = new SDKOptions(properties.getProperty("url"));
        options.setCredential(loadCredentials(Profile.CREDITOR), Profile.CREDITOR);
        options.setCredential(loadCredentials(Profile.ACQUIRER), Profile.ACQUIRER);
        fac = TagSDK.getServices(options);
    }

    private TokenRequest loadCredentials(Profile profile) {
        return new TokenRequest(
                properties.getProperty(String.format("auth.%s.clientID", profile.name().toLowerCase())),
                properties.getProperty(String.format("auth.%s.clientSecret", profile.name().toLowerCase())),
                properties.getProperty(String.format("auth.%s.audience", profile.name().toLowerCase())),
                properties.getProperty(String.format("auth.%s.grantType", profile.name().toLowerCase()))
        );
    }

    protected <T> void print(T object) throws TagSDKException {
        try {
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object));
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new TagSDKException(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    private int randomize(int n) {
        int randomNumber = (int) (Math.random() * n);
        return randomNumber;
    }

    private int mod(int dividend, int divider) {
        return (int) Math.round(dividend - (Math.floor(dividend / divider) * divider));
    }

    public String generateCNPJ(boolean withDots) {
        int n = 9;
        int n1 = randomize(n);
        int n2 = randomize(n);
        int n3 = randomize(n);
        int n4 = randomize(n);
        int n5 = randomize(n);
        int n6 = randomize(n);
        int n7 = randomize(n);
        int n8 = randomize(n);
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        int n12 = 1;
        int d1 = n12 * 2 + n11 * 3 + n10 * 4 + n9 * 5 + n8 * 6 + n7 * 7 + n6 * 8 + n5 * 9 + n4 * 2 + n3 * 3 + n2 * 4 + n1 * 5;

        d1 = 11 - (mod(d1, 11));

        if (d1 >= 10)
            d1 = 0;

        int d2 = d1 * 2 + n12 * 3 + n11 * 4 + n10 * 5 + n9 * 6 + n8 * 7 + n7 * 8 + n6 * 9 + n5 * 2 + n4 * 3 + n3 * 4 + n2 * 5 + n1 * 6;

        d2 = 11 - (mod(d2, 11));

        if (d2 >= 10)
            d2 = 0;

        String returnedCNPJ;

        if (withDots)
            returnedCNPJ = "" + n1 + n2 + "." + n3 + n4 + n5 + "." + n6 + n7 + n8 + "/" + n9 + n10 + n11 + n12 + "-" + d1 + d2;
        else
            returnedCNPJ = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + n10 + n11 + n12 + d1 + d2;

        return returnedCNPJ;
    }

}
