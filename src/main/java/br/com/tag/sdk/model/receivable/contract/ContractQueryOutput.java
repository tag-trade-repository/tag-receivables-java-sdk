package br.com.tag.sdk.model.receivable.contract;

import br.com.tag.sdk.model.BankAccount;
import br.com.tag.sdk.model.enums.*;
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
 * Classe de output para consultas de contratos
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-garantia-troca-de-titularidade-por-key">Consulta de Contratos por Chave</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-garantia-ou-troca-de-titularidade-por-processkey">Consulta de Contratos por Chave de Processo</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-garantia-ou-troca-de-titularidade-por-referencia">Consulta de Contratos por Referência</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-garantia-ou-troca-de-titularidade-por-parametros">Consulta de Contratos por Parâmetros</a>
 */
public class ContractQueryOutput {

    @JsonProperty("key")
    private String key;

    @JsonProperty("createdAt")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @JsonProperty("isCanceled")
    private Boolean isCanceled;

    @JsonProperty("processKey")
    private String processKey;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("contractDueDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date contractDueDate;

    @JsonProperty("assetHolderDocumentType")
    private DocumentType assetHolderDocumentType;

    @JsonProperty("assetHolder")
    private String assetHolder;

    @JsonProperty("contractUniqueIdentifier")
    private String contractUniqueIdentifier;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("signatureDate")
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

    @JsonProperty("effectStrategy")
    private EffectStrategy effectStrategy;

    @JsonProperty("percentageValue")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal percentageValue;

    @JsonProperty("bankAccount")
    private BankAccount bankAccount;

    @JsonProperty("contractSpecifications")
    private List<ContractSpecification> contractSpecifications;

    public ContractQueryOutput(String key,
                               Date createdAt,
                               Boolean isCanceled,
                               String processKey,
                               String reference,
                               Date contractDueDate,
                               DocumentType assetHolderDocumentType,
                               String assetHolder,
                               String contractUniqueIdentifier,
                               Date signatureDate,
                               EffectType effectType,
                               WarrantyType warrantyType,
                               BigDecimal warrantyAmount,
                               BigDecimal balanceDue,
                               DivisionMethodType divisionMethod,
                               EffectStrategy effectStrategy,
                               BigDecimal percentageValue,
                               BankAccount bankAccount,
                               List<ContractSpecification> contractSpecifications) {
        this.key = key;
        this.createdAt = createdAt;
        this.isCanceled = isCanceled;
        this.processKey = processKey;
        this.reference = reference;
        this.contractDueDate = contractDueDate;
        this.assetHolderDocumentType = assetHolderDocumentType;
        this.assetHolder = assetHolder;
        this.contractUniqueIdentifier = contractUniqueIdentifier;
        this.signatureDate = signatureDate;
        this.effectType = effectType;
        this.warrantyType = warrantyType;
        this.warrantyAmount = warrantyAmount;
        this.balanceDue = balanceDue;
        this.divisionMethod = divisionMethod;
        this.effectStrategy = effectStrategy;
        this.percentageValue = percentageValue;
        this.bankAccount = bankAccount;
        this.contractSpecifications = contractSpecifications;
    }

    public ContractQueryOutput() {
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

    public BigDecimal getPercentageValue() {
        return percentageValue;
    }

    public void setPercentageValue(BigDecimal percentageValue) {
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

    public Boolean getIsCanceled() {
        return isCanceled;
    }

    public void setIsCanceled(Boolean canceled) {
        isCanceled = canceled;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
