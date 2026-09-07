package com.json;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.json.mediationsdk.IronSource;
import com.json.mediationsdk.WaterfallConfiguration;
import com.json.mediationsdk.metadata.a;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    je f3527a = new je();

    public void a(int i) {
        this.f3527a.a(fe.e0, Integer.valueOf(i));
    }

    public void a(Context context) {
        this.f3527a.a(context);
    }

    public void a(gg ggVar) {
        try {
            HashMap map = new HashMap();
            map.put(fe.D, ggVar.a());
            map.put(fe.C, ggVar.b());
            map.put(fe.S, ggVar.c());
            this.f3527a.a(map);
        } catch (Exception e) {
            o9.d().a(e);
        }
    }

    public void a(IronSource.AD_UNIT ad_unit, WaterfallConfiguration waterfallConfiguration) {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        if (waterfallConfiguration != null) {
            try {
                jSONObjectJsonObjectInit.put(fe.p1, waterfallConfiguration.getFloor());
                jSONObjectJsonObjectInit.put(fe.q1, waterfallConfiguration.getCeiling());
            } catch (JSONException e) {
                o9.d().a(e);
            }
        }
        if (jSONObjectJsonObjectInit.length() == 0) {
            this.f3527a.a(fe.o1, x2.a(ad_unit));
        } else {
            this.f3527a.a(fe.o1, jSONObjectJsonObjectInit, x2.a(ad_unit));
        }
    }

    public void a(Boolean bool) {
        this.f3527a.a(fe.P0, bool);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f3527a.a(fe.K0, str);
    }

    public void a(JSONObject jSONObject) {
        this.f3527a.a("md", (Object) jSONObject);
    }

    public void a(boolean z) {
        this.f3527a.a(fe.M0, Boolean.valueOf(z));
    }

    public void b(int i) {
        if (i >= 0) {
            this.f3527a.a(fe.O0, Integer.valueOf(i));
        }
    }

    public void b(Context context) {
        nf nfVarF = mm.S().f();
        ActivityManager.MemoryInfo memoryInfoZ = nfVarF.z(context);
        this.f3527a.a(fe.w, nfVarF.c(memoryInfoZ));
        this.f3527a.a(fe.x, nfVarF.b(memoryInfoZ));
    }

    public void b(String str) {
        this.f3527a.a(fe.F0, str);
    }

    public void b(JSONObject jSONObject) {
        this.f3527a.a(fe.a1, (Object) jSONObject);
    }

    public void b(boolean z) {
        this.f3527a.a("gpi", Boolean.valueOf(z));
    }

    public void c(int i) {
        this.f3527a.a(fe.c0, Integer.valueOf(i));
    }

    public void c(String str) {
        this.f3527a.a(fe.H0, str);
    }

    public void d(String str) {
        this.f3527a.a(a.i, str);
    }

    public void e(String str) {
        this.f3527a.a("mt", str);
    }

    public void f(String str) {
        this.f3527a.a(fe.A, str);
    }

    public void g(String str) {
        this.f3527a.a(fe.K, str);
    }

    public void h(String str) {
        this.f3527a.a("sid", str);
    }

    public void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f3527a.a(fe.b0, str);
    }
}
