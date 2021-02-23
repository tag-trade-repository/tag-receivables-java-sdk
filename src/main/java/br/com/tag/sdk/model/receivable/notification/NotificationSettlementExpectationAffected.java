package br.com.tag.sdk.model.receivable.notification;

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
 * Classe que encapsula as expectativas de liquidação do retorno das notificações de contrato (Ônus e Gravames ou Alteração de Titularidade)
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-de-contrato">Consulta de Notificação de Ônus e Gravames ou Alteração de Titularidade</a>
 * */
class NotificationSettlementExpectationAffected {

    @JsonProperty("debtor")
    private String debtor;

    @JsonProperty("assetHolder")
    private String assetHolder;

    @JsonProperty("paymentScheme")
    private String paymentScheme;

    @JsonProperty("expectedSettlementDate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date expectedSettlementDate;

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

    @JsonProperty("contractEffects")
    private List<NotificationContractEffect> notificationContractEffects = new ArrayList<>();

    public NotificationSettlementExpectationAffected(String debtor,
                                                     String assetHolder,
                                                     String paymentScheme,
                                                     Date expectedSettlementDate,
                                                     BigDecimal totalAmount,
                                                     BigDecimal settledAmount,
                                                     BigDecimal balanceAmount,
                                                     BigDecimal committedAmount,
                                                     BigDecimal uncommittedAmount,
                                                     List<NotificationContractEffect> notificationContractEffects) {
        this.debtor = debtor;
        this.assetHolder = assetHolder;
        this.paymentScheme = paymentScheme;
        this.expectedSettlementDate = expectedSettlementDate;
        this.totalAmount = totalAmount;
        this.settledAmount = settledAmount;
        this.balanceAmount = balanceAmount;
        this.committedAmount = committedAmount;
        this.uncommittedAmount = uncommittedAmount;
        this.notificationContractEffects = notificationContractEffects;
    }

    public NotificationSettlementExpectationAffected() {

    }

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
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

    public Date getExpectedSettlementDate() {
        return expectedSettlementDate;
    }

    public void setExpectedSettlementDate(Date expectedSettlementDate) {
        this.expectedSettlementDate = expectedSettlementDate;
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

    public List<NotificationContractEffect> getContractEffects() {
        return notificationContractEffects;
    }

    public void setContractEffects(List<NotificationContractEffect> notificationContractEffects) {
        this.notificationContractEffects = notificationContractEffects;
    }

}
