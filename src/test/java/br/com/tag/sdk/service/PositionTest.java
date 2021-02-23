package br.com.tag.sdk.service;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.receivable.position.PositionQueryFilter;
import br.com.tag.sdk.service.reicevable.position.IPositionService;
import br.com.tag.sdk.service.reicevable.position.PositionService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Disabled
public class PositionTest extends BaseTest {

    private IPositionService agService = null;

    @BeforeAll
    @Override
    public void setup() throws IOException, TagSDKException {
        super.setup();
        agService = new PositionService(this.options);
    }

    @Test
    public void AgendaPositionWithKeyTest() throws TagSDKException {
        print(this.agService.getPositionsWithKey("48ad40ab594434f916e497da745efa0c"));
    }

    @Test
    public void AgendaPositionWithReferenceTest() throws TagSDKException {
        print(this.agService.getPositionsWithReference("UR_450"));
    }

    @Test
    public void AgendaPositionWithProcessReferenceTest() throws TagSDKException {
        print(this.agService.getPositionsWithProcessReference("PR_550"));
    }

    @Test
    public void AgendaPositionWithOriginalAssetHolder() throws TagSDKException, ParseException {
        PositionQueryFilter params = new PositionQueryFilter();
        params.setPaymentScheme("VCC");
        params.setInitialExpectedSettlementDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-01"));
        params.setFinalExpectedSettlementDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-31"));
        print(this.agService.getPositionsWithOriginalAssetHolder("61821451000184", params));
    }

    @Test
    public void AgendaPositionWithAssetHolder() throws TagSDKException, ParseException {
        PositionQueryFilter params = new PositionQueryFilter();
        params.setPaymentScheme("VCC");
        params.setInitialExpectedSettlementDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-01"));
        params.setFinalExpectedSettlementDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-31"));
        print(this.agService.getPositionsWithAssetHolder("61821451000184", params));
    }

}
