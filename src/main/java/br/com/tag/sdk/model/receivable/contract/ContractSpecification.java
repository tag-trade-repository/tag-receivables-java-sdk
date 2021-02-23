package br.com.tag.sdk.model.receivable.contract;

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
 * Classe de especificação de contrato
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-garantia-troca-de-titularidade-por-key">Consulta de Contratos por Chave</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-garantia-ou-troca-de-titularidade-por-processkey">Consulta de Contratos por Chave de Processo</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-garantia-ou-troca-de-titularidade-por-referencia">Consulta de Contratos por Referência</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-garantia-ou-troca-de-titularidade-por-parametros">Consulta de Contratos por Parâmetros</a>
 */
public class ContractSpecification {

    @JsonProperty("expectedSettlementDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expectedSettlementDate;

    @JsonProperty("originalAssetHolderDocumentType")
    private DocumentType originalAssetHolderDocumentType;

    @JsonProperty("originalAssetHolder")
    private String originalAssetHolder;

    @JsonProperty("receivableDebtor")
    private String receivableDebtor;

    @JsonProperty("paymentScheme")
    private String paymentScheme;

    @JsonProperty("effectValue")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal effectValue;

    public ContractSpecification(Date expectedSettlementDate,
                                 DocumentType originalAssetHolderDocumentType,
                                 String originalAssetHolder,
                                 String receivableDebtor,
                                 String paymentScheme,
                                 BigDecimal effectValue) {
        this.expectedSettlementDate = expectedSettlementDate;
        this.originalAssetHolderDocumentType = originalAssetHolderDocumentType;
        this.originalAssetHolder = originalAssetHolder;
        this.receivableDebtor = receivableDebtor;
        this.paymentScheme = paymentScheme;
        this.effectValue = effectValue;
    }

    public ContractSpecification() {
    }

    public Date getExpectedSettlementDate() {
        return expectedSettlementDate;
    }

    public void setExpectedSettlementDate(Date expectedSettlementDate) {
        this.expectedSettlementDate = expectedSettlementDate;
    }

    public DocumentType getOriginalAssetHolderDocumentType() {
        return originalAssetHolderDocumentType;
    }

    public void setOriginalAssetHolderDocumentType(DocumentType originalAssetHolderDocumentType) {
        this.originalAssetHolderDocumentType = originalAssetHolderDocumentType;
    }

    public String getOriginalAssetHolder() {
        return originalAssetHolder;
    }

    public void setOriginalAssetHolder(String originalAssetHolder) {
        this.originalAssetHolder = originalAssetHolder;
    }

    public String getReceivableDebtor() {
        return receivableDebtor;
    }

    public void setReceivableDebtor(String receivableDebtor) {
        this.receivableDebtor = receivableDebtor;
    }

    public String getPaymentScheme() {
        return paymentScheme;
    }

    public void setPaymentScheme(String paymentScheme) {
        this.paymentScheme = paymentScheme;
    }

    public BigDecimal getEffectValue() {
        return effectValue;
    }

    public void setEffectValue(BigDecimal effectValue) {
        this.effectValue = effectValue;
    }
}
