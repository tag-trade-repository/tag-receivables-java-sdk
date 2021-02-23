package br.com.tag.sdk.model.customer;

import br.com.tag.sdk.model.BankAccount;
import br.com.tag.sdk.model.enums.DocumentType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/***
 * Classe base de estabelecimentos comerciais, utilizada como input da requisição
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/estabelecimento-comercial"></a>
 */
public class CommercialEstablishment {

    @JsonProperty("documentType")
    private DocumentType documentType;

    @JsonProperty("documentNumber")
    private String documentNumber;

    @JsonProperty("paymentSchemes")
    private List<String> paymentSchemes = new ArrayList<>();
    @JsonProperty("bankAccount")

    private BankAccount bankAccount;

    public CommercialEstablishment(DocumentType documentType,
                                   String documentNumber,
                                   List<String> paymentSchemes,
                                   BankAccount bankAccount) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.paymentSchemes = paymentSchemes;
        this.bankAccount = bankAccount;
    }

    public CommercialEstablishment() {
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
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
