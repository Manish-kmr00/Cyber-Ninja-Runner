package com.json.sdk.controller;

import android.app.Activity;
import android.content.Context;
import com.json.eh;
import com.json.hg;
import com.json.mediationsdk.logger.IronLog;
import com.json.o9;
import com.json.t9;
import com.json.u9;
import com.json.v9;
import com.json.va;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class n implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hg f4327a;
    private final String b;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l.a f4328a;
        final /* synthetic */ com.ironsource.sdk.controller.f.c b;

        a(l.a aVar, com.ironsource.sdk.controller.f.c cVar) {
            this.f4328a = aVar;
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f4328a == null) {
                    return;
                }
                JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
                jSONObjectJsonObjectInit.put("success", false);
                jSONObjectJsonObjectInit.put("reason", n.this.b);
                this.f4328a.a(new com.ironsource.sdk.controller.f.a(this.b.getCom.ironsource.sdk.controller.f.b.b java.lang.String(), jSONObjectJsonObjectInit));
            } catch (JSONException e) {
                o9.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v9 f4329a;
        final /* synthetic */ va b;

        b(v9 v9Var, va vaVar) {
            this.f4329a = v9Var;
            this.b = vaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4329a.a(eh.e.RewardedVideo, this.b.h(), n.this.b);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v9 f4330a;
        final /* synthetic */ JSONObject b;

        c(v9 v9Var, JSONObject jSONObject) {
            this.f4330a = v9Var;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4330a.d(this.b.optString("demandSourceName"), n.this.b);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u9 f4331a;
        final /* synthetic */ va b;

        d(u9 u9Var, va vaVar) {
            this.f4331a = u9Var;
            this.b = vaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4331a.a(eh.e.Interstitial, this.b.h(), n.this.b);
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u9 f4332a;
        final /* synthetic */ String b;

        e(u9 u9Var, String str) {
            this.f4332a = u9Var;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4332a.c(this.b, n.this.b);
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u9 f4333a;
        final /* synthetic */ va b;

        f(u9 u9Var, va vaVar) {
            this.f4333a = u9Var;
            this.b = vaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4333a.c(this.b.h(), n.this.b);
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u9 f4334a;
        final /* synthetic */ JSONObject b;

        g(u9 u9Var, JSONObject jSONObject) {
            this.f4334a = u9Var;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4334a.b(this.b.optString("demandSourceName"), n.this.b);
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u9 f4335a;
        final /* synthetic */ va b;

        h(u9 u9Var, va vaVar) {
            this.f4335a = u9Var;
            this.b = vaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4335a.b(this.b.h(), n.this.b);
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ t9 f4336a;
        final /* synthetic */ Map b;

        i(t9 t9Var, Map map) {
            this.f4336a = t9Var;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4336a.a((String) this.b.get("demandSourceName"), n.this.b);
        }
    }

    class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ t9 f4337a;
        final /* synthetic */ JSONObject b;

        j(t9 t9Var, JSONObject jSONObject) {
            this.f4337a = t9Var;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4337a.a(this.b.optString("demandSourceName"), n.this.b);
        }
    }

    n(String str, hg hgVar) {
        this.f4327a = hgVar;
        this.b = str;
    }

    @Override // com.json.sdk.controller.l
    public void a() {
    }

    @Override // com.json.sdk.controller.l
    public void a(Activity activity) {
    }

    @Override // com.json.sdk.controller.l
    public void a(Context context) {
    }

    @Override // com.json.sdk.controller.l
    public void a(com.ironsource.sdk.controller.f.c cVar, l.a aVar) {
        a(new a(aVar, cVar));
    }

    @Override // com.json.sdk.controller.l
    public void a(va vaVar) {
    }

    @Override // com.json.sdk.controller.l
    public void a(va vaVar, Map<String, String> map, t9 t9Var) {
        if (t9Var != null) {
            a(new i(t9Var, map));
        }
    }

    @Override // com.json.sdk.controller.l
    public void a(va vaVar, Map<String, String> map, u9 u9Var) {
        if (u9Var != null) {
            a(new h(u9Var, vaVar));
        }
    }

    void a(Runnable runnable) {
        hg hgVar = this.f4327a;
        if (hgVar != null) {
            hgVar.c(runnable);
        }
    }

    @Override // com.json.sdk.controller.l
    public void a(String str, u9 u9Var) {
        if (u9Var != null) {
            a(new e(u9Var, str));
        }
    }

    @Override // com.json.sdk.controller.l
    public void a(String str, String str2, va vaVar, t9 t9Var) {
        if (t9Var != null) {
            t9Var.a(eh.e.Banner, vaVar.h(), this.b);
        }
    }

    @Override // com.json.sdk.controller.l
    public void a(String str, String str2, va vaVar, u9 u9Var) {
        if (u9Var != null) {
            a(new d(u9Var, vaVar));
        }
    }

    @Override // com.json.sdk.controller.l
    public void a(String str, String str2, va vaVar, v9 v9Var) {
        if (v9Var != null) {
            a(new b(v9Var, vaVar));
        }
    }

    @Override // com.json.sdk.controller.l
    public void a(JSONObject jSONObject) {
    }

    @Override // com.json.sdk.controller.l
    public void a(JSONObject jSONObject, t9 t9Var) {
        if (t9Var != null) {
            a(new j(t9Var, jSONObject));
        }
    }

    @Override // com.json.sdk.controller.l
    public void a(JSONObject jSONObject, u9 u9Var) {
        if (u9Var != null) {
            a(new g(u9Var, jSONObject));
        }
    }

    @Override // com.json.sdk.controller.l
    public void a(JSONObject jSONObject, v9 v9Var) {
        if (v9Var != null) {
            a(new c(v9Var, jSONObject));
        }
    }

    @Override // com.json.sdk.controller.l
    public boolean a(String str) {
        return false;
    }

    @Override // com.json.sdk.controller.l
    public void b(Context context) {
    }

    @Override // com.json.sdk.controller.l
    public void b(va vaVar) {
    }

    @Override // com.json.sdk.controller.l
    public void b(va vaVar, Map<String, String> map, u9 u9Var) {
        if (u9Var != null) {
            a(new f(u9Var, vaVar));
        }
    }

    @Override // com.json.sdk.controller.l
    public void b(JSONObject jSONObject) {
    }

    @Override // com.json.sdk.controller.l
    public void d() {
    }

    @Override // com.json.sdk.controller.l
    public void destroy() {
    }

    @Override // com.json.sdk.controller.l
    public void e() {
    }

    @Override // com.json.sdk.controller.l
    public void f() {
    }

    @Override // com.json.sdk.controller.l
    public eh.c g() {
        return eh.c.Native;
    }
}
