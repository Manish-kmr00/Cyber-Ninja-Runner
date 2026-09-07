package com.chartboost.sdk.impl;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes12.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f8 f1118a;
    public final WebView b;
    public final List<fb> c;
    public final Map<String, fb> d;
    public final String e;
    public final String f;
    public final String g;
    public final s h;

    public r(f8 f8Var, WebView webView, String str, List<fb> list, String str2, String str3, s sVar) {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.d = new HashMap();
        this.f1118a = f8Var;
        this.b = webView;
        this.e = str;
        this.h = sVar;
        if (list != null) {
            arrayList.addAll(list);
            for (fb fbVar : list) {
                this.d.put(UUID.randomUUID().toString(), fbVar);
            }
        }
        this.g = str2;
        this.f = str3;
    }

    public static r a(f8 f8Var, WebView webView, String str, String str2) {
        ld.a(f8Var, "Partner is null");
        ld.a(webView, "WebView is null");
        if (str2 != null) {
            ld.a(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new r(f8Var, webView, null, null, str, str2, s.HTML);
    }

    public String b() {
        return this.g;
    }

    public String c() {
        return this.f;
    }

    public Map<String, fb> d() {
        return Collections.unmodifiableMap(this.d);
    }

    public String e() {
        return this.e;
    }

    public f8 f() {
        return this.f1118a;
    }

    public List<fb> g() {
        return Collections.unmodifiableList(this.c);
    }

    public WebView h() {
        return this.b;
    }

    public static r a(f8 f8Var, String str, List<fb> list, String str2, String str3) {
        ld.a(f8Var, "Partner is null");
        ld.a((Object) str, "OM SDK JS script content is null");
        ld.a(list, "VerificationScriptResources is null");
        if (str3 != null) {
            ld.a(str3, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new r(f8Var, null, str, list, str2, str3, s.NATIVE);
    }

    public s a() {
        return this.h;
    }
}
