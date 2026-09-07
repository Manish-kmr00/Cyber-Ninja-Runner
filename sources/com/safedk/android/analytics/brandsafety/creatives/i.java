package com.safedk.android.analytics.brandsafety.creatives;

import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: loaded from: classes8.dex */
public class i {
    private static final String b = "VastAdTagUri";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f8081a;

    public i(String str) {
        this.f8081a = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return obj.equals(this.f8081a);
        }
        return (this.f8081a == null || obj == null || !this.f8081a.equals(obj.toString())) ? false : true;
    }

    public int hashCode() {
        int iIndexOf;
        if (this.f8081a == null || (iIndexOf = this.f8081a.indexOf("//")) < 0) {
            return 0;
        }
        int iIndexOf2 = this.f8081a.indexOf(RemoteSettings.FORWARD_SLASH_STRING, iIndexOf + 2);
        if (iIndexOf2 < 0) {
            iIndexOf2 = this.f8081a.length();
        }
        return this.f8081a.substring(iIndexOf + 2, iIndexOf2).hashCode();
    }

    public String toString() {
        return this.f8081a;
    }
}
