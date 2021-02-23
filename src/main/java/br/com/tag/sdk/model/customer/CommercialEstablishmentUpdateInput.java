package br.com.tag.sdk.model.customer;

import br.com.tag.sdk.model.BankAccount;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/***
 * Classe de input para atualização de estabelecimentos comerciais
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/altera%C3%A7%C3%A3o-de-ec"></a>
 */
public class CommercialEstablishmentUpdateInput {

    @JsonProperty("paymentSchemes")
    private List<String> paymentSchemes = new ArrayList<>();

    @JsonProperty("bankAccount")
    private BankAccount bankAccount;

    @JsonProperty("enabled")
    private Boolean enabled;

    public CommercialEstablishmentUpdateInput(List<String> paymentSchemes, BankAccount bankAccount, Boolean enabled) {
        this.paymentSchemes = paymentSchemes;
        this.bankAccount = bankAccount;
        this.enabled = enabled;
    }

    public CommercialEstablishmentUpdateInput() {
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getPaymentSchemes() {
        return paymentSchemes;
    }

    public void setPaymentSchemes(List<String> paymentSchemes) {
        this.paymentSchemes = paymentSchemes;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

}
