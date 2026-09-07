package com.fyber.inneractive.sdk.network;

/* JADX INFO: loaded from: classes14.dex */
public enum r0 {
    EVENT_TABLE("sdk_event_"),
    ERROR_TABLE("sdk_error_");

    private final String tableName;

    r0(String str) {
        this.tableName = str;
    }

    public final String a() {
        return this.tableName;
    }
}
