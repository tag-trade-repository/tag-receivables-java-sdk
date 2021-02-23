package br.com.tag.sdk.model.receivable.position;

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

/***
 * Classe que encapsula as liquidações das obrigações de liquidação
 * em nome de um titular especifico em uma consulta de posição de agenda
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-originador">Consulta por Originador</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-por-key">Consulta por Chave</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-por-process-reference">Consulta por Referência de Processo</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-por-reference">Consulta por Referência</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-titular">Consulta por Titular</a>
 */
public class PositionSettlement {

    @JsonProperty("key")
    private String key = null;

    @JsonProperty("reference")
    private String reference = null;

    @JsonProperty("assetHolderDocumentType")
    private DocumentType assetHolderDocumentType = null;

    @JsonProperty("assetHolder")
    private String assetHolder = null;

    @JsonProperty("amount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal amount = null;

    @JsonProperty("operationType")
    private String operationType = null;

    @JsonProperty("settlementDate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date settlementDate = null;

    @JsonProperty("bankAccount")
    private BankAccount bankAccount = null;

    @JsonProperty("lastUpdated")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SS'Z'")
    private Date lastUpdated = null;

    @JsonProperty("isRejected")
    private Boolean isRejected;

    public PositionSettlement(String key,
                              String reference,
                              DocumentType assetHolderDocumentType,
                              String assetHolder,
                              BigDecimal amount,
                              String operationType,
                              Date settlementDate,
                              BankAccount bankAccount,
                              Date lastUpdated,
                              Boolean isRejected) {
        this.key = key;
        this.reference = reference;
        this.assetHolderDocumentType = assetHolderDocumentType;
        this.assetHolder = assetHolder;
        this.amount = amount;
        this.settlementDate = settlementDate;
        this.bankAccount = bankAccount;
        this.lastUpdated = lastUpdated;
        this.isRejected = isRejected;
        this.operationType = operationType;
    }

    public PositionSettlement() {
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Boolean getRejected() {
        return isRejected;
    }

    public void setRejected(Boolean rejected) {
        isRejected = rejected;
    }

}
