package br.com.tag.sdk.model.receivable.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Classe de dados para a inserção/retificação de unidades recebíveis que transacionaram
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/transacoes-componentes-de-unidades-de-recebiveis">Transações Componentes de Unidades de Recebíveis</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/retificacao-das-transacoes-de-unidades-de-recebiveis">Retificação das Transações de Unidades de Recebíveis</a>
 */
public class TransactionRequest {

    @JsonProperty("receivables")
    private List<TransactionReceivable> receivables;

    public TransactionRequest(List<TransactionReceivable> receivables) {
        this.receivables = receivables;
    }

    public TransactionRequest() {
    }

    public List<TransactionReceivable> getReceivables() {
        return receivables;
    }

    public void setReceivables(List<TransactionReceivable> receivables) {
        this.receivables = receivables;
    }

}
