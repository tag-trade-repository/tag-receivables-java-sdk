package br.com.tag.sdk.model.receivable.position;

import br.com.tag.sdk.model.BankAccount;
import br.com.tag.sdk.model.enums.DivisionMethodType;
import br.com.tag.sdk.model.enums.DocumentType;
import br.com.tag.sdk.model.enums.EffectStrategy;
import br.com.tag.sdk.model.enums.WarrantyType;
import br.com.tag.sdk.utils.DecimalDeserializer;
import br.com.tag.sdk.utils.DecimalSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.util.Date;

/***
 * Classe que encapsula as obrigações de contrato em uma consulta de posição de agenda
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-originador">Consulta por Originador</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-por-key">Consulta por Chave</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-por-process-reference">Consulta por Referência de Processo</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-por-reference">Consulta por Referência</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-titular">Consulta por Titular</a>
 */
public class PositionContractObligations {

    @JsonProperty("key")
    private String key;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("contractHolderDocumentType")
    private DocumentType contractHolderDocumentType;

    @JsonProperty("contractHolder")
    private String contractHolder;

    @JsonProperty("effectPriority")
    private Integer effectPriority;

    @JsonProperty("contractType")
    private String contractType;

    @JsonProperty("warrantyType")
    private WarrantyType warrantyType;

    @JsonProperty("divisionMethod")
    private DivisionMethodType divisionMethod;

    @JsonProperty("effectStrategy")
    private EffectStrategy effectStrategy;

    @JsonProperty("effectAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal effectAmount;

    @JsonProperty("committedEffectAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal committedEffectAmount;

    @JsonProperty("bankAccount")
    private BankAccount bankAccount;

    @JsonProperty("lastUpdated")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date lastUpdate;

    @JsonProperty("createdAt")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSS'Z'")
    private Date createdAt;

    public PositionContractObligations(String key,
                                       String reference,
                                       DocumentType contractHolderDocumentType,
                                       String contractHolder,
                                       Integer effectPriority,
                                       String contractType,
                                       WarrantyType warrantyType,
                                       DivisionMethodType divisionMethod,
                                       EffectStrategy effectStrategy,
                                       BigDecimal effectAmount,
                                       BigDecimal committedEffectAmount,
                                       BankAccount bankAccount,
                                       Date lastUpdate) {
        this.key = key;
        this.reference = reference;
        this.contractHolderDocumentType = contractHolderDocumentType;
        this.contractHolder = contractHolder;
        this.effectPriority = effectPriority;
        this.contractType = contractType;
        this.warrantyType = warrantyType;
        this.divisionMethod = divisionMethod;
        this.effectStrategy = effectStrategy;
        this.effectAmount = effectAmount;
        this.committedEffectAmount = committedEffectAmount;
        this.bankAccount = bankAccount;
        this.lastUpdate = lastUpdate;
    }

    public PositionContractObligations() {
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

    public DocumentType getContractHolderDocumentType() {
        return contractHolderDocumentType;
    }

    public void setContractHolderDocumentType(DocumentType contractHolderDocumentType) {
        this.contractHolderDocumentType = contractHolderDocumentType;
    }

    public String getContractHolder() {
        return contractHolder;
    }

    public void setContractHolder(String contractHolder) {
        this.contractHolder = contractHolder;
    }

    public Integer getEffectPriority() {
        return effectPriority;
    }

    public void setEffectPriority(Integer effectPriority) {
        this.effectPriority = effectPriority;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
    }

    public DivisionMethodType getDivisionMethod() {
        return divisionMethod;
    }

    public void setDivisionMethod(DivisionMethodType divisionMethod) {
        this.divisionMethod = divisionMethod;
    }

    public EffectStrategy getEffectStrategy() {
        return effectStrategy;
    }

    public void setEffectStrategy(EffectStrategy effectStrategy) {
        this.effectStrategy = effectStrategy;
    }

    public BigDecimal getEffectAmount() {
        return effectAmount;
    }

    public void setEffectAmount(BigDecimal effectAmount) {
        this.effectAmount = effectAmount;
    }

    public BigDecimal getCommittedEffectAmount() {
        return committedEffectAmount;
    }

    public void setCommittedEffectAmount(BigDecimal committedEffectAmount) {
        this.committedEffectAmount = committedEffectAmount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
