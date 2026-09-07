package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import java.util.HashMap;

/* JADX INFO: loaded from: classes8.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8071a = "eventname";
    private static final String b = "adId";
    private HashMap<String, String> c = new HashMap<>();

    i(String str, String str2) {
        this.c.put("eventname", str);
        this.c.put("adId", str2);
    }

    void a(String str, String str2) {
        this.c.put(str, str2);
    }

    String a(String str) {
        return this.c.get(str);
    }

    String a() {
        return this.c.get("eventname");
    }

    String b() {
        return this.c.get("adId");
    }
}
