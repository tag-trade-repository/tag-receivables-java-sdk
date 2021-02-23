package br.com.tag.sdk.model.receivable.settlement;

import java.util.Date;

/***
 * Classe de parâmetros para consultas parametrizadas de liquidação
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-liquidacao-por-parametros">Consulta de Liquidação por Parâmetros</a>
 */
public class SettlementQueryFilter {

    private Date startSettlementDate = null;
    private Date endSettlementDate = null;
    private String paymentScheme = null;
    private String assetHolder = null;

    public Date getStartSettlementDate() {
        return startSettlementDate;
    }

    public void setStartSettlementDate(Date startSettlementDate) {
        this.startSettlementDate = startSettlementDate;
    }

    public Date getEndSettlementDate() {
        return endSettlementDate;
    }

    public void setEndSettlementDate(Date endSettlementDate) {
        this.endSettlementDate = endSettlementDate;
    }

    public String getAssetHolder() {
        return assetHolder;
    }

    public void setAssetHolder(String assetHolder) {
        this.assetHolder = assetHolder;
    }

    public String getPaymentScheme() {
        return paymentScheme;
    }

    public void setPaymentScheme(String paymentScheme) {
        this.paymentScheme = paymentScheme;
    }

}
