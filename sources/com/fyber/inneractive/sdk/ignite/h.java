package com.fyber.inneractive.sdk.ignite;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.digitalturbine.ignite.authenticator.listeners.api.AuthenticationServiceListener;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.network.a0;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements com.digitalturbine.ignite.authenticator.listeners.api.a, AuthenticationServiceListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1850a;
    public IIgniteServiceAPI b;
    public long k;
    public String l;
    public d m;
    public com.digitalturbine.ignite.authenticator.listeners.internal.a n;
    public com.fyber.inneractive.sdk.config.global.r o;
    public l p;
    public final Bundle c = new Bundle();
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public final CopyOnWriteArrayList h = new CopyOnWriteArrayList();
    public boolean i = false;
    public boolean j = false;
    public final i d = new i(new e(this));

    public final void a(com.fyber.inneractive.sdk.config.global.r rVar) {
        this.o = rVar;
        if (TextUtils.isEmpty(this.l)) {
            return;
        }
        IAlog.a("%s : Ignite installed will init IgniteManager", "IgniteAdapter");
        com.fyber.inneractive.sdk.config.global.features.j jVar = (com.fyber.inneractive.sdk.config.global.features.j) rVar.a(com.fyber.inneractive.sdk.config.global.features.j.class);
        IAlog.a("%s : initializing ignite features", "IgniteAdapter");
        Boolean boolC = jVar.c("odt");
        this.e = boolC != null ? boolC.booleanValue() : false;
        Boolean boolC2 = jVar.c("flow");
        this.f = boolC2 != null ? boolC2.booleanValue() : false;
        Boolean boolC3 = jVar.c("updates");
        this.g = boolC3 != null ? boolC3.booleanValue() : false;
        Context context = this.f1850a;
        if (context != null) {
            boolean z = this.e;
            if (z || this.f) {
                if (this.p == null) {
                    this.j = false;
                    l lVar = new l(context, new k(), new com.fyber.inneractive.sdk.ignite.events.wrappers.a(), z, this.f, this.g, this);
                    this.p = lVar;
                    lVar.authenticate();
                }
                this.k = TimeUnit.SECONDS.toMillis(IAConfigManager.O.w.f1726a.b.a("igniteInstallTimeOutInSeconds", 15, 1));
            }
        }
    }

    public final void m() {
        d dVar = this.m;
        if (dVar != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(dVar);
            this.m = null;
        }
    }

    public final boolean n() {
        l lVar = this.p;
        return lVar != null && lVar.isConnected() && this.p.isAuthenticated();
    }

    public final boolean o() {
        l lVar = this.p;
        return lVar == null || lVar.f1221a.f();
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.a
    public final void onCredentialsRequestFailed(String str) {
        l lVar = this.p;
        if (lVar != null) {
            lVar.onCredentialsRequestFailed(str);
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.a
    public final void onCredentialsRequestSuccess(String str, String str2) {
        l lVar = this.p;
        if (lVar != null) {
            lVar.onCredentialsRequestSuccess(str, str2);
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.AuthenticationServiceListener
    public final void onIgniteServiceAuthenticated(String str) {
        this.c.putString("clientToken", str);
        IAlog.a("IgniteAdapter: onIgniteServiceAuthenticated", new Object[0]);
        com.digitalturbine.ignite.authenticator.listeners.internal.a aVar = this.n;
        if (aVar != null) {
            aVar.a();
            this.n = null;
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.AuthenticationServiceListener
    public final void onIgniteServiceAuthenticationFailed(String str) {
        this.b = null;
        a(j.FAILED_TO_AUTHENTICATE, str);
        IAlog.a("IgniteAdapter: onIgniteServiceAuthenticationFailed : error : %s", str);
        com.digitalturbine.ignite.authenticator.listeners.internal.a aVar = this.n;
        if (aVar != null) {
            aVar.a(str);
            this.n = null;
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.AuthenticationServiceListener
    public final void onIgniteServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str;
        Context context;
        IAlog.a("IgniteAdapter: onIgniteServiceConnected", new Object[0]);
        this.l = componentName.getPackageName();
        this.b = IIgniteServiceAPI.Stub.asInterface(iBinder);
        if (this.j) {
            l lVar = this.p;
            if (lVar != null) {
                lVar.authenticate();
                return;
            }
            return;
        }
        this.j = true;
        byte[] byteArray = null;
        try {
            o oVarNewBuilder = IgniteRequestOuterClass$IgniteRequest.newBuilder();
            String str2 = IAConfigManager.O.c;
            oVarNewBuilder.c();
            ((IgniteRequestOuterClass$IgniteRequest) oVarNewBuilder.b).setAppId(str2);
            String packageName = AbstractC3251o.f2370a.getPackageName();
            oVarNewBuilder.c();
            ((IgniteRequestOuterClass$IgniteRequest) oVarNewBuilder.b).setBundle(packageName);
            String version = InneractiveAdManager.getVersion();
            oVarNewBuilder.c();
            ((IgniteRequestOuterClass$IgniteRequest) oVarNewBuilder.b).setSdkVersion(version);
            String str3 = this.l;
            oVarNewBuilder.c();
            ((IgniteRequestOuterClass$IgniteRequest) oVarNewBuilder.b).setIgnitePackageName(str3);
            if (TextUtils.isEmpty(this.l) || (context = this.f1850a) == null) {
                str = null;
                oVarNewBuilder.c();
                ((IgniteRequestOuterClass$IgniteRequest) oVarNewBuilder.b).setIgniteVersionName(str);
                String strA = AbstractC3251o.a(this.f1850a);
                oVarNewBuilder.c();
                ((IgniteRequestOuterClass$IgniteRequest) oVarNewBuilder.b).setAppSignature(strA);
                byteArray = ((IgniteRequestOuterClass$IgniteRequest) oVarNewBuilder.a()).toByteArray();
            } else {
                try {
                    str = context.getPackageManager().getPackageInfo(this.l, 0).versionName;
                } catch (Exception unused) {
                    IAlog.a("Failed to resolve ignite version", new Object[0]);
                    str = null;
                }
                oVarNewBuilder.c();
                ((IgniteRequestOuterClass$IgniteRequest) oVarNewBuilder.b).setIgniteVersionName(str);
                String strA2 = AbstractC3251o.a(this.f1850a);
                oVarNewBuilder.c();
                ((IgniteRequestOuterClass$IgniteRequest) oVarNewBuilder.b).setAppSignature(strA2);
                byteArray = ((IgniteRequestOuterClass$IgniteRequest) oVarNewBuilder.a()).toByteArray();
            }
        } catch (Throwable unused2) {
            IAlog.a("Failed to build ignite request", new Object[0]);
        }
        if (byteArray != null) {
            IAConfigManager.O.s.b(new a0(new b(this), byteArray, this.o));
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.AuthenticationServiceListener
    public final void onIgniteServiceConnectionFailed(String str) {
        IAlog.a("IgniteAdapter: onIgniteServiceConnectionFailed : error : %s", str);
        a(j.FAILED_TO_BIND_SERVICE, str);
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.AuthenticationServiceListener
    public final void onOdtUnsupported() {
        l lVar;
        IAlog.f("%s: onOdtUnsupported : unsupported ignite version", "IgniteAdapter");
        if (this.f || (lVar = this.p) == null) {
            return;
        }
        lVar.destroy();
        this.p = null;
    }

    public final void a(j jVar, String str) {
        if (this.i) {
            return;
        }
        this.i = true;
        EnumC3143t enumC3143t = EnumC3143t.IGNITE_FLOW_FAILED_TO_START;
        C3146w c3146w = new C3146w((com.fyber.inneractive.sdk.response.e) null);
        c3146w.b = enumC3143t;
        c3146w.f1934a = null;
        c3146w.d = null;
        JSONObject jSONObject = new JSONObject();
        String strA = jVar.a();
        try {
            jSONObject.put("error_code", strA);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "error_code", strA);
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject.put("message", str);
            } catch (Exception unused2) {
                IAlog.f("Got exception adding param to json object: %s, %s", "message", str);
            }
        }
        c3146w.f.put(jSONObject);
        c3146w.a((String) null);
    }

    public final void a(com.digitalturbine.ignite.authenticator.listeners.internal.a aVar) {
        IAlog.a("IgniteAdapter : reconnectIgnite : with callback : " + aVar, new Object[0]);
        this.n = aVar;
        l lVar = this.p;
        if (lVar != null) {
            lVar.authenticate();
        }
    }

    public final void a(String str, g gVar) {
        String strA;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IAlog.a("Starting install timeout with %d", Long.valueOf(this.k));
        d dVar = new d(this);
        this.m = dVar;
        com.fyber.inneractive.sdk.util.r.b.postDelayed(dVar, this.k);
        if (n() && !o() && this.b != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("packageName", str);
                jSONObject.put("data", jSONObject2);
                IIgniteServiceAPI iIgniteServiceAPI = this.b;
                String string = jSONObject.toString();
                Bundle bundle = this.c;
                Bundle bundle2 = new Bundle();
                i iVar = this.d;
                c cVar = new c(this, gVar);
                iVar.getClass();
                iIgniteServiceAPI.install(string, bundle, bundle2, new s((e) iVar.f1851a, cVar));
                return;
            } catch (Exception unused) {
                IAlog.a("Failed to install app", new Object[0]);
                return;
            }
        }
        for (r rVar : this.h) {
            if (rVar != null) {
                if (o()) {
                    strA = j.SESSION_EXPIRED.a();
                } else {
                    strA = j.NOT_CONNECTED.a();
                }
                rVar.a((String) null, strA, (String) null);
            }
        }
    }
}
