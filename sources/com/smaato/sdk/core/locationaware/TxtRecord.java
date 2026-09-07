package com.smaato.sdk.core.locationaware;

/* JADX INFO: loaded from: classes11.dex */
public abstract class TxtRecord {
    public abstract String data();

    public abstract int ttl();

    public static TxtRecord create(String str, int i) {
        return new AutoValue_TxtRecord(str, i);
    }
}
