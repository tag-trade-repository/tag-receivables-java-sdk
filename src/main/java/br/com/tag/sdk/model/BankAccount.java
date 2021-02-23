package br.com.tag.sdk.model;

import br.com.tag.sdk.model.enums.AccountBankAccountType;
import br.com.tag.sdk.model.enums.DocumentType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BankAccount {

    @JsonProperty("branch")
    private String branch = null;

    @JsonProperty("account")
    private String account = null;

    @JsonProperty("accountDigit")
    private String accountDigit = null;

    @JsonProperty("accountType")
    private AccountBankAccountType accountType = null;

    @JsonProperty("ispb")
    private String ispb = null;

    @JsonProperty("documentType")
    private DocumentType documentType = null;

    @JsonProperty("documentNumber")
    private String documentNumber = null;

    public BankAccount(String branch, String account, String accountDigit, AccountBankAccountType accountType, String ispb, DocumentType documentType, String documentNumber) {
        this.branch = branch;
        this.account = account;
        this.accountDigit = accountDigit;
        this.accountType = accountType;
        this.ispb = ispb;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
    }

    public BankAccount() {
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountDigit() {
        return accountDigit;
    }

    public void setAccountDigit(String accountDigit) {
        this.accountDigit = accountDigit;
    }

    public AccountBankAccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountBankAccountType accountType) {
        this.accountType = accountType;
    }

    public String getIspb() {
        return ispb;
    }

    public void setIspb(String ispb) {
        this.ispb = ispb;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}
