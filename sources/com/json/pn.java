package com.json;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.json.mediationsdk.logger.IronLog;
import com.json.sdk.utils.IronSourceQaProperties;
import com.json.sdk.utils.IronSourceStorageUtils;
import com.json.sdk.utils.SDKUtils;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class pn {
    private final nf b = mm.S().f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    je f4163a = new je();

    public void a() {
        JSONObject jSONObject = new JSONObject(IronSourceQaProperties.getInstance().getParameters());
        if (jSONObject.length() > 0) {
            this.f4163a.a("debug", jSONObject);
        }
    }

    public void a(Context context) {
        if (context instanceof Activity) {
            this.f4163a.a(fe.n, Boolean.valueOf(this.b.a((Activity) context)));
        }
    }

    public void a(eh.c cVar) {
        this.f4163a.a(fe.t1, Integer.valueOf(cVar.ordinal()));
    }

    public void a(List<String> list) {
        this.f4163a.a(fe.w1, list);
    }

    public void a(Map<String, JSONObject> map) {
        for (Map.Entry<String, JSONObject> entry : map.entrySet()) {
            this.f4163a.a(entry.getKey(), (Object) entry.getValue());
        }
    }

    public void a(JSONObject jSONObject) {
        this.f4163a.a(fe.l, jSONObject);
    }

    public void a(boolean z) {
        this.f4163a.a(fe.N0, Boolean.valueOf(z));
    }

    public void b() {
        String controllerConfig = SDKUtils.getControllerConfig();
        if (TextUtils.isEmpty(controllerConfig)) {
            return;
        }
        try {
            this.f4163a.a(fe.i, IronSourceNetworkBridge.jsonObjectInit(controllerConfig).opt(b9.a.q));
        } catch (JSONException e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public void b(Context context) {
        this.f4163a.a("gpi", Boolean.valueOf(dp.d(context)));
    }

    public void c() {
        this.f4163a.a("uxt", Boolean.valueOf(IronSourceStorageUtils.isUxt()));
    }

    public void d() {
        this.f4163a.a(fe.S, "8.7.0");
    }

    public void e() {
        HashMap map = new HashMap();
        map.put(fe.D, ho.f);
        map.put(fe.C, "7");
        this.f4163a.a(map);
    }
}
