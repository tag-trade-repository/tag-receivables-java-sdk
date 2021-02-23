package br.com.tag.sdk.model.receivable.advancement;

import br.com.tag.sdk.model.enums.DocumentType;
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
 * Classe base para antecipação pós contratada
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/alteracao-da-data-de-expectativa-de-liquidacao">Antecipação Pós-Contratada</a>
 */
public class Advancement {

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("assetHolderDocumentType")
    private DocumentType assetHolderDocumentType;

    @JsonProperty("assetHolder")
    private String assetHolder;

    @JsonProperty("operationValue")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal operationValue;

    @JsonProperty("operationExpectedSettlementDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date operationExpectedSettlementDate;

    @JsonProperty("advancedReceivables")
    private List<AdvancedReceivable> advancedReceivables = new ArrayList<>();

    public Advancement(String reference,
                       DocumentType assetHolderDocumentType,
                       String assetHolder,
                       BigDecimal operationValue,
                       Date operationExpectedSettlementDate,
                       List<AdvancedReceivable> advancedReceivables) {
        this.reference = reference;
        this.assetHolderDocumentType = assetHolderDocumentType;
        this.assetHolder = assetHolder;
        this.operationValue = operationValue;
        this.operationExpectedSettlementDate = operationExpectedSettlementDate;
        this.advancedReceivables = advancedReceivables;
    }

    public Advancement() {
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    public BigDecimal getOperationValue() {
        return operationValue;
    }

    public void setOperationValue(BigDecimal operationValue) {
        this.operationValue = operationValue;
    }

    public Date getOperationExpectedSettlementDate() {
        return operationExpectedSettlementDate;
    }

    public void setOperationExpectedSettlementDate(Date operationExpectedSettlementDate) {
        this.operationExpectedSettlementDate = operationExpectedSettlementDate;
    }

    public List<AdvancedReceivable> getAdvancedReceivables() {
        return advancedReceivables;
    }

    public void setAdvancedReceivables(List<AdvancedReceivable> advancedReceivables) {
        this.advancedReceivables = advancedReceivables;
    }

}
