package com.mbridge.msdk.setting;

import com.safedk.android.internal.partials.MintegralNetworkBridge;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventLibMonitorSetting.java */
/* JADX INFO: loaded from: classes12.dex */
public class d {
    private String f;
    private String g;
    private int h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5393a = 1;
    private int b = 1;
    private int c = 0;
    private int d = 30;
    private int e = 0;
    private int i = 0;

    public static d a(String str) {
        Exception e;
        d dVar;
        try {
            JSONObject jSONObjectJsonObjectInit = MintegralNetworkBridge.jsonObjectInit(str);
            dVar = new d();
            try {
                dVar.b(jSONObjectJsonObjectInit.optString("h_d", com.mbridge.msdk.foundation.same.net.utils.d.h().f));
                dVar.c(jSONObjectJsonObjectInit.optString("t_d", com.mbridge.msdk.foundation.same.net.utils.d.h().k));
                dVar.c(jSONObjectJsonObjectInit.optInt("t_p", com.mbridge.msdk.foundation.same.net.utils.d.h().o));
                dVar.d(jSONObjectJsonObjectInit.optInt("type", 1));
                dVar.b(jSONObjectJsonObjectInit.optInt("d_t", 30));
                dVar.a(jSONObjectJsonObjectInit.optInt("d_a", 0));
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (Exception e3) {
            e = e3;
            dVar = null;
        }
        return dVar;
    }

    public int b() {
        return this.d;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.g;
    }

    public int e() {
        return this.h;
    }

    public void b(int i) {
        this.d = i;
    }

    public void c(String str) {
        this.g = str;
    }

    public void d(int i) {
        this.i = i;
    }

    public void b(String str) {
        this.f = str;
    }

    public void c(int i) {
        this.h = i;
    }

    public int a() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }
}
