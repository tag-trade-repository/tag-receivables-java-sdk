package br.com.tag.sdk.service;

import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.model.receivable.transaction.Transaction;
import br.com.tag.sdk.model.receivable.transaction.TransactionQueryResponse;
import br.com.tag.sdk.model.receivable.transaction.TransactionReceivable;
import br.com.tag.sdk.model.receivable.transaction.TransactionRequest;
import br.com.tag.sdk.model.response.BaseResponse;
import br.com.tag.sdk.service.reicevable.transaction.ITransactionService;
import br.com.tag.sdk.service.reicevable.transaction.TransactionService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Disabled
class TransactionTest extends BaseTest {

    private ITransactionService srv = null;

    @BeforeAll
    @Override
    public void setup() throws IOException, TagSDKException {
        super.setup();
        srv = new TransactionService(this.options);
    }

    @Test
    void createTransactedUnitsReceivables() throws TagSDKException, ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Transaction item = new Transaction();
        item.setIdentifier("0125048520200513");
        item.setTransactionDate(parser.parse("2022-05-15"));
        item.setAmount(BigDecimal.valueOf(5000).setScale(2, 0));
        item.setReference("TR-488");
        item.setDueDate(parser.parse("2020-06-15"));

        ArrayList<Transaction> itemList = new ArrayList<>();
        itemList.add(item);

        TransactionReceivable inputItem = new TransactionReceivable();
        inputItem.setKey("e9773677dcf7c64e8d30ba551be3c436");
        inputItem.setTransactions(itemList);

        ArrayList<TransactionReceivable> inputItemList = new ArrayList<>();
        inputItemList.add(inputItem);

        TransactionRequest input = new TransactionRequest();
        input.setReceivables(inputItemList);

        BaseResponse result = srv.createTransactedUnitsReceivables(input);
        print(result);
        assertNotNull(result);
    }

    @Test
    @Disabled
    void getTransactionTest() throws TagSDKException {
        TransactionQueryResponse result = this.srv.getTransaction("0125048520200513");

        print(result);
        assertNotNull(result);
    }

    @Test
    void rectifyTransactedUnitsReceivables() throws TagSDKException, ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Transaction item = new Transaction();
        item.setIdentifier("0125048520200513");
        item.setTransactionDate(parser.parse("2022-05-15"));
        item.setAmount(BigDecimal.valueOf(5000).setScale(2, 0));
        item.setReference("TR-488");
        item.setDueDate(parser.parse("2020-06-15"));

        ArrayList<Transaction> itemList = new ArrayList<>();
        itemList.add(item);

        TransactionReceivable inputItem = new TransactionReceivable();
        inputItem.setKey("e9773677dcf7c64e8d30ba551be3c436");
        inputItem.setTransactions(itemList);

        ArrayList<TransactionReceivable> inputItemList = new ArrayList<>();
        inputItemList.add(inputItem);

        TransactionRequest input = new TransactionRequest();
        input.setReceivables(inputItemList);

        BaseResponse result = srv.rectifyTransactedUnitsReceivables(input);
        print(result);
        assertNotNull(result);
    }

}
