package br.com.tag.sdk.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RequestUtilsTest {

    @Test
    void dateParserTest() throws ParseException {

        String strDate = "2020-12-28";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(strDate);

        Assertions.assertEquals("2020-12-28", RequestUtils.dateParseAndFormat(date, "yyyy-MM-dd"));

        Assertions.assertEquals("28-12-2020", RequestUtils.dateParseAndFormat(date, "dd-MM-yyyy"));

        Assertions.assertEquals("28/12/2020", RequestUtils.dateParseAndFormat(date, "dd/MM/yyyy"));
    }

    @Test
    void queryParamTest() {

        Map<String, String> params = new HashMap<>();

        String url = RequestUtils.getQueryParams("", params);
        Assertions.assertEquals("", url);

        params.put("initialDate", "25-11-2020");

        url = RequestUtils.getQueryParams("", params);
        Assertions.assertEquals("?initialDate=25-11-2020", url);

        params.put("finalDate", "25-12-2020");
        params.put("key", "AAAA-BBBB-CCCC-DDDD");

        url = RequestUtils.getQueryParams("", params);

        Assertions.assertTrue(url.startsWith("?"));
        url = url.replace("?", "");

        List<String> paramsList = Arrays.asList(url.split("&").clone());

        Assertions.assertEquals(params.size(), paramsList.size());

        paramsList.forEach(prm -> {
            int breakIndex = prm.indexOf("=");
            String key = prm.substring(0, breakIndex);
            String value = prm.substring(breakIndex + 1);

            Assertions.assertTrue(params.containsKey(key));
            Assertions.assertEquals(params.get(key), value);
        });
    }

}
