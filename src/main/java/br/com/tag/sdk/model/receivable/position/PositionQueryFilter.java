package br.com.tag.sdk.model.receivable.position;

import java.util.Date;

/***
 * Classe de dados que encapsula os parâmetros para realizar uma consulta com base no titular
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/posicao-de-agenda-titular">Consulta por Titular</a>
 */
public class PositionQueryFilter {

    private String paymentScheme = null;
    private Date initialExpectedSettlementDate = null;
    private Date finalExpectedSettlementDate = null;

    public String getPaymentScheme() {
        return paymentScheme;
    }

    public void setPaymentScheme(String paymentScheme) {
        this.paymentScheme = paymentScheme;
    }

    public Date getInitialExpectedSettlementDate() {
        return initialExpectedSettlementDate;
    }

    public void setInitialExpectedSettlementDate(Date initialExpectedSettlementDate) {
        this.initialExpectedSettlementDate = initialExpectedSettlementDate;
    }

    public Date getFinalExpectedSettlementDate() {
        return finalExpectedSettlementDate;
    }

    public void setFinalExpectedSettlementDate(Date finalExpectedSettlementDate) {
        this.finalExpectedSettlementDate = finalExpectedSettlementDate;
    }

}
