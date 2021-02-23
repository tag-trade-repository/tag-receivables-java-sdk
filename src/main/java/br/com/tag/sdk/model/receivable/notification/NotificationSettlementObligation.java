package br.com.tag.sdk.model.receivable.notification;

import br.com.tag.sdk.model.BankAccount;
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
 * Classe que encapsula as obrigações de liquidação nas consultas de notificação da Antecipação Pós Contratada
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-de-antecipa%C3%A7%C3%A3o-p%C3%B3s-contratada">Consulta de Notificação de Antecipação Pós Contratada</a>
 * */
class NotificationSettlementObligation extends BaseNotification {

    @JsonProperty("key")
    private String key;

    @JsonProperty("paymentScheme")
    private String paymentScheme;

    @JsonProperty("totalAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal totalAmount;

    @JsonProperty("committedAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal committedAmount;

    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    @JsonProperty("uncommittedAmount")
    private BigDecimal uncommittedAmount;

    @JsonProperty("expectedSettlementDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expectedSettlementDate;

    @JsonProperty("obligationType")
    private String obligationType;

    @JsonProperty("bankAccount")
    private BankAccount bankAccount;

    @JsonProperty("contractObligations")
    private List<String> contractObligations = new ArrayList<>();

    public NotificationSettlementObligation(String processKey,
                                            Date createdAt,
                                            Date lastUpdated,
                                            List<String> errors,
                                            Boolean hasError,
                                            String key,
                                            String paymentScheme,
                                            BigDecimal totalAmount,
                                            BigDecimal committedAmount,
                                            BigDecimal uncommittedAmount,
                                            Date expectedSettlementDate,
                                            String obligationType,
                                            BankAccount bankAccount,
                                            List<String> contractObligations) {
        super(processKey, createdAt, lastUpdated, errors, hasError);
        this.key = key;
        this.paymentScheme = paymentScheme;
        this.totalAmount = totalAmount;
        this.committedAmount = committedAmount;
        this.uncommittedAmount = uncommittedAmount;
        this.expectedSettlementDate = expectedSettlementDate;
        this.obligationType = obligationType;
        this.bankAccount = bankAccount;
        this.contractObligations = contractObligations;
    }

    public NotificationSettlementObligation() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPaymentScheme() {
        return paymentScheme;
    }

    public void setPaymentScheme(String paymentScheme) {
        this.paymentScheme = paymentScheme;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
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

    public String getObligationType() {
        return obligationType;
    }

    public void setObligationType(String obligationType) {
        this.obligationType = obligationType;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<String> getContractObligations() {
        return contractObligations;
    }

    public void setContractObligations(List<String> contractObligations) {
        this.contractObligations = contractObligations;
    }

}
