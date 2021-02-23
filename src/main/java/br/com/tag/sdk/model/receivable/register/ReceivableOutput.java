package br.com.tag.sdk.model.receivable.register;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/***
 * Classe de retorno após o Registro e Atualização de Ativos Financeiros
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/registro">Registro e Atualização de Ativos Financeiros</a>
 */
public class ReceivableOutput {

    @JsonProperty("key")
    private String key;

    @JsonProperty("debtor")
    private String debtor;

    @JsonProperty("originalAssetHolder")
    private String originalAssetHolder;

    @JsonProperty("dueDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    @JsonProperty("paymentScheme")
    private String paymentScheme;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("settlements")
    private List<ReceivableSettlementOutput> settlements;

    public ReceivableOutput(String key,
                            String debtor,
                            String originalAssetHolder,
                            Date dueDate,
                            String paymentScheme,
                            String reference,
                            List<ReceivableSettlementOutput> settlements) {
        this.key = key;
        this.debtor = debtor;
        this.originalAssetHolder = originalAssetHolder;
        this.dueDate = dueDate;
        this.paymentScheme = paymentScheme;
        this.reference = reference;
        this.settlements = settlements;
    }

    public ReceivableOutput() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
    }

    public String getOriginalAssetHolder() {
        return originalAssetHolder;
    }

    public void setOriginalAssetHolder(String originalAssetHolder) {
        this.originalAssetHolder = originalAssetHolder;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getPaymentScheme() {
        return paymentScheme;
    }

    public void setPaymentScheme(String paymentScheme) {
        this.paymentScheme = paymentScheme;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<ReceivableSettlementOutput> getSettlements() {
        return settlements;
    }

    public void setSettlements(List<ReceivableSettlementOutput> settlements) {
        this.settlements = settlements;
    }

}
