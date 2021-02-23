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
 * Classe que encapsula o retorno de uma consulta de expectativas de liquidação que transacionaram em nome de um titular específico
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-titular">Consulta por Titular</a>
 */
public class PositionExpectationQueryOutput {

    @JsonProperty("key")
    private String key;

    @JsonProperty("totalAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal totalAmount;

    @JsonProperty("settledAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal settledAmount;

    @JsonProperty("balanceAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal balanceAmount;

    @JsonProperty("committedAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal committedAmount;

    @JsonProperty("uncommittedAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal uncommittedAmount;

    @JsonProperty("expectedSettlementDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expectedSettlementDate;

    @JsonProperty("assetHolderDocumentType")
    private DocumentType assetHolderDocumentType;

    @JsonProperty("assetHolder")
    private String assetHolder;

    @JsonProperty("paymentScheme")
    private String paymentScheme;

    @JsonProperty("debtor")
    private String debtor;

    @JsonProperty("lastUpdated")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date lastUpdated;

    @JsonProperty("settlementObligations")
    private List<PositionSettlementObligation> settlementObligations = new ArrayList<>();

    public PositionExpectationQueryOutput(String key,
                                          BigDecimal totalAmount,
                                          BigDecimal settledAmount,
                                          BigDecimal balanceAmount,
                                          BigDecimal committedAmount,
                                          BigDecimal uncommittedAmount,
                                          Date expectedSettlementDate,
                                          DocumentType assetHolderDocumentType,
                                          String assetHolder,
                                          String paymentScheme,
                                          String debtor,
                                          Date lastUpdated,
                                          List<PositionSettlementObligation> settlementObligations) {
        this.key = key;
        this.totalAmount = totalAmount;
        this.settledAmount = settledAmount;
        this.balanceAmount = balanceAmount;
        this.committedAmount = committedAmount;
        this.uncommittedAmount = uncommittedAmount;
        this.expectedSettlementDate = expectedSettlementDate;
        this.assetHolderDocumentType = assetHolderDocumentType;
        this.assetHolder = assetHolder;
        this.paymentScheme = paymentScheme;
        this.lastUpdated = lastUpdated;
        this.settlementObligations = settlementObligations;
        this.debtor = debtor;
    }

    public PositionExpectationQueryOutput() {
    }

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getSettledAmount() {
        return settledAmount;
    }

    public void setSettledAmount(BigDecimal settledAmount) {
        this.settledAmount = settledAmount;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public BigDecimal getCommittedAmount() {
        return committedAmount;
    }

    public void setCommittedAmount(BigDecimal committedAmount) {
        this.committedAmount = committedAmount;
    }

    public BigDecimal getUncommittedAmount() {
        return uncommittedAmount;
    }

    public void setUncommittedAmount(BigDecimal uncommittedAmount) {
        this.uncommittedAmount = uncommittedAmount;
    }

    public Date getExpectedSettlementDate() {
        return expectedSettlementDate;
    }

    public void setExpectedSettlementDate(Date expectedSettlementDate) {
        this.expectedSettlementDate = expectedSettlementDate;
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

    public String getPaymentScheme() {
        return paymentScheme;
    }

    public void setPaymentScheme(String paymentScheme) {
        this.paymentScheme = paymentScheme;
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

    public void setSettlementObligations(List<PositionSettlementObligation> settlementObligations) {
        this.settlementObligations = settlementObligations;
    }

}
