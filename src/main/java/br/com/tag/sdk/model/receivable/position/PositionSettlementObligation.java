package br.com.tag.sdk.model.receivable.position;

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
 * Classe que encapsula as obrigações de liquidação em uma consulta de posição de agenda
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-originador">Consulta por Originador</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-por-key">Consulta por Chave</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-por-process-reference">Consulta por Referência de Processo</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-por-reference">Consulta por Referência</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-titular">Consulta por Titular</a>
 */
public class PositionSettlementObligation {

    @JsonProperty("key")
    private String key;

    @JsonProperty("totalAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal totalAmount;

    @JsonProperty("settledAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal settledAmount;

    @JsonProperty("balanceAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal balanceAmount;

    @JsonProperty("committedAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal committedAmount;


    @JsonProperty("uncommittedAmount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal uncommittedAmount;

    @JsonProperty("dueDate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date dueDate;

    @JsonProperty("expectedSettlementDate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date expectedSettlementDate;

    @JsonProperty("originalHolderDocumentType")
    private DocumentType originalHolderDocumentType;

    @JsonProperty("originalAssetHolder")
    private String originalAssetHolder;

    @JsonProperty("assetHolderDocumentType")
    private DocumentType assetHolderDocumentType;

    @JsonProperty("assetHolder")
    private String assetHolder;
    @JsonProperty("lastUpdated")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSS'Z'")
    private Date lastUpdated;

    @JsonProperty("obligationType")
    private String obligationType;
    @JsonProperty("settlements")
    private List<PositionSettlement> settlements = new ArrayList<>();
    @JsonProperty("contractObligations")
    private List<PositionContractObligations> contractObligations = new ArrayList<>();

    public PositionSettlementObligation(String key,
                                        BigDecimal totalAmount,
                                        BigDecimal settledAmount,
                                        BigDecimal balanceAmount,
                                        BigDecimal committedAmount,
                                        BigDecimal uncommittedAmount,
                                        Date dueDate,
                                        Date expectedSettlementDate,
                                        DocumentType originalHolderDocumentType,
                                        String originalAssetHolder,
                                        DocumentType assetHolderDocumentType,
                                        String assetHolder,
                                        Date lastUpdated,
                                        String obligationType,
                                        List<PositionSettlement> settlements,
                                        List<PositionContractObligations> contractObligations) {
        this.key = key;
        this.totalAmount = totalAmount;
        this.settledAmount = settledAmount;
        this.balanceAmount = balanceAmount;
        this.committedAmount = committedAmount;
        this.uncommittedAmount = uncommittedAmount;
        this.dueDate = dueDate;
        this.expectedSettlementDate = expectedSettlementDate;
        this.originalAssetHolder = originalAssetHolder;
        this.assetHolderDocumentType = assetHolderDocumentType;
        this.assetHolder = assetHolder;
        this.lastUpdated = lastUpdated;
        this.obligationType = obligationType;
        this.settlements = settlements;
        this.contractObligations = contractObligations;
        this.originalHolderDocumentType = originalHolderDocumentType;
    }

    public PositionSettlementObligation() {
    }

    public DocumentType getOriginalHolderDocumentType() {
        return originalHolderDocumentType;
    }

    public void setOriginalHolderDocumentType(DocumentType originalHolderDocumentType) {
        this.originalHolderDocumentType = originalHolderDocumentType;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getOriginalAssetHolder() {
        return originalAssetHolder;
    }

    public void setOriginalAssetHolder(String originalAssetHolder) {
        this.originalAssetHolder = originalAssetHolder;
    }

    public String getObligationType() {
        return obligationType;
    }

    public void setObligationType(String obligationType) {
        this.obligationType = obligationType;
    }

    public List<PositionContractObligations> getContractObligations() {
        return contractObligations;
    }

    public void setContractObligations(List<PositionContractObligations> contractObligations) {
        this.contractObligations = contractObligations;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getSettledAmount() {
        return settledAmount;
    }

    public void setSettledAmount(BigDecimal settledAmount) {
        this.settledAmount = settledAmount;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public BigDecimal getCommittedAmount() {
        return committedAmount;
    }

    public void setCommittedAmount(BigDecimal committedAmount) {
        this.committedAmount = committedAmount;
    }

    public BigDecimal getUncommittedAmount() {
        return uncommittedAmount;
    }

    public void setUncommittedAmount(BigDecimal uncommittedAmount) {
        this.uncommittedAmount = uncommittedAmount;
    }

    public Date getExpectedSettlementDate() {
        return expectedSettlementDate;
    }

    public void setExpectedSettlementDate(Date expectedSettlementDate) {
        this.expectedSettlementDate = expectedSettlementDate;
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

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<PositionSettlement> getSettlements() {
        return settlements;
    }

    public void setSettlements(List<PositionSettlement> settlementItems) {
        this.settlements = settlementItems;
    }

}
