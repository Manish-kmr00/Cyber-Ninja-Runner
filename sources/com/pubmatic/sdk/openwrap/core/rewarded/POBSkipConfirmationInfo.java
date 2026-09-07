package com.pubmatic.sdk.openwrap.core.rewarded;

/* JADX INFO: loaded from: classes10.dex */
public class POBSkipConfirmationInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7763a;
    private final String b;
    private final String c;
    private final String d;

    public POBSkipConfirmationInfo(String str, String str2, String str3, String str4) {
        this.f7763a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public String getCloseText() {
        return this.d;
    }

    public String getMessage() {
        return this.b;
    }

    public String getResumeText() {
        return this.c;
    }

    public String getTitle() {
        return this.f7763a;
    }
}
