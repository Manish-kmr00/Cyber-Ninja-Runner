package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.Track;
import com.fyber.inneractive.sdk.util.c0;
import com.fyber.inneractive.sdk.util.d0;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class P implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set f1678a = null;

    @Override // com.fyber.inneractive.sdk.util.c0
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Set set = this.f1678a;
        if (set != null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                jSONArray.put((Track) it.next());
            }
        }
        d0.a(jSONObject, "track", jSONArray);
        return jSONObject;
    }
}
