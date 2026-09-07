package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.Vendor;
import com.fyber.inneractive.sdk.util.c0;
import com.fyber.inneractive.sdk.util.d0;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class W implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f1683a = 50;
    public Integer b = 50;
    public Set c = null;

    @Override // com.fyber.inneractive.sdk.util.c0
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        d0.a(jSONObject, "pausePct", this.f1683a);
        d0.a(jSONObject, "playPct", this.b);
        JSONArray jSONArray = new JSONArray();
        Set<Vendor> set = this.c;
        if (set != null) {
            for (Vendor vendor : set) {
                if (vendor != null) {
                    jSONArray.put(vendor);
                }
            }
        }
        d0.a(jSONObject, "vendor", jSONArray);
        return jSONObject;
    }
}
