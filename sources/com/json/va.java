package com.json;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class va {
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 3;
    public static final int l = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4519a;
    private String b;
    private int c;
    private Map<String, String> d;
    private int e;
    private boolean f;
    private rj g;

    public va(rj rjVar) {
        this(rjVar.e(), rjVar.g(), rjVar.a(), rjVar.b());
        this.g = rjVar;
    }

    public va(String str, String str2, Map<String, String> map, io ioVar) {
        this.c = -1;
        this.b = str;
        this.f4519a = str2;
        this.d = map;
        this.e = 0;
        this.f = false;
        this.g = null;
    }

    public void a() {
        Map<String, String> map = this.d;
        if (map != null) {
            map.clear();
        }
        this.d = null;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public boolean a(int i2) {
        return this.c == i2;
    }

    public Map<String, String> b() {
        HashMap map = new HashMap();
        map.put("demandSourceId", this.b);
        map.put("demandSourceName", this.f4519a);
        Map<String, String> map2 = this.d;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }

    public synchronized void b(int i2) {
        this.e = i2;
    }

    public rj c() {
        return this.g;
    }

    public void c(int i2) {
        this.c = i2;
    }

    public boolean d() {
        return this.f;
    }

    public int e() {
        return this.e;
    }

    public String f() {
        return this.f4519a;
    }

    public Map<String, String> g() {
        return this.d;
    }

    public String h() {
        return this.b;
    }

    public io i() {
        if (this.g != null) {
            return c().b();
        }
        return null;
    }

    public int j() {
        return this.c;
    }

    public boolean k() {
        Map<String, String> map = this.d;
        if (map == null || !map.containsKey("rewarded")) {
            return false;
        }
        return Boolean.parseBoolean(this.d.get("rewarded"));
    }
}
