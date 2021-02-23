package br.com.tag.sdk.model.receivable.settlement;

import br.com.tag.sdk.model.BankAccount;
import br.com.tag.sdk.model.enums.DocumentType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

/***
 * Classe de retorno para consultas de liquidações
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-liquidacao-por-chave">Consulta de Liquidação por Chave</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-liquidacao-por-processkey">Consulta de Liquidações por Chave de Processo</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-liquidacao-por-referencia">Consulta de Liquidações por Referência</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-liquidacao-por-parametros">Consulta de Liquidações por Parâmetros</a>
 */
public class SettlementQueryOutput extends Settlement {

    @JsonProperty("key")
    private String key;

    @JsonProperty("isRejected")
    private Boolean isRejected;

    @JsonProperty("reasonDetails")
    private String reasonDetails;

    @JsonProperty("processKey")
    private String processKey;

    @JsonProperty("createdAt")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date createdAt;

    public SettlementQueryOutput(String key,
                                 String reference,
                                 DocumentType assetHolderDocumentType,
                                 String assetHolder,
                                 Date settlementDate,
                                 BigDecimal amount,
                                 Date settlementObligationDate,
                                 String paymentScheme,
                                 BankAccount bankAccount,
                                 Boolean isRejected,
                                 String reasonDetails,
                                 String processKey,
                                 Date createdAt) {
        super(reference, assetHolderDocumentType, assetHolder, settlementDate, amount, settlementObligationDate, paymentScheme, bankAccount);
        this.key = key;
        this.isRejected = isRejected;
        this.reasonDetails = reasonDetails;
        this.processKey = processKey;
        this.createdAt = createdAt;
    }

    public SettlementQueryOutput() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getRejected() {
        return isRejected;
    }

    public void setRejected(Boolean rejected) {
        isRejected = rejected;
    }

    public String getReasonDetails() {
        return reasonDetails;
    }

    public void setReasonDetails(String reasonDetails) {
        this.reasonDetails = reasonDetails;
    }

    public String getProcessKey() {
        return processKey;
    }

    public void setProcessKey(String processKey) {
        this.processKey = processKey;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
