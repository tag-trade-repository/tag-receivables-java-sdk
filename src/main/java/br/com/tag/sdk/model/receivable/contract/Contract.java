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
 * Classe base para criação de contrato (Ônus e Gravames ou Alteração de Titularidade)
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/garantia-ou-troca-de-titularidade">Ônus e Gravames ou Alteração de Titularidade</a>
 */
public class Contract {

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

    public Contract(String reference,
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

    public Contract() {
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

    public EffectStrategy getEffectStrategy() {
        return effectStrategy;
    }

    public void setEffectStrategy(EffectStrategy effectStrategy) {
        this.effectStrategy = effectStrategy;
    }

    public BigDecimal getPercentageValue() {
        return percentageValue;
    }

    public void setPercentageValue(BigDecimal percentageValue) {
        this.percentageValue = percentageValue;
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
}
