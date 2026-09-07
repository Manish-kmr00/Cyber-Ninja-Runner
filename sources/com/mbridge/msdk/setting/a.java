package com.mbridge.msdk.setting;

import com.safedk.android.internal.partials.MintegralNetworkBridge;
import org.json.JSONObject;

/* JADX INFO: compiled from: BCP.java */
/* JADX INFO: loaded from: classes12.dex */
public class a {
    private String e;
    private String f;
    private int g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5388a = 1;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int h = 0;

    public static a a(String str) {
        Exception e;
        a aVar;
        try {
            JSONObject jSONObjectJsonObjectInit = MintegralNetworkBridge.jsonObjectInit(str);
            aVar = new a();
            try {
                aVar.b(jSONObjectJsonObjectInit.optString("http_domain", com.mbridge.msdk.foundation.same.net.utils.d.h().h));
                aVar.c(jSONObjectJsonObjectInit.optString("tcp_domain", com.mbridge.msdk.foundation.same.net.utils.d.h().l));
                aVar.e(jSONObjectJsonObjectInit.optInt("tcp_port", com.mbridge.msdk.foundation.same.net.utils.d.h().p));
                aVar.f(jSONObjectJsonObjectInit.optInt("type", 0));
                aVar.a(jSONObjectJsonObjectInit.optInt("batch_size", 1));
                aVar.c(jSONObjectJsonObjectInit.optInt("duration", 0));
                aVar.b(jSONObjectJsonObjectInit.optInt("disable", 0));
                aVar.d(jSONObjectJsonObjectInit.optInt("e_t_l", 0));
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (Exception e3) {
            e = e3;
            aVar = null;
        }
        return aVar;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return this.h;
    }

    public void b(int i) {
        this.b = i;
    }

    public void c(int i) {
        this.c = i;
    }

    public void d(int i) {
        this.d = i;
    }

    public void e(int i) {
        this.g = i;
    }

    public void f(int i) {
        this.h = i;
    }

    public void b(String str) {
        this.e = str;
    }

    public void c(String str) {
        this.f = str;
    }

    public int a() {
        return this.f5388a;
    }

    public void a(int i) {
        if (i < 1) {
            i = 1;
        }
        this.f5388a = i;
    }
}
