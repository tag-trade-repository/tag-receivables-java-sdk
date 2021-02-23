package br.com.tag.sdk.model.receivable.transaction;

import br.com.tag.sdk.model.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * Classe de resposta para consulta de transações de unidades recebíveis
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="Consulta de Transações de Unidades de Recebíveis">Consulta de Transações de Unidades de Recebíveis</a>
 */
public class TransactionQueryResponse extends BaseResponse {

    @JsonProperty("key")
    private String key;

    @JsonProperty("transactions")
    private List<Transaction> receivableTransactionItems = new ArrayList<>();

    public TransactionQueryResponse(String key, List<Transaction> receivableTransactionItems, String processKey, Date createdAt) {
        super(processKey, createdAt);
        this.key = key;
        this.receivableTransactionItems = receivableTransactionItems;
    }

    public TransactionQueryResponse() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Transaction> getTransactions() {
        return receivableTransactionItems;
    }

    public void setTransactions(List<Transaction> receivableTransactionItems) {
        this.receivableTransactionItems = receivableTransactionItems;
    }

}
