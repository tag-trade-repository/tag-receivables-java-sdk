package br.com.tag.sdk.model.receivable.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Classe que encapsula unidades recebíveis que vão transacionar
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/transacoes-componentes-de-unidades-de-recebiveis">Transações Componentes de Unidades de Recebíveis</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/retificacao-das-transacoes-de-unidades-de-recebiveis">Retificação das Transações de Unidades de Recebíveis</a>
 */
public class TransactionReceivable {

    @JsonProperty("key")
    private String key;

    @JsonProperty("transactions")
    private List<Transaction> transactions;

    public TransactionReceivable(String key, List<Transaction> transactions) {
        this.key = key;
        this.transactions = transactions;
    }

    public TransactionReceivable() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}
