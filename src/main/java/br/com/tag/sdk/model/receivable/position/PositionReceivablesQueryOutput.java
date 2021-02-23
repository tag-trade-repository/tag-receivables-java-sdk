package br.com.tag.sdk.model.receivable.position;

import br.com.tag.sdk.model.enums.DocumentType;
import br.com.tag.sdk.utils.DecimalDeserializer;
import br.com.tag.sdk.utils.DecimalSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * Classe que encapsula o retorno da consulta de unidades recebíveis que transacionaram.
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-originador">Consulta por Originador</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-por-key">Consulta por Chave</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-por-process-reference">Consulta por Referência de Processo</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-por-reference">Consulta por Referência</a>
 */
public class PositionReceivablesQueryOutput {

    @JsonProperty("key")
    private String key;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("dueDate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date dueDate;

    @JsonProperty("paymentScheme")
    private String paymentScheme;

    @JsonProperty("debtor")
    private String debtor;

    @JsonProperty("originalAssetHolderDocumentType")
    private DocumentType originalAssetHolderDocumentType;

    @JsonProperty("originalAssetHolder")
    private String originalAssetHolder;

    @JsonProperty("amount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal amount;

    @JsonProperty("prePaidAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal prePaidAmount;

    @JsonProperty("createdAt")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'")
    private Date createdAt;

    @JsonProperty("lastUpdated")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'")
    private Date lastUpdated;

    @JsonProperty("settlementObligations")
    private List<PositionSettlementObligation> settlementObligations = new ArrayList<>();

    public PositionReceivablesQueryOutput(String key,
                                          String reference,
                                          Date dueDate,
                                          String paymentScheme,
                                          String debtor,
                                          DocumentType originalAssetHolderDocumentType,
                                          String originalAssetHolder,
                                          BigDecimal amount,
                                          BigDecimal prePaidAmount,
                                          Date createdAt,
                                          Date lastUpdated,
                                          List<PositionSettlementObligation> settlementObligations) {
        this.key = key;
        this.reference = reference;
        this.dueDate = dueDate;
        this.paymentScheme = paymentScheme;
        this.debtor = debtor;
        this.originalAssetHolderDocumentType = originalAssetHolderDocumentType;
        this.originalAssetHolder = originalAssetHolder;
        this.amount = amount;
        this.prePaidAmount = prePaidAmount;
        this.createdAt = createdAt;
        this.lastUpdated = lastUpdated;
        this.settlementObligations = settlementObligations;
    }

    public PositionReceivablesQueryOutput() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public String getPaymentScheme() {
        return paymentScheme;
    }

    public void setPaymentScheme(String paymentScheme) {
        this.paymentScheme = paymentScheme;
    }

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<PositionSettlementObligation> getSettlementObligations() {
        return settlementObligations;
    }

    public void setSettlementObligations(List<PositionSettlementObligation> receivableSettlementObligationItems) {
        this.settlementObligations = receivableSettlementObligationItems;
    }

}
