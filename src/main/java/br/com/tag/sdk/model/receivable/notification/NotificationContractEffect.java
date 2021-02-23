package br.com.tag.sdk.model.receivable.notification;

import br.com.tag.sdk.model.enums.DivisionMethodType;
import br.com.tag.sdk.model.enums.EffectStrategy;
import br.com.tag.sdk.model.enums.EffectType;
import br.com.tag.sdk.utils.DecimalDeserializer;
import br.com.tag.sdk.utils.DecimalSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;

/***
 * Classe que encapsula os efeitos de contrato das expectativas de liquidação das consultas de notificação de contrato
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-de-contrato">Consulta de Notificação de Ônus e Gravames ou Alteração de Titularidade</a>
 * */
class NotificationContractEffect {

    @JsonProperty("effectStrategy")
    private EffectStrategy effectStrategy;

    @JsonProperty("divisionMethod")
    private DivisionMethodType divisionMethod;

    @JsonProperty("effectType")
    private EffectType effectType;

    @JsonProperty("effectAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal effectAmount;

    @JsonProperty("committedAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal committedAmount;

    @JsonProperty("percentageValue")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal percentageValue;

    @JsonProperty("processKey")
    private String processKey;

    @JsonProperty("effectPriority")
    private Integer effectPriority;

    public NotificationContractEffect(EffectStrategy effectStrategy,
                                      DivisionMethodType divisionMethod,
                                      EffectType effectType,
                                      BigDecimal effectAmount,
                                      BigDecimal committedAmount,
                                      BigDecimal percentageValue,
                                      String processKey,
                                      Integer effectPriority) {
        this.effectStrategy = effectStrategy;
        this.divisionMethod = divisionMethod;
        this.effectType = effectType;
        this.effectAmount = effectAmount;
        this.committedAmount = committedAmount;
        this.percentageValue = percentageValue;
        this.processKey = processKey;
        this.effectPriority = effectPriority;
    }

    public NotificationContractEffect() {
    }

    public EffectStrategy getEffectStrategy() {
        return effectStrategy;
    }

    public void setEffectStrategy(EffectStrategy effectStrategy) {
        this.effectStrategy = effectStrategy;
    }

    public DivisionMethodType getDivisionMethod() {
        return divisionMethod;
    }

    public void setDivisionMethod(DivisionMethodType divisionMethod) {
        this.divisionMethod = divisionMethod;
    }

    public EffectType getEffectType() {
        return effectType;
    }

    public void setEffectType(EffectType effectType) {
        this.effectType = effectType;
    }

    public BigDecimal getEffectAmount() {
        return effectAmount;
    }

    public void setEffectAmount(BigDecimal effectAmount) {
        this.effectAmount = effectAmount;
    }

    public BigDecimal getCommittedAmount() {
        return committedAmount;
    }

    public void setCommittedAmount(BigDecimal committedAmount) {
        this.committedAmount = committedAmount;
    }

    public BigDecimal getPercentageValue() {
        return percentageValue;
    }

    public void setPercentageValue(BigDecimal percentageValue) {
        this.percentageValue = percentageValue;
    }

    public String getProcessKey() {
        return processKey;
    }

    public void setProcessKey(String processKey) {
        this.processKey = processKey;
    }

    public Integer getEffectPriority() {
        return effectPriority;
    }

    public void setEffectPriority(Integer effectPriority) {
        this.effectPriority = effectPriority;
    }

}
