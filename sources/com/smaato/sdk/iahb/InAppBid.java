package com.smaato.sdk.iahb;

/* JADX INFO: loaded from: classes12.dex */
public abstract class InAppBid {
    abstract String getJson();

    InAppBid() {
    }

    public static InAppBid create(String str) {
        if (str != null) {
            return new AutoValue_InAppBid(str);
        }
        throw new NullPointerException("'json' specified as non-null is null");
    }
}
