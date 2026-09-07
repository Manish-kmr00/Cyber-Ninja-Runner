package com.smaato.sdk.core;

/* JADX INFO: loaded from: classes12.dex */
public enum AdContentRating {
    MAX_AD_CONTENT_RATING_UNDEFINED(""),
    MAX_AD_CONTENT_RATING_G("G"),
    MAX_AD_CONTENT_RATING_PG("PG"),
    MAX_AD_CONTENT_RATING_T("T"),
    MAX_AD_CONTENT_RATING_MA("MA");

    private final String rating;

    AdContentRating(String str) {
        this.rating = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.rating;
    }
}
