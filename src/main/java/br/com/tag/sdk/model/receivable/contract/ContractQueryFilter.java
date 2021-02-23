package br.com.tag.sdk.model.receivable.contract;

import java.util.Date;

/***
 * Classe de parametros para filtrar a consulta de contratos
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-garantia-ou-troca-de-titularidade-por-parametros">Consulta de Contratos por Parâmetros</a>
 */
public class ContractQueryFilter {

    private Date startContractDueDate = null;
    private Date endContractDueDate = null;
    private Date startSignatureDate = null;
    private Date endSignatureDate = null;
    private Date startCreatedAt = null;
    private Date endCreatedAt = null;
    private String assetHolder = null;

    public Date getStartContractDueDate() {
        return startContractDueDate;
    }

    public void setStartContractDueDate(Date startContractDueDate) {
        this.startContractDueDate = startContractDueDate;
    }

    public Date getEndContractDueDate() {
        return endContractDueDate;
    }

    public void setEndContractDueDate(Date endContractDueDate) {
        this.endContractDueDate = endContractDueDate;
    }

    public Date getStartSignatureDate() {
        return startSignatureDate;
    }

    public void setStartSignatureDate(Date startSignatureDate) {
        this.startSignatureDate = startSignatureDate;
    }

    public Date getEndSignatureDate() {
        return endSignatureDate;
    }

    public void setEndSignatureDate(Date endSignatureDate) {
        this.endSignatureDate = endSignatureDate;
    }

    public Date getStartCreatedAt() {
        return startCreatedAt;
    }

    public void setStartCreatedAt(Date startCreatedAt) {
        this.startCreatedAt = startCreatedAt;
    }

    public Date getEndCreatedAt() {
        return endCreatedAt;
    }

    public void setEndCreatedAt(Date endCreatedAt) {
        this.endCreatedAt = endCreatedAt;
    }

    public String getAssetHolder() {
        return assetHolder;
    }

    public void setAssetHolder(String assetHolder) {
        this.assetHolder = assetHolder;
    }

}
