package br.com.tag.sdk.model.receivable.position;

import br.com.tag.sdk.model.enums.DocumentType;
import br.com.tag.sdk.model.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * Classe de resposta para a consulta de expectativas de liquidação que transacionaram em nome de um titular específico
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-titular">Consulta por Titular</a>
 */
public class PositionExpectationQueryResponse extends BaseResponse {

    @JsonProperty("settlementExpectations")
    private List<PositionExpectationQueryOutput> settlementExpectations = new ArrayList<>();

    @JsonProperty("extractionReferenceDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date extractionReferenceDate;

    @JsonProperty("recipient")
    private String recipient;

    @JsonProperty("recipientDocumentType")
    private DocumentType recipientDocumentType;

    public PositionExpectationQueryResponse(List<PositionExpectationQueryOutput> settlementExpectations,
                                            Date extractionReferenceDate,
                                            String recipient,
                                            DocumentType recipientDocumentType) {
        this.settlementExpectations = settlementExpectations;
        this.extractionReferenceDate = extractionReferenceDate;
        this.recipient = recipient;
        this.recipientDocumentType = recipientDocumentType;
    }

    public PositionExpectationQueryResponse() {
    }

    public List<PositionExpectationQueryOutput> getSettlementExpectations() {
        return settlementExpectations;
    }

    public void setSettlementExpectations(List<PositionExpectationQueryOutput> receivablePositionItems) {
        this.settlementExpectations = receivablePositionItems;
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
