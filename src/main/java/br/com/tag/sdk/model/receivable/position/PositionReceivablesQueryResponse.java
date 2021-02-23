package br.com.tag.sdk.model.receivable.position;

import br.com.tag.sdk.model.enums.DocumentType;
import br.com.tag.sdk.model.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * Classe de resposta para a consulta de unidades recebíveis que transacionaram.
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-originador">Consulta por Originador</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-por-key">Consulta por Chave</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-por-process-reference">Consulta por Referência de Processo</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-por-reference">Consulta por Referência</a>
 */
public class PositionReceivablesQueryResponse extends BaseResponse {

    @JsonProperty("receivables")
    private List<PositionReceivablesQueryOutput> receivables = new ArrayList<>();

    @JsonProperty("extractionReferenceDate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date extractionReferenceDate;

    @JsonProperty("recipient")
    private String recipient;

    @JsonProperty("recipientDocumentType")
    private DocumentType recipientDocumentType;

    public PositionReceivablesQueryResponse(List<PositionReceivablesQueryOutput> receivables,
                                            Date extractionReferenceDate,
                                            String recipient,
                                            DocumentType recipientDocumentType) {
        this.receivables = receivables;
        this.extractionReferenceDate = extractionReferenceDate;
        this.recipient = recipient;
        this.recipientDocumentType = recipientDocumentType;
    }

    public PositionReceivablesQueryResponse() {
    }

    public List<PositionReceivablesQueryOutput> getReceivables() {
        return receivables;
    }

    public void setReceivables(List<PositionReceivablesQueryOutput> receivablePositionItems) {
        this.receivables = receivablePositionItems;
    }

    public Date getExtractionReferenceDate() {
        return extractionReferenceDate;
    }

    public void setExtractionReferenceDate(Date extractionReferenceDate) {
        this.extractionReferenceDate = extractionReferenceDate;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public DocumentType getRecipientDocumentType() {
        return recipientDocumentType;
    }

    public void setRecipientDocumentType(DocumentType recipientDocumentType) {
        this.recipientDocumentType = recipientDocumentType;
    }

}
