package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.flow.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3116v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f1833a;

    public C3116v(w wVar) {
        this.f1833a = wVar;
    }

    public final void a(EnumC3144u enumC3144u, com.fyber.inneractive.sdk.ignite.m mVar) {
        w wVar = this.f1833a;
        InneractiveAdRequest inneractiveAdRequest = wVar.f1840a;
        com.fyber.inneractive.sdk.response.e eVar = wVar.b;
        com.fyber.inneractive.sdk.config.global.r rVar = wVar.c;
        JSONArray jSONArrayB = rVar != null ? rVar.b() : null;
        C3146w c3146w = new C3146w(eVar);
        c3146w.c = enumC3144u;
        c3146w.f1934a = inneractiveAdRequest;
        c3146w.d = jSONArrayB;
        JSONObject jSONObject = new JSONObject();
        String strA = mVar.a();
        try {
            jSONObject.put("ignitem", strA);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "ignitem", strA);
        }
        c3146w.f.put(jSONObject);
        c3146w.a((String) null);
    }

    public final void a(EnumC3143t enumC3143t, String str, String str2, com.fyber.inneractive.sdk.ignite.m mVar) {
        w wVar = this.f1833a;
        InneractiveAdRequest inneractiveAdRequest = wVar.f1840a;
        com.fyber.inneractive.sdk.response.e eVar = wVar.b;
        com.fyber.inneractive.sdk.config.global.r rVar = wVar.c;
        JSONArray jSONArrayB = rVar != null ? rVar.b() : null;
        C3146w c3146w = new C3146w(eVar);
        c3146w.b = enumC3143t;
        c3146w.f1934a = inneractiveAdRequest;
        c3146w.d = jSONArrayB;
        JSONObject jSONObject = new JSONObject();
        if (mVar != null) {
            String strA = mVar.a();
            try {
                jSONObject.put("ignitem", strA);
            } catch (Exception unused) {
                IAlog.f("Got exception adding param to json object: %s, %s", "ignitem", strA);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject.put("message", str);
            } catch (Exception unused2) {
                IAlog.f("Got exception adding param to json object: %s, %s", "message", str);
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject.put("error_code", str2);
            } catch (Exception unused3) {
                IAlog.f("Got exception adding param to json object: %s, %s", "error_code", str2);
            }
        }
        c3146w.f.put(jSONObject);
        c3146w.a((String) null);
    }
}
