package br.com.tag.sdk;

public class Constants {

    public static class Authentication {
        public static final String BASE_PATH = "/token";
    }

    public static class Endorsement {
        public static class Contract {
            public static final String BASE_PATH = "/receivable/contract";
            public static final String BASE_PATH_HISTORY = "/receivable/contract/history";
            public static final String BASE_PATH_REFERENCE = "/receivable/contract/reference";
            public static final String BASE_PATH_KEY = "/receivable/contract/key";
            public static final String BASE_PATH_PROCESS_KEY = "/receivable/contract/processkey";
        }

        public static class Advancement {
            public static final String BASE_PATH = "receivable/advancement";
        }

    }

    public static class Consent {
        public static final String BASE_PATH_OPT_IN = "/receivable/consent/optin";
        public static final String BASE_PATH_OPT_IN_KEY = "/receivable/consent/optin/%s";
        public static final String BASE_PATH_OPT_IN_CHANGE_VALIDITY = "/receivable/consent/optin/%s";
        public static final String BASE_PATH_OPT_IN_REJECT = "/receivable/consent/optin/reject";
        public static final String BASE_PATH_OPT_OUT = "/receivable/consent/optout/%s";
        public static final String BASE_PATH_OPT_IN_PARAMS = "/receivable/consent/optin/parameters";
    }

    public static class Reconciliation {
        public static final String BASE_PATH = "/receivable/reconciliation";
        public static final String BASE_PATH_KEY = "/receivable/reconciliation/key/%s";
    }

    public static class CommercialEstablishment {
        public static final String BASE_PATH = "/customer/commercialEstablishment";
        public static final String BASE_PATH_DOCUMENT_NUMBER = "/customer/commercialEstablishment/%s";
    }

    public static class Receivable {
        public static final String BASE_PATH = "/receivable";
    }

    public static class Transaction {
        public static final String BASE_PATH_TRANSACTION = "/receivable/transaction";
        public static final String BASE_PATH_TRANSACTION_KEY = "/receivable/transaction/%s";
    }

    public static class Notification {
        public static final String BASE_PATH = "/receivable/notification/";
        public static final String BASE_PATH_PROCESS_KEY = "/receivable/notification/processKey/%s";
        public static final String BASE_PATH_KEY = "/receivable/notification/key/%s";
    }

    public static class Settlement {
        public static final String BASE_PATH = "/receivable/settlement";
        public static final String BASE_PATH_REJECT = "/receivable/settlement/reject";
        public static final String BASE_PATH_PROCESS_KEY = "/receivable/settlement/processKey";
        public static final String BASE_PATH_KEY = "/receivable/settlement/key";
        public static final String BASE_PATH_REFERENCE = "/receivable/settlement/reference";
    }

    public static class Position {
        public static final String BASE_PATH_KEY = "/receivable/position/key/%s/";
        public static final String BASE_PATH_REFERENCE = "/receivable/position/reference/%s/";
        public static final String BASE_PATH_PROCESS_REFERENCE = "/receivable/position/processreference/%s/";
        public static final String BASE_PATH_ORIGINAL_ASSET_HOLDER = "/receivable/position/originalAssetHolder/%s";
        public static final String BASE_PATH_ASSET_HOLDER = "/receivable/position/assetHolder/%s";
    }
    
    public static class Services {
        public static final String ADVANCEMENT_SERVICE = "ADVANCEMENT_SERVICE";
        public static final String CONSENT_SERVICE = "CONSENT_SERVICE";
        public static final String CONTRACT_SERVICE = "CONTRACT_SERVICE";
        public static final String NOTIFICATION_SERVICE = "NOTIFICATION_SERVICE";
        public static final String POSITION_SERVICE = "POSITION_SERVICE";
        public static final String RECONCILIATION_SERVICE = "RECONCILIATION_SERVICE";
        public static final String RECEIVABLE_SERVICE = "RECEIVABLE_SERVICE";
        public static final String SETTLEMENT_SERVICE = "SETTLEMENT_SERVICE";
        public static final String TRANSACTION_SERVICE = "TRANSACTION_SERVICE";
        public static final String COMMERCIAL_ESTABLISHMENT_SERVICE = "COMMERCIAL_ESTABLISHMENT_SERVICE";
    }

}
