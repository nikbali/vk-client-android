package com.example.nibali.brat.data.entity;

public enum AttachmentType {
    PHOTO("photo"),
    VIDEO("video"),
    AUDIO("audio"),
    DOC("doc"),
    POST("wall"),
    POSTED_PHOTO("posted_photo"),
    LINK("link"),
    NOTE("note"),
    POLL("poll"),
    WIKI_PAGE("page"),
    ALBUM("album");

    private final String description;
    AttachmentType(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
