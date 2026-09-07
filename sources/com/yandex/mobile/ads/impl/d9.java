package com.yandex.mobile.ads.impl;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes13.dex */
public final class d9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bg1 f8669a;
    private final WebView b;
    private final ArrayList c;
    private final HashMap d;
    private final String e;
    private final String f;
    private final String g;
    private final e9 h;

    private d9(bg1 bg1Var, String str, List list) {
        e9 e9Var = e9.d;
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        this.d = new HashMap();
        this.f8669a = bg1Var;
        this.b = null;
        this.e = str;
        this.h = e9Var;
        if (list != null) {
            arrayList.addAll(list);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                wa2 wa2Var = (wa2) it.next();
                this.d.put(UUID.randomUUID().toString(), wa2Var);
            }
        }
        this.g = null;
        this.f = null;
    }

    public final String b() {
        return this.g;
    }

    public final String c() {
        return this.f;
    }

    public final Map<String, wa2> d() {
        return Collections.unmodifiableMap(this.d);
    }

    public final String e() {
        return this.e;
    }

    public final bg1 f() {
        return this.f8669a;
    }

    public final List<wa2> g() {
        return Collections.unmodifiableList(this.c);
    }

    public final WebView h() {
        return this.b;
    }

    public static d9 a(bg1 bg1Var, String str, List list) {
        if (list != null) {
            return new d9(bg1Var, str, list);
        }
        throw new IllegalArgumentException("VerificationScriptResources is null");
    }

    public final e9 a() {
        return this.h;
    }
}
