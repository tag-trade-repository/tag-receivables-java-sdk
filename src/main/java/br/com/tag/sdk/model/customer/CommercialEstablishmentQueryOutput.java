package br.com.tag.sdk.model.customer;

import br.com.tag.sdk.model.enums.DocumentType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Classe de output para consulta de estabelecimentos comerciais
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-ec-por-par%C3%A2metros-perpage-e-page"></a>
 */
public class CommercialEstablishmentQueryOutput {

    @JsonProperty("key")
    private String key;

    @JsonProperty("paymentSchemes")
    private List<String> paymentSchemes;

    @JsonProperty("documentType")
    private DocumentType documentType;

    @JsonProperty("documentNumber")
    private String documentNumber;

    public CommercialEstablishmentQueryOutput(String key, List<String> paymentSchemes, DocumentType documentType, String documentNumber) {
        this.key = key;
        this.paymentSchemes = paymentSchemes;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
    }

    public CommercialEstablishmentQueryOutput() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getPaymentScheme() {
        return paymentSchemes;
    }

    public void setPaymentScheme(List<String> paymentSchemes) {
        this.paymentSchemes = paymentSchemes;
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

}
