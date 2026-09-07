package com.safedk.android.analytics.brandsafety;

import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;

/* JADX INFO: loaded from: classes6.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CreativeInfo f8114a;
    String b;
    String c;

    public o(CreativeInfo creativeInfo, String str) {
        this(creativeInfo, str, null);
    }

    public o(CreativeInfo creativeInfo, String str, String str2) {
        this.f8114a = creativeInfo;
        this.b = str;
        this.c = str2;
    }

    public String toString() {
        return " how ? : " + this.b + ", debugInfo : " + this.c + ", creative info : " + this.f8114a.aa();
    }
}
