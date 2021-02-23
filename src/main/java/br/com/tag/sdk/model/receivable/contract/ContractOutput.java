package br.com.tag.sdk.model.receivable.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Classe de output da criação de contrato
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/garantia-ou-troca-de-titularidade">Ônus e Gravames ou Alteração de Titularidade</a>
 */
public class ContractOutput {

    @JsonProperty("key")
    private String key;

    @JsonProperty("reference")
    private String reference;

    public ContractOutput(String key, String reference) {
        this.key = key;
        this.reference = reference;
    }

    public ContractOutput() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
