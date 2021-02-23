package br.com.tag.sdk.model.receivable.notification;


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
 * Classe que encapsula o retorno das consultas de notificação de liquidação
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-de-liquida%C3%A7%C3%A3o">Consulta de Notificação de Liquidação</a>
 * */
public class NotificationSettlement extends BaseNotification {

    @JsonProperty("key")
    private String key;

    @JsonProperty("participant")
    private String participant;

    @JsonProperty("assetHolder")
    private String assetHolder;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("assetHolderDocumentType")
    private DocumentType assetHolderDocumentType;

    @JsonProperty("settlementDate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date settlementDate;

    @JsonProperty("settlementObligationDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date settlementObligationDate;

    @JsonProperty("amount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal amount;

    @JsonProperty("debtor")
    private String debtor;

    @JsonProperty("paymentScheme")
    private String paymentScheme;

    @JsonProperty("bankAccount")
    private BankAccount bankAccount;

    public NotificationSettlement(String processKey,
                                  Date createdAt,
                                  Date lastUpdated,
                                  List<String> errors,
                                  Boolean hasError,
                                  String key,
                                  String participant,
                                  String assetHolder,
                                  String reference,
                                  DocumentType assetHolderDocumentType,
                                  Date settlementDate,
                                  Date settlementObligationDate,
                                  BigDecimal amount,
                                  String debtor,
                                  String paymentScheme,
                                  BankAccount bankAccount) {
        super(processKey, createdAt, lastUpdated, errors, hasError);
        this.key = key;
        this.participant = participant;
        this.assetHolder = assetHolder;
        this.reference = reference;
        this.assetHolderDocumentType = assetHolderDocumentType;
        this.settlementDate = settlementDate;
        this.settlementObligationDate = settlementObligationDate;
        this.amount = amount;
        this.debtor = debtor;
        this.paymentScheme = paymentScheme;
        this.bankAccount = bankAccount;
    }

    public NotificationSettlement() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getAssetHolder() {
        return assetHolder;
    }

    public void setAssetHolder(String assetHolder) {
        this.assetHolder = assetHolder;
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

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public Date getSettlementObligationDate() {
        return settlementObligationDate;
    }

    public void setSettlementObligationDate(Date settlementObligationDate) {
        this.settlementObligationDate = settlementObligationDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
    }

    public String getPaymentScheme() {
        return paymentScheme;
    }

    public void setPaymentScheme(String paymentScheme) {
        this.paymentScheme = paymentScheme;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

}
