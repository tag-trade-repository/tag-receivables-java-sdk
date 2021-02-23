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

public class ReceivableSettlement {

    @JsonProperty("reference")
    private String reference = null;

    @JsonProperty("assetHolderDocumentType")
    private DocumentType assetHolderDocumentType = null;

    @JsonProperty("assetHolder")
    private String assetHolder = null;

    @JsonProperty("settlementDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date settlementDate = null;

    @JsonProperty("amount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal amount = null;

    @JsonProperty("settlementObligationDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date settlementObligationDate = null;

    @JsonProperty("bankAccount")
    private BankAccount bankAccount = null;

    public ReceivableSettlement(String reference,
                      DocumentType assetHolderDocumentType,
                      String assetHolder,
                      Date settlementDate,
                      Date settlementObligationDate,
                      BigDecimal amount,
                      BankAccount bankAccount) {
        this.reference = reference;
        this.assetHolderDocumentType = assetHolderDocumentType;
        this.assetHolder = assetHolder;
        this.settlementDate = settlementDate;
        this.amount = amount;
        this.settlementObligationDate = settlementObligationDate;
        this.bankAccount = bankAccount;
    }

    public ReceivableSettlement() {
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public DocumentType getAssetHolderDocumentType() {
        return assetHolderDocumentType;
    }

    public void setAssetHolderDocumentType(DocumentType assetHolderDocumentType) {
        this.assetHolderDocumentType = assetHolderDocumentType;
    }

    public String getAssetHolder() {
        return assetHolder;
    }

    public void setAssetHolder(String assetHolder) {
        this.assetHolder = assetHolder;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getSettlementObligationDate() {
        return settlementObligationDate;
    }

    public void setSettlementObligationDate(Date settlementObligationDate) {
        this.settlementObligationDate = settlementObligationDate;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

}