package com.json;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class rj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f4231a;
    private String b;
    private String c;
    private boolean d;
    private tg e;
    private Map<String, String> f;
    private io g;
    private String h;
    private boolean i;
    private boolean j;

    rj(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, String str3, Map<String, String> map, io ioVar, tg tgVar) {
        this.b = str;
        this.c = str2;
        this.f4231a = z;
        this.d = z2;
        this.f = map;
        this.g = ioVar;
        this.e = tgVar;
        this.i = z3;
        this.j = z4;
        this.h = str3;
    }

    public Map<String, String> a() {
        HashMap map = new HashMap();
        map.put("instanceId", this.b);
        map.put("instanceName", this.c);
        map.put("rewarded", Boolean.toString(this.f4231a));
        map.put("inAppBidding", Boolean.toString(this.d));
        map.put("isOneFlow", Boolean.toString(this.i));
        map.put(b9.r, String.valueOf(2));
        tg tgVar = this.e;
        map.put("width", tgVar != null ? Integer.toString(tgVar.c()) : "0");
        tg tgVar2 = this.e;
        map.put("height", tgVar2 != null ? Integer.toString(tgVar2.a()) : "0");
        tg tgVar3 = this.e;
        map.put("label", tgVar3 != null ? tgVar3.b() : "");
        map.put(b9.v, Boolean.toString(i()));
        if (this.j) {
            map.put("isMultipleAdObjects", "true");
        }
        String str = this.h;
        if (str != null) {
            map.put("adUnitId", str);
        }
        Map<String, String> map2 = this.f;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }

    public void a(io ioVar) {
        this.g = ioVar;
    }

    public void a(String str) {
        this.h = str;
    }

    public final io b() {
        return this.g;
    }

    public String c() {
        return this.h;
    }

    public Map<String, String> d() {
        return this.f;
    }

    public String e() {
        return this.b;
    }

    public String f() {
        return this.c.replaceAll("IronSource_", "");
    }

    public String g() {
        return this.c;
    }

    public tg h() {
        return this.e;
    }

    public boolean i() {
        return h() != null && h().d();
    }

    public boolean j() {
        return this.d;
    }

    public boolean k() {
        return j() || m();
    }

    public boolean l() {
        return this.j;
    }

    public boolean m() {
        return this.i;
    }

    public boolean n() {
        return this.f4231a;
    }
}
