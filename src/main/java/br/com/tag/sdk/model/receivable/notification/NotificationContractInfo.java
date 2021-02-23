package br.com.tag.sdk.model.receivable.notification;

import br.com.tag.sdk.model.BankAccount;
import br.com.tag.sdk.model.enums.*;
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
 * Classe que encapsula as informações de contrato dentro da notificação
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-de-contrato">Consulta de Notificação de Ônus e Gravames ou Alteração de Titularidade</a>
 * */
public class NotificationContractInfo {

    @JsonProperty("key")
    private String key;

    @JsonProperty("reference")
    private String reference;

    private Boolean isCanceled;

    @JsonProperty("contractDueDate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date contractDueDate;

    @JsonProperty("contractHolderDocumentType")
    private DocumentType contractHolderDocumentType;

    @JsonProperty("contractHolder")
    private String contractHolder;

    @JsonProperty("assetHolderDocumentType")
    private DocumentType assetHolderDocumentType;

    @JsonProperty("assetHolder")
    private String assetHolder;

    @JsonProperty("contractUniqueIdentifier")
    private String contractUniqueIdentifier;

    @JsonProperty("signatureDate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
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
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal percentageValue;

    @JsonProperty("effectStrategy")
    private EffectStrategy effectStrategy;

    @JsonProperty("bankAccount")
    private BankAccount bankAccount;

    @JsonProperty("settlementExpectationAffected")
    private List<NotificationSettlementExpectationAffected> notificationSettlementExpectationAffected = new ArrayList<>();

    public NotificationContractInfo(String key,
                                    String reference,
                                    Boolean isCanceled,
                                    Date contractDueDate,
                                    DocumentType contractHolderDocumentType,
                                    String contractHolder,
                                    DocumentType assetHolderDocumentType,
                                    String assetHolder,
                                    String contractUniqueIdentifier,
                                    Date signatureDate,
                                    EffectType effectType,
                                    WarrantyType warrantyType,
                                    BigDecimal warrantyAmount,
                                    BigDecimal balanceDue,
                                    DivisionMethodType divisionMethod,
                                    BigDecimal percentageValue,
                                    EffectStrategy effectStrategy,
                                    BankAccount bankAccount,
                                    List<NotificationSettlementExpectationAffected> notificationSettlementExpectationAffected) {
        this.key = key;
        this.reference = reference;
        this.isCanceled = isCanceled;
        this.contractDueDate = contractDueDate;
        this.contractHolderDocumentType = contractHolderDocumentType;
        this.contractHolder = contractHolder;
        this.assetHolderDocumentType = assetHolderDocumentType;
        this.assetHolder = assetHolder;
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
        this.notificationSettlementExpectationAffected = notificationSettlementExpectationAffected;
    }

    public NotificationContractInfo() {
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

    @JsonProperty("isCanceled")
    public Boolean getCanceled() {
        return isCanceled;
    }

    public void setCanceled(Boolean canceled) {
        isCanceled = canceled;
    }

    public Date getContractDueDate() {
        return contractDueDate;
    }

    public void setContractDueDate(Date contractDueDate) {
        this.contractDueDate = contractDueDate;
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

    public List<NotificationSettlementExpectationAffected> getSettlementExpectationAffected() {
        return notificationSettlementExpectationAffected;
    }

    public void setSettlementExpectationAffected(List<NotificationSettlementExpectationAffected> notificationSettlementExpectationAffected) {
        this.notificationSettlementExpectationAffected = notificationSettlementExpectationAffected;
    }

}
