package com.bytedance.sdk.openadsdk.api.model;

/* JADX INFO: loaded from: classes10.dex */
public class PAGErrorModel {
    private final String Og;
    private final int pA;

    public PAGErrorModel(int i, String str) {
        this.pA = i;
        this.Og = str;
    }

    public int getErrorCode() {
        return this.pA;
    }

    public String getErrorMessage() {
        return this.Og;
    }
}
