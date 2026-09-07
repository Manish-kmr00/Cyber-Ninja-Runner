package com.safedk.android.analytics.brandsafety;

import com.safedk.android.utils.Logger;

/* JADX INFO: loaded from: classes6.dex */
public class h {
    private static final String d = "ClickUrlCandidate";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8101a;
    public String b;
    public String c;

    public h(long j, String str, String str2) {
        this.f8101a = 0L;
        Logger.d(d, "click URL candidate, current time: " + j + ", click URL: " + str + ", view address: " + str2);
        this.f8101a = j;
        this.b = str;
        this.c = str2;
    }

    public h(long j, String str) {
        this.f8101a = 0L;
        Logger.d(d, "click url candidate, currentTime=" + j + ", clickUrl=" + str);
        this.f8101a = j;
        this.b = str;
    }
}
