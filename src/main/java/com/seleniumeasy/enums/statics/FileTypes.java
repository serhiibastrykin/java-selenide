package com.seleniumeasy.enums.statics;

public enum FileTypes {
    TXT("text/plain"),
    PDF("application/pdf"),
    CSV("application/csv" + ", text/csv"),
    XML("application/xml" + ", text/xml"),
    JSON("application/json" + ", text/json"),
    JPEG("image/jpeg"),
    PNG("image/png"),
    BINARY("application/binary"),
    EXCEL("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
    DOCX("application/vnd.openxmlformats-officedocument.wordprocessingml.document");

    private final String fileType;

    FileTypes(String fileType) {
        this.fileType = fileType;
    }

    public String getType() {
        return fileType;
    }
}