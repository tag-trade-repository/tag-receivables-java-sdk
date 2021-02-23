package br.com.tag.sdk.model.receivable.transaction;

import br.com.tag.sdk.utils.DecimalDeserializer;
import br.com.tag.sdk.utils.DecimalSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.util.Date;

/***
 * Classe base para transação de unidades recebíveis
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-transacoes-de-unidades-de-recebiveis">Consulta de Transações de Unidades de Recebíveis</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/transacoes-componentes-de-unidades-de-recebiveis">Transações Componentes de Unidades de Recebíveis</a>
 */
public class Transaction {

    @JsonProperty("identifier")
    private String identifier;

    @JsonProperty("transactionDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date transactionDate;

    @JsonProperty("amount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal amount;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("dueDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    public Transaction(String identifier,
                       Date transactionDate,
                       BigDecimal amount,
                       Date dueDate,
                       String reference) {
        this.identifier = identifier;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.dueDate = dueDate;
        this.reference = reference;
    }

    public Transaction() {
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
