package br.com.tag.sdk.model.receivable.advancement;

import br.com.tag.sdk.utils.DecimalDeserializer;
import br.com.tag.sdk.utils.DecimalSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.util.Date;

/***
 * Classe de recebiveis da antecipação pós-contratada
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/alteracao-da-data-de-expectativa-de-liquidacao">Antecipação Pós-Contratada</a>
 */
public class AdvancedReceivable {

    @JsonProperty("paymentScheme")
    private String paymentScheme;

    @JsonProperty("settlementObligationDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date settlementObligationDate;

    @JsonProperty("advancedAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal advancedAmount;

    public AdvancedReceivable(String paymentScheme, Date settlementObligationDate, BigDecimal advancedAmount) {
        this.paymentScheme = paymentScheme;
        this.settlementObligationDate = settlementObligationDate;
        this.advancedAmount = advancedAmount;
    }

    public AdvancedReceivable() {
    }

    public String getPaymentScheme() {
        return paymentScheme;
    }

    public void setPaymentScheme(String paymentScheme) {
        this.paymentScheme = paymentScheme;
    }

    public Date getSettlementObligationDate() {
        return settlementObligationDate;
    }

    public void setSettlementObligationDate(Date settlementObligationDate) {
        this.settlementObligationDate = settlementObligationDate;
    }

    public BigDecimal getAdvancedAmount() {
        return advancedAmount;
    }

    public void setAdvancedAmount(BigDecimal advancedAmount) {
        this.advancedAmount = advancedAmount;
    }

}
