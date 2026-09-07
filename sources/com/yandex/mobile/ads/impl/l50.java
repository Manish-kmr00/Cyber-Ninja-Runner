package com.yandex.mobile.ads.impl;

import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class l50 {
    private static final Object h = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9478a;
    private List<? extends an1> b = CollectionsKt.emptyList();
    private Map<String, String> c = MapsKt.emptyMap();
    private String d;
    private String e;
    private boolean f;
    private String g;

    public final void h() {
        this.f = true;
    }

    public final String b() {
        return this.f9478a;
    }

    public final List<an1> f() {
        return this.b;
    }

    public final Map<String, String> d() {
        return this.c;
    }

    public final String e() {
        return this.d;
    }

    public final String a() {
        return this.e;
    }

    public final boolean c() {
        return this.f;
    }

    public final void b(String str) {
        this.f9478a = str;
    }

    public final String g() {
        String str;
        synchronized (h) {
            str = this.g;
        }
        return str;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final void c(String str) {
        this.d = str;
    }

    public final void d(String str) {
        synchronized (h) {
            if (str != null) {
                if (str.length() != 0) {
                    this.g = str;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
