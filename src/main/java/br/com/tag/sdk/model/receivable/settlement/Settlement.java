package br.com.tag.sdk.model.receivable.settlement;

import br.com.tag.sdk.model.BankAccount;
import br.com.tag.sdk.model.enums.DocumentType;
import br.com.tag.sdk.utils.DecimalDeserializer;
import br.com.tag.sdk.utils.DecimalSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.util.Date;

/***
 * Classe base para liquidações
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/informe-de-liquidacao">Registro de Liquidações</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-liquidacao-por-chave">Consulta de Liquidação por Chave</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-liquidacao-por-processkey">Consulta de Liquidações por Chave de Processo</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-liquidacao-por-referencia">Consulta de Liquidações por Referência</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-liquidacao-por-parametros">Consulta de Liquidações por Parâmetros</a>
 */
public class Settlement {

    @JsonProperty("reference")
    private String reference = null;

    @JsonProperty("assetHolderDocumentType")
    private DocumentType assetHolderDocumentType = null;

    @JsonProperty("assetHolder")
    private String assetHolder = null;

    @JsonProperty("settlementDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date settlementDate = null;

    @JsonProperty("amount")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal amount = null;

    @JsonProperty("settlementObligationDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date settlementObligationDate = null;

    @JsonProperty("paymentScheme")
    private String paymentScheme = null;

    @JsonProperty("bankAccount")
    private BankAccount bankAccount = null;

    public Settlement(String reference,
                      DocumentType assetHolderDocumentType,
                      String assetHolder,
                      Date settlementDate,
                      BigDecimal amount,
                      Date settlementObligationDate,
                      String paymentScheme,
                      BankAccount bankAccount) {
        this.reference = reference;
        this.assetHolderDocumentType = assetHolderDocumentType;
        this.assetHolder = assetHolder;
        this.settlementDate = settlementDate;
        this.amount = amount;
        this.settlementObligationDate = settlementObligationDate;
        this.paymentScheme = paymentScheme;
        this.bankAccount = bankAccount;
    }

    public Settlement() {
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

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getSettlementObligationDate() {
        return settlementObligationDate;
    }

    public void setSettlementObligationDate(Date settlementObligationDate) {
        this.settlementObligationDate = settlementObligationDate;
    }

    public String getPaymentScheme() {
        return paymentScheme;
    }

    public void setPaymentScheme(String paymentScheme) {
        this.paymentScheme = paymentScheme;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

}
