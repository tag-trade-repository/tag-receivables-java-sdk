package br.com.tag.sdk.model.receivable.contract;

import br.com.tag.sdk.model.BankAccount;
import br.com.tag.sdk.model.enums.DivisionMethodType;
import br.com.tag.sdk.model.enums.EffectStrategy;
import br.com.tag.sdk.model.enums.EffectType;
import br.com.tag.sdk.model.enums.WarrantyType;
import br.com.tag.sdk.model.response.BaseQueryResponse;
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
 * Classe de resposta para consulta de histórico
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-historico-de-garantia-ou-troca-de-titularidade"></a>
 */
public class ContractHistoryResponse extends BaseQueryResponse {

    @JsonProperty("key")
    private String key;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("contractDueDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date contractDueDate;

    @JsonProperty("contractUniqueIdentifier")
    private String contractUniqueIdentifier;

    @JsonProperty("signatureDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date signatureDate;

    @JsonProperty("effectType")
    private EffectType effectType;

    @JsonProperty("warrantyType")
    private WarrantyType warrantyType;

    @JsonProperty("warrantyAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal warrantyAmount;

    @JsonProperty("balanceDue")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal balanceDue;

    @JsonProperty("divisionMethod")
    private DivisionMethodType divisionMethod;

    @JsonProperty("percentageValue")
    private Integer percentageValue;

    @JsonProperty("effectStrategy")
    private EffectStrategy effectStrategy;

    @JsonProperty("bankAccount")
    private BankAccount bankAccount;

    @JsonProperty("contractSpecifications")
    private List<ContractSpecification> contractSpecifications = new ArrayList<>();

    @JsonProperty("processKey")
    private String processKey;

    @JsonProperty("createdAt")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSS'Z'")
    private Date createdAt;

    @JsonProperty("history")
    private List<ContractHistory> history = new ArrayList<>();

    public ContractHistoryResponse(String queryKey, Date queryDate, String key, String reference, Date contractDueDate, String contractUniqueIdentifier, Date signatureDate, EffectType effectType, WarrantyType warrantyType, BigDecimal warrantyAmount, BigDecimal balanceDue, DivisionMethodType divisionMethod, Integer percentageValue, EffectStrategy effectStrategy, BankAccount bankAccount, List<ContractSpecification> contractSpecifications, String processKey, Date createdAt, List<ContractHistory> history) {
        super(queryKey, queryDate);
        this.key = key;
        this.reference = reference;
        this.contractDueDate = contractDueDate;
        this.contractUniqueIdentifier = contractUniqueIdentifier;
        this.signatureDate = signatureDate;
        this.effectType = effectType;
        this.warrantyType = warrantyType;
        this.warrantyAmount = warrantyAmount;
        this.balanceDue = balanceDue;
        this.divisionMethod = divisionMethod;
        this.percentageValue = percentageValue;
        this.effectStrategy = effectStrategy;
        this.bankAccount = bankAccount;
        this.contractSpecifications = contractSpecifications;
        this.processKey = processKey;
        this.createdAt = createdAt;
        this.history = history;
    }

    public ContractHistoryResponse() {
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

    public Date getContractDueDate() {
        return contractDueDate;
    }

    public void setContractDueDate(Date contractDueDate) {
        this.contractDueDate = contractDueDate;
    }

    public EffectType getEffectType() {
        return effectType;
    }

    public void setEffectType(EffectType effectType) {
        this.effectType = effectType;
    }

    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
    }

    public BigDecimal getWarrantyAmount() {
        return warrantyAmount;
    }

    public void setWarrantyAmount(BigDecimal warrantyAmount) {
        this.warrantyAmount = warrantyAmount;
    }

    public BigDecimal getBalanceDue() {
        return balanceDue;
    }

    public void setBalanceDue(BigDecimal balanceDue) {
        this.balanceDue = balanceDue;
    }

    public DivisionMethodType getDivisionMethod() {
        return divisionMethod;
    }

    public void setDivisionMethod(DivisionMethodType divisionMethod) {
        this.divisionMethod = divisionMethod;
    }

    public Integer getPercentageValue() {
        return percentageValue;
    }

    public void setPercentageValue(Integer percentageValue) {
        this.percentageValue = percentageValue;
    }

    public EffectStrategy getEffectStrategy() {
        return effectStrategy;
    }

    public void setEffectStrategy(EffectStrategy effectStrategy) {
        this.effectStrategy = effectStrategy;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<ContractSpecification> getContractSpecifications() {
        return contractSpecifications;
    }

    public void setContractSpecifications(List<ContractSpecification> contractSpecifications) {
        this.contractSpecifications = contractSpecifications;
    }

    public String getProcessKey() {
        return processKey;
    }

    public void setProcessKey(String processKey) {
        this.processKey = processKey;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<ContractHistory> getHistory() {
        return history;
    }

    public void setHistory(List<ContractHistory> history) {
        this.history = history;
    }

    public String getContractUniqueIdentifier() {
        return contractUniqueIdentifier;
    }

    public void setContractUniqueIdentifier(String contractUniqueIdentifier) {
        this.contractUniqueIdentifier = contractUniqueIdentifier;
    }

    public Date getSignatureDate() {
        return signatureDate;
    }

    public void setSignatureDate(Date signatureDate) {
        this.signatureDate = signatureDate;
    }

}
