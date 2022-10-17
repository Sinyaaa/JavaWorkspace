public class Document {
    protected String recordNumber;
    protected String documentTitle;

    public Document(String recordNumber, String documentTitle) {
        this.recordNumber = recordNumber;
        this.documentTitle = documentTitle;
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }
}
