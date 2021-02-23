package br.com.tag.sdk.model.receivable.consent;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/***
 * Classe para alteração da data de vigência de anuência
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/altera%C3%A7%C3%A3o-de-data-de-vig%C3%AAncia">Alteração de Data de Vigência da Anuência</a>
 */
public class ConsentValidityChangeRequest {

    @JsonProperty("startDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @JsonProperty("endDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    public ConsentValidityChangeRequest(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ConsentValidityChangeRequest() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
