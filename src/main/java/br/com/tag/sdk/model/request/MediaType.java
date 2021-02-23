package br.com.tag.sdk.model.request;

/***
 * Enum com lógica para lidar com os Media Types HTTP
 * @author 7Comm
 * @version 1.0.0
 */
public enum MediaType {

    APPLICATION_ATOM_XML("application/atom+xml"),
    APPLICATION_ATOM_XML_TYPE("application/atom+xml"),
    APPLICATION_FORM_URLENCODED("application/x-www-form-urlencoded"),
    APPLICATION_FORM_URLENCODED_TYPE("application/x-www-form-urlencoded"),
    APPLICATION_JSON("application/json"),
    APPLICATION_JSON_TYPE("application/json"),
    APPLICATION_OCTET_STREAM("application/octet-stream"),
    APPLICATION_OCTET_STREAM_TYPE("application/octet-stream"),
    APPLICATION_SVG_XML("application/svg+xml"),
    APPLICATION_SVG_XML_TYPE("application/svg+xml"),
    APPLICATION_XHTML_XML("application/xhtml+xml"),
    APPLICATION_XHTML_XML_TYPE("application/xhtml+xml"),
    APPLICATION_XML("application/xml"),
    APPLICATION_XML_TYPE("application/xml"),
    MULTIPART_FORM_DATA("multipart/form-data"),
    MULTIPART_FORM_DATA_TYPE("multipart/form-data"),
    TEXT_HTML("text/html"),
    TEXT_HTML_TYPE("text/html"),
    TEXT_PLAIN("text/plain"),
    TEXT_PLAIN_TYPE("text/plain"),
    TEXT_XML("text/xml"),
    TEXT_XML_TYPE("text/xml"),
    WILDCARD("*/*"),
    WILDCARD_TYPE("*/*");

    private final String value;

    MediaType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static MediaType fromValue(String text) {
        for (MediaType b : MediaType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

}
