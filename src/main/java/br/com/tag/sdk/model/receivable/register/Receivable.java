package br.com.tag.sdk.model.receivable.register;

import br.com.tag.sdk.model.BankAccount;
import br.com.tag.sdk.model.enums.DocumentType;
import br.com.tag.sdk.utils.DecimalDeserializer;
import br.com.tag.sdk.utils.DecimalSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/***
 * Classe que encapsula o Registro e Atualização de Ativos Financeiros
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/registro">Registro e Atualização de Ativos Financeiros</a>
 */
public class Receivable {

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("dueDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    @JsonProperty("originalAssetHolderDocumentType")
    private DocumentType originalAssetHolderDocumentType;

    @JsonProperty("originalAssetHolder")
    private String originalAssetHolder;

    @JsonProperty("paymentScheme")
    private String paymentScheme;

    @JsonProperty("amount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal amount;

    @JsonProperty("prePaidAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal prePaidAmount;

    @JsonProperty("bankAccount")
    private BankAccount bankAccount;

    @JsonProperty("settlements")
    private List<ReceivableSettlement> settlements;

    public Receivable(
            String reference,
            Date dueDate,
            DocumentType originalAssetHolderDocumentType,
            String originalAssetHolder,
            String paymentScheme,
            BigDecimal amount,
            BigDecimal prePaidAmount,
            BankAccount bankAccount,
            List<ReceivableSettlement> settlements) {
        this.reference = reference;
        this.dueDate = dueDate;
        this.originalAssetHolderDocumentType = originalAssetHolderDocumentType;
        this.originalAssetHolder = originalAssetHolder;
        this.paymentScheme = paymentScheme;
        this.amount = amount;
        this.prePaidAmount = prePaidAmount;
        this.bankAccount = bankAccount;
        this.settlements = settlements;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public DocumentType getOriginalAssetHolderDocumentType() {
        return originalAssetHolderDocumentType;
    }

    public void setOriginalAssetHolderDocumentType(DocumentType originalAssetHolderDocumentType) {
        this.originalAssetHolderDocumentType = originalAssetHolderDocumentType;
    }

    public String getOriginalAssetHolder() {
        return originalAssetHolder;
    }

    public void setOriginalAssetHolder(String originalAssetHolder) {
        this.originalAssetHolder = originalAssetHolder;
    }

    public String getPaymentScheme() {
        return paymentScheme;
    }

    public void setPaymentScheme(String paymentScheme) {
        this.paymentScheme = paymentScheme;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPrePaidAmount() {
        return prePaidAmount;
    }

    public void setPrePaidAmount(BigDecimal prePaidAmount) {
        this.prePaidAmount = prePaidAmount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<ReceivableSettlement> getSettlements() {
        return settlements;
    }

    public void setSettlements(List<ReceivableSettlement> settlements) {
        this.settlements = settlements;
    }

}
